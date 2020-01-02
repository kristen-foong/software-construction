package model.question.checker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArithmeticAnswerCheckerTest {
    private ArithmeticAnswerChecker aaChecker;

    @BeforeEach
    void runBefore() {
        aaChecker = new ArithmeticAnswerChecker(1);
    }

    @Test
    void testAnswerIsCorrect() {
        aaChecker = new ArithmeticAnswerChecker(1);
        assertTrue(aaChecker.checkAnswer("1"));
    }

    @Test
    void testAnswerIsIncorrect() {
        aaChecker = new ArithmeticAnswerChecker(1);
        assertFalse(aaChecker.checkAnswer("5"));
    }

    @Test
    void testAnswerInvalid() {
        aaChecker = new ArithmeticAnswerChecker(1);
        assertFalse(aaChecker.checkAnswer("one"));
        assertFalse(aaChecker.checkAnswer("0.123"));
    }
}