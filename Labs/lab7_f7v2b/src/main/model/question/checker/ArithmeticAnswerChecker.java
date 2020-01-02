package model.question.checker;

public class ArithmeticAnswerChecker extends AnswerChecker {
    private int answer;

    public ArithmeticAnswerChecker(int answer) {
        this.answer = answer;
    }

    @Override
    public boolean checkAnswer(String userResponse) {
        int response = 0;
        try {
            response = Integer.parseInt(userResponse);
            if (answer == response) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
