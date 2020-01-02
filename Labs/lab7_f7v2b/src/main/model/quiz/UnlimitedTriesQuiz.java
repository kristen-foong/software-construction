package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.question.QuestionList;

public class UnlimitedTriesQuiz extends Quiz {
    public int attempts = 1;

    public UnlimitedTriesQuiz(QuestionList questions) {
        super(questions);
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // does not modify max mark of current question;
    // throws AnswerIncorrectException if the user should re-try the question;
    public String submitAnswer(String answer) throws AnswerIncorrectException {
        boolean correct = super.checkAnswer(answer);
        String ans = correct ? "Correct!" : "Incorrect!";
        if (ans.equals("Incorrect!")) {
            attempts++;
            throw new AnswerIncorrectException(ans);
        } else {
            return ans;
        }
    }

    // EFFECTS: returns number of attempts taken to answer questions so far
    public int getNumAttempts() {
        return this.attempts;
    }

    @Override
    // MODIFIES: this
    // EFFECTS: returns a string providing feedback to the user on their performance in the quiz
    public String endQuiz() {
        return "It took you " + this.getNumAttempts() + " attempts to answer "
                + this.questions.length() + " questions correctly.";
    }
}
