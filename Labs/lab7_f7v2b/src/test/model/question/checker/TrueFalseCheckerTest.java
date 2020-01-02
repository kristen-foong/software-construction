package model.question.checker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrueFalseCheckerTest {
    private TrueFalseChecker trueFalseChecker;

    @BeforeEach
    void runBefore() {
        trueFalseChecker = new TrueFalseChecker(true);
    }

    @Test
    void testAnswerIsTrue() {
        trueFalseChecker = new TrueFalseChecker(true);
        assertTrue(trueFalseChecker.checkAnswer("true"));
        assertFalse(trueFalseChecker.checkAnswer("false"));
    }

    @Test
    void testAnswerIsFalse() {
        trueFalseChecker = new TrueFalseChecker(false);
        assertTrue(trueFalseChecker.checkAnswer("false"));
        assertFalse(trueFalseChecker.checkAnswer("true"));
    }
}