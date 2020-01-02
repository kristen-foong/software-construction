package ca.ubc.cpsc210.paddleball.test;

import ca.ubc.cpsc210.paddleball.model.Ball;
import ca.ubc.cpsc210.paddleball.model.Paddle;
import ca.ubc.cpsc210.paddleball.model.PBG;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
 * Unit tests for the Ball class.
 */
class TestBall {
    private static final int XLOC = PBG.DIMENSION1 / 2;
    private static final int YLOC = 50;
    private Ball Ball;

    @BeforeEach
    void runBefore() {
        Ball = new Ball(XLOC, YLOC);
    }

    @Test
    void testgetCurrX() {
        assertEquals(XLOC, Ball.getCurrX());
    }

    @Test
    void testgetCurrY() {
        assertEquals(YLOC, Ball.getCurrY());
    }

    @Test
    void testUpdate() {
        final int NUM_UPDATES = 4;

        Ball.move();
        assertEquals((int) (XLOC + Ball.getDx()), Ball.getCurrX());
        assertEquals((int) (YLOC + Ball.getDy()), Ball.getCurrY());

        for (int count = 1; count < NUM_UPDATES; count++) {
            Ball.move();
        }

        assertEquals((int) (XLOC + NUM_UPDATES * Ball.getDx()), Ball.getCurrX());
        assertEquals((int) (YLOC + NUM_UPDATES * Ball.getDy()), Ball.getCurrY());
    }

    @Test
    void testbounceOffPaddle() {
        double xVel = Ball.getDx();
        double yVel = Ball.getDy();
        Ball.bounceOffPaddle();
        assertEquals(xVel, Ball.getDx());
        assertEquals(-yVel, Ball.getDy());
    }

    @Test
    void testCollideWith() {
        Paddle p = new Paddle(XLOC);

        Ball b = new Ball(0, 0);
        assertFalse(b.hasCollision(p));

        b = new Ball(p.getCurrX(), Paddle.Y_POS);
        assertTrue(b.hasCollision(p));

        b = new Ball(p.getCurrX() + Paddle.DIMENSION1 / 2 + Ball.SIZE / 2 - 1, Paddle.Y_POS);
        assertTrue(b.hasCollision(p));

        b = new Ball(p.getCurrX() + Paddle.DIMENSION1 / 2 + Ball.SIZE / 2, Paddle.Y_POS);
        assertFalse(b.hasCollision(p));

        b = new Ball(p.getCurrX() - Paddle.DIMENSION1 / 2 - Ball.SIZE / 2 + 1, Paddle.Y_POS);
        assertTrue(b.hasCollision(p));

        b = new Ball(p.getCurrX() - Paddle.DIMENSION1 / 2 - Ball.SIZE / 2, Paddle.Y_POS);
        assertFalse(b.hasCollision(p));

        b = new Ball(p.getCurrX(), Paddle.Y_POS - Paddle.DIMENSION2 / 2 - Ball.SIZE / 2 + 1);
        assertTrue(b.hasCollision(p));

        b = new Ball(p.getCurrX(), Paddle.Y_POS - Paddle.DIMENSION2 / 2 - Ball.SIZE / 2);
        assertFalse(b.hasCollision(p));
    }
}
