package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrueFalseQuestionTest extends QuestionTest {
    private TrueFalseQuestion trueFalseQuestion;

    @BeforeEach
    void runBefore() {
        trueFalseQuestion = new TrueFalseQuestion(3, "1 + 1 = 2?", true);
        question = trueFalseQuestion;
    }

    @Test
    void testConstructor() {
        assertEquals(3, trueFalseQuestion.getMaxMark());
    }

    @Test
    void testQuestionString() {
        assertEquals("1 + 1 = 2? [3 points]", trueFalseQuestion.getQuestionString());
    }

    @Test
    void testCheckAnswerCorrect() {
        assertTrue(trueFalseQuestion.isCorrect("true"));
    }

    @Test
    void testCheckAnswerIncorrect() {
        assertFalse(trueFalseQuestion.isCorrect("false"));
    }
}