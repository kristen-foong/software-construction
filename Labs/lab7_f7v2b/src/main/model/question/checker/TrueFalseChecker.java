package model.question.checker;

// Checks answers to true/false questions
public class TrueFalseChecker extends AnswerChecker {
    private boolean answer;

    // EFFECTS: constructs checker for given answer
    public TrueFalseChecker(boolean answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String userResponse) {
        return answer == Boolean.parseBoolean(userResponse);
    }
}
