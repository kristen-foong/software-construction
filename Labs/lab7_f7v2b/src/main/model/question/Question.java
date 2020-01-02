package model.question;

import model.question.checker.AnswerChecker;

/**
 * Represents a quiz question. A question is composed of a mark, and a question.
 */
public abstract class Question {
    // The maximum mark that a user can get for a right answer to this question.
    private int maxMark;
    // The question string for the question.
    private String questionString;
    // A checker for this question
    private AnswerChecker checker;

    //  REQUIRES: maxMark must be >=0
    //  EFFECTS: constructs a question with given maximum mark and question statement
    public Question(int maxMark, String questionString, AnswerChecker checker) {
        this.maxMark = maxMark;
        this.questionString = questionString;
        this.checker = checker;
    }

    public int getMaxMark() {
        return maxMark;
    }

    // REQUIRES: newMark >= 0
    // EFFECTS: max mark available for this question is set to newMark
    public void setMaxMark(int newMark) {
        this.maxMark = newMark;
    }

    // EFFECTS: returns question string along with max mark that user can get for a right
    // answer to this question
    public String getQuestionString() {
        return questionString + " [" + maxMark + " points]";
    }

    // EFFECTS: returns true if answer is the correct answer to this question,
    // false otherwise
    public boolean isCorrect(String answer) {
        return checker.checkAnswer(answer);
    }
}
