package model.question;

import model.question.checker.TrueFalseChecker;

// Represents a question whose answer is true or false
public class TrueFalseQuestion extends Question {

    // REQUIRES: maxMark must be >= 0
    // EFFECTS: constructs short answer question with given maximum mark, question statement
    // and correct answer
    public TrueFalseQuestion(int maxMark, String questionString, boolean correctAnswer) {
        super(maxMark, questionString, new TrueFalseChecker(correctAnswer));
    }
}
