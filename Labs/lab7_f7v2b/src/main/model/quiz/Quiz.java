package model.quiz;

import model.exceptions.AnswerIncorrectException;
import model.exceptions.OutOfTriesException;
import model.question.Question;
import model.question.QuestionList;

/**
 * Represent a quiz that has a list of questions and keeps track of an ongoing quiz:
 * mark so far, the next question to show to the user.
 */
public abstract class Quiz {
    // The list of questions in this quiz
    protected QuestionList questions;
    // The index of the next question to show to the user.
    private int nextQuestion;
    // The user's mark so far.
    private int markSoFar;
    // Maximum marks available for this quiz
    private int maxMark;
    // The current question that is displayed to the user.
    protected Question curQuestion;

    // REQUIRES: questions cannot be an empty list
    // EFFECTS: constructs quiz with given list of questions
    public Quiz(QuestionList questions) {
        this.questions = questions;
        this.markSoFar = 0;
        this.nextQuestion = 0;
        this.maxMark = questions.getMaxMark();
        this.curQuestion = null;
    }

    // EFFECTS: returns mark earned so far
    public int getMarkSoFar() {
        return markSoFar;
    }

    // EFFECTS: returns maximum number of marks initially available for quiz
    // (i.e. before any marks for a question are reduced for incorrect answers)
    public int getMaxMark() {
        return maxMark;
    }

    // REQUIRES: hasMoreQuestions()
    // MODIFIES: this
    // EFFECTS: returns next question in quiz
    public Question getNextQuestion() {
        Question ret = questions.getQuestion(nextQuestion);
        this.nextQuestion += 1;
        curQuestion = ret;
        return ret;
    }

    // EFFECTS: returns whether or not curQuestion is the last question.
    public boolean hasMoreQuestions() {
        return (nextQuestion < this.questions.length());
    }

    // MODIFIES: this
    // EFFECTS: returns a string providing feedback to the user on their performance in the quiz
    public String endQuiz() {
        return "Your final mark is: " + markSoFar + " out of " + getMaxMark();
    }

    // MODIFIES: this
    // EFFECTS: checks the answer to the current question, updates marks earned and
    //          returns true if the answer is correct, and false otherwise.
    protected boolean checkAnswer(String answer) {
        if (this.curQuestion.isCorrect(answer)) {
            markSoFar += curQuestion.getMaxMark();
            return true;
        }
        return false;
    }

    // MODIFIES: this
    // EFFECTS: submit an answer to the current question and return feedback string;
    // optionally modifies the maximum number of marks available for current question;
    // throws AnswerIncorrectException if the user should re-try the question;
    // throws OutOfTriesException if user has used up all attempts to answer the question.
    public abstract String submitAnswer(String answer)
            throws AnswerIncorrectException, OutOfTriesException;
}
