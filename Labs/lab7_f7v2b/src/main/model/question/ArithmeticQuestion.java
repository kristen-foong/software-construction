package model.question;

import model.question.checker.ArithmeticAnswerChecker;

// Represents an arithmetic question
public class ArithmeticQuestion extends Question {

    public enum Operation { ADDITION, SUBTRACTION, MULTIPLICATION }

    // REQUIRES: maxMark must be >= 0
    // EFFECTS: constructs short answer question with given maximum mark, question statement
    // and correct answer
    public ArithmeticQuestion(int maxMark, Operation op, int first, int sec) {
        super(maxMark, getQuestionString(op, first, sec), new ArithmeticAnswerChecker(getAnswer(op, first, sec)));
    }

    public static String getQuestionString(Operation operation, int firstOp, int secondOp) {
        String op = "";
        if (operation == Operation.ADDITION) {
            op = "+";
        } else if (operation == Operation.SUBTRACTION) {
            op = "-";
        } else {
            op = "*";
        }
        String questionString = "What is " + firstOp + " " + op + " " + secondOp + " ?";
        return questionString;
    }

    public static int getAnswer(Operation operation, int firstOp, int secondOp) {
        int correctAnswer = 0;
        if (operation == Operation.ADDITION) {
            correctAnswer = firstOp + secondOp;
        } else if (operation == Operation.SUBTRACTION) {
            correctAnswer = firstOp - secondOp;
        } else {
            correctAnswer = firstOp * secondOp;
        }
        return correctAnswer;
    }
}
