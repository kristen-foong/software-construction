package model.quiz;

import model.question.QuestionList;

/**
 * Represents a Quiz that provides as much feedback to the user as possible.
 */
public class InstantFeedbackQuiz extends Quiz {

    // REQUIRES: questions cannot be an empty list
    // EFFECTS: constructs quiz with given list of questions
    public InstantFeedbackQuiz(QuestionList questions) {
        super(questions);
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string
    @Override
    public String submitAnswer(String answer) {
        boolean correct = super.checkAnswer(answer);

        return correct ? "Correct!" : "Incorrect!";
    }
}
