package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortAnswerQuestionTest extends QuestionTest {
    private ShortAnswerQuestion shortAnswerQuestion;

    @BeforeEach
    void runBefore() {
        shortAnswerQuestion = new ShortAnswerQuestion(5, "What colour is the sky?", "blue");
        question = shortAnswerQuestion;
    }

    @Test
    void testConstructor() {
        assertEquals(5, shortAnswerQuestion.getMaxMark());
    }

    @Test
    void testQuestionString() {
        assertEquals("What colour is the sky? [5 points]", shortAnswerQuestion.getQuestionString());
    }

    @Test
    void testCheckAnswerCorrect() {
        assertTrue(shortAnswerQuestion.isCorrect("blue"));
    }

    @Test
    void testCheckAnswerIncorrect() {
        assertFalse(shortAnswerQuestion.isCorrect("black"));
    }
}