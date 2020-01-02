package model.quiz;

import model.question.Question;
import model.question.QuestionList;
import model.question.ShortAnswerQuestion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class QuizTest {
    protected Quiz quiz;

    @Test
    void testConstructor() {
        assertEquals(0, quiz.getMarkSoFar());
        assertTrue(quiz.hasMoreQuestions());
    }

    // EFFECTS: returns a question list containing two short answer questions
    protected QuestionList generateQuestionList() {
        QuestionList questionList = new QuestionList();

        Question q1 = new ShortAnswerQuestion(4, "What planet are we on?", "Earth");
        Question q2 = new ShortAnswerQuestion(2, "What country are we in?", "Canada");

        questionList.addQuestion(q1);
        questionList.addQuestion(q2);

        return questionList;
    }
}