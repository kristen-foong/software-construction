package model.question.checker;

// Checks answers to short answer questions
public class ShortAnswerChecker extends AnswerChecker {
    private String answer;

    // EFFECTS: constructs checker for given answer
    public ShortAnswerChecker(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String userResponse) {
        return answer.equalsIgnoreCase(userResponse);
    }
}
