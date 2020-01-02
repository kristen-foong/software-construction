package model.question.checker;

// Represents an answer checker
public abstract class AnswerChecker {
    // EFFECTS: returns true if user response is the correct answer, false otherwise
    public abstract boolean checkAnswer(String userResponse);
}
