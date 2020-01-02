package model.question;

import model.question.checker.ShortAnswerChecker;

/**
 * A question that has a single, unambiguous, correct answer.
 */
public class ShortAnswerQuestion extends Question {

    // REQUIRES: maxMark must be >= 0
    // EFFECTS: constructs short answer question with given maximum mark, question statement
    // and correct answer
    public ShortAnswerQuestion(int maxMark, String questionString, String correctAnswer) {
        super(maxMark, questionString, new ShortAnswerChecker(correctAnswer));
    }
}
