package model.question;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

abstract class QuestionTest {
    protected Question question;

    @Test
    void testChangeMark() {
        question.setMaxMark(5);
        assertEquals(5, question.getMaxMark());
    }
}