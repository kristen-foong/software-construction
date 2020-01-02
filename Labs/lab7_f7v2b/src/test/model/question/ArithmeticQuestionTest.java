package model.question;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticQuestionTest extends QuestionTest {
    public ArithmeticQuestion aq, aq2, aq3;

    @BeforeEach
    void runBefore() {
        aq = new ArithmeticQuestion(2, ArithmeticQuestion.Operation.ADDITION, 1, 1);
        aq2 = new ArithmeticQuestion(2, ArithmeticQuestion.Operation.SUBTRACTION, 2, 1);
        aq3 = new ArithmeticQuestion(2, ArithmeticQuestion.Operation.MULTIPLICATION, 1, 1);
        question = aq;
    }

    @Test
    void testConstructor() {
        assertEquals(2, aq.getMaxMark());
        assertEquals(2, aq2.getMaxMark());
        assertEquals(2, aq3.getMaxMark());
    }

    @Test
    void testQuestionString() {
        assertEquals("1 + 1 = ? [2 points]", aq.getQuestionString());
        assertEquals("2 - 1 = ? [2 points]", aq2.getQuestionString());
        assertEquals("1 * 1 = ? [2 points]", aq3.getQuestionString());
    }

    @Test
    void testCheckAnswerCorrect() {
        assertTrue(aq.isCorrect("2"));
        assertTrue(aq2.isCorrect("1"));
        assertTrue(aq3.isCorrect("1"));
    }

    @Test
    void testCheckAnswerIncorrect() {
        assertFalse(aq.isCorrect("5"));
        assertFalse(aq2.isCorrect("3"));
        assertFalse(aq2.isCorrect("2"));
    }
}
