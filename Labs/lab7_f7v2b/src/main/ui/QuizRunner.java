package ui;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.Question;
import model.quiz.Quiz;

import java.util.Scanner;

/**
 * The class that orchestrates the actual running of the quiz.
 * Run this class as a "Java Application" and follow instructions on the
 * Console.
 */
public class QuizRunner {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        QuizBuilder quizRunner = new QuizBuilder();
        Quiz quiz = quizRunner.getQuiz();

        runQuiz(quiz);

        String endOfQuizString = quiz.endQuiz();
        println();
        println(endOfQuizString);
        println("Thanks for taking the quiz!\n");
    }

    // EFFECTS: runs the given quiz
    private static void runQuiz(Quiz quiz) {
        while (quiz.hasMoreQuestions()) {
            Question q = quiz.getNextQuestion();

            boolean retryQuestion;
            do {
                String answer = getAnswer(q);
                retryQuestion = giveFeedback(quiz, answer);
            } while (retryQuestion);
        }
    }

    // EFFECTS: checks answer to current question in quiz and gives feedback to user;
    // returns true if user should retry current question, false otherwise
    private static boolean giveFeedback(Quiz quiz, String answer) {
        boolean retryQuestion = false;

        try {
            String feedback = quiz.submitAnswer(answer);
            if (!feedback.equals("")) {
                println(feedback);
            }
        } catch (AnswerIncorrectException e) {
            println(e.getMessage());
            retryQuestion = true;
        } catch (OutOfTriesException e) {
            println(e.getMessage());
        }

        return retryQuestion;
    }

    // EFFECTS: repeatedly prompts user for answer to question until non-empty string is entered;
    // returns the non-empty string entered by user
    private static String getAnswer(Question q) {
        String answer = "";

        while (answer.isEmpty()) {
            println();
            println(q.getQuestionString());
            print(">>> ");
            answer = getUserResponse();
        }

        return answer;
    }

    // EFFECTS: reads a line of text from standard input, trims the whitespace and returns it
    static String getUserResponse() {
        String inputLine = scanner.nextLine();
        return inputLine.trim();
    }
    
    // EFFECTS: prints string to standard output (does not issue new line)
    static void print(String str) {
        System.out.print(str);
    }

    // EFFECTS: prints new line to standard output
    static void println() {
        System.out.println();
    }

    // EFFECTS: prints string to standard output followed by new line
    static void println(String str) {
        System.out.println(str);
    }
}
