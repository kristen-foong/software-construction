package model.question.checker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ShortAnswerCheckerTest {
    private ShortAnswerChecker shortAnswerChecker;

    @BeforeEach
    void runBefore() {
        shortAnswerChecker = new ShortAnswerChecker("Earth");
    }

    @Test
    void testCaseMatch() {
        assertTrue(shortAnswerChecker.checkAnswer("Earth"));
    }

    @Test
    void testCaseInsensitiveMatch() {
        assertTrue(shortAnswerChecker.checkAnswer("eArTh"));
    }

    @Test
    void testCaseMisMatch() {
        assertFalse(shortAnswerChecker.checkAnswer("erth"));
    }
}