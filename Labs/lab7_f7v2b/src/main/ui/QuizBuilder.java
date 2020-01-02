package ui;

import model.question.*;
import model.quiz.InstantFeedbackQuiz;
import model.quiz.LimitedTriesQuiz;
import model.quiz.Quiz;
import model.quiz.UnlimitedTriesQuiz;

import static ui.QuizRunner.print;
import static ui.QuizRunner.println;

// Builds a quiz based on user input
class QuizBuilder {
    private Quiz quiz;

    // EFFECTS: generates a list of questions and builds a quiz based on user input
    QuizBuilder() {
        QuestionList questionList = getQuestions();
        quiz = buildQuiz(questionList);
    }

    // EFFECTS: returns the quiz
    Quiz getQuiz() {
        return quiz;
    }

    // EFFECTS: returns a list of questions
    private QuestionList getQuestions() {
        print("Welcome to the quiz!\n");

        Question q1 = new ShortAnswerQuestion(4, "What planet are we on?", "Earth");
        Question q2 = new TrueFalseQuestion(2, "True or False: fruits and veggies are good for you.", true);
        QuestionList questionList = new QuestionList();
        questionList.addQuestion(q1);
        questionList.addQuestion(q2);

        // Un-comment next four lines to interactively check ArithmeticQuestion:
        Question q3 = new ArithmeticQuestion(6, ArithmeticQuestion.Operation.ADDITION, 5, 2);
        Question q4 = new ArithmeticQuestion(6, ArithmeticQuestion.Operation.MULTIPLICATION, 5, 3);
        questionList.addQuestion(q3);
        questionList.addQuestion(q4);

        return questionList;
    }

    // EFFECTS: returns quiz built from questions in qList
    private Quiz buildQuiz(QuestionList questionList) {
        Quiz quiz = null;

        do {
            println("Enter a number for the type of quiz:");
            println("1 : Instant feedback quiz.");
            // Uncomment lines below as you complete the implementation of UnlimitedTriesQuiz and LimitedTriesQuiz
            println("2 : Unlimited tries quiz.");
            println("3 : Limited tries quiz.");

            print(">>> ");

            String questionType = QuizRunner.getUserResponse();
            if (questionType.equals("1")) {
                quiz = new InstantFeedbackQuiz(questionList);
            } else if (questionType.equals("2")) {
                quiz = new UnlimitedTriesQuiz(questionList);
            } else if (questionType.equals("3")) {
                quiz = new LimitedTriesQuiz(questionList);
            }
        } while (quiz == null);
        return quiz;
    }
}
