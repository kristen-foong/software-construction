package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.QuestionList;

public class LimitedTriesQuiz extends Quiz {

    public LimitedTriesQuiz(QuestionList questions) {
        super(questions);
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // if the answer is incorrect, decrements the max mark of the current question by one;
    // throws AnswerIncorrectException if the user should re-try the question
    // throws an OutOfTriesException if the answer is incorrect and no more
    // attempts are allowed
    public String submitAnswer(String answer) throws AnswerIncorrectException, OutOfTriesException {
        boolean correct = super.checkAnswer(answer);
        String ans = correct ? "Correct!" : "Incorrect!";
        if (ans.equals("Incorrect!")) {
            this.curQuestion.setMaxMark(this.curQuestion.getMaxMark() - 1);
            if (this.curQuestion.getMaxMark() <= 0) {
                throw new OutOfTriesException(ans);
            } else {
                throw new AnswerIncorrectException(ans);
            }
        } else {
            return ans;
        }
    }
}
