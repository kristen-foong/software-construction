package ca.ubc.cpsc210.paddleball.model;

import java.awt.Color;
import java.awt.Rectangle;

/*
 * Represents a ball.
 */
public class Ball {
    public static final int SIZE = 20;  // must be even integer
    public static final Color COLOR = new Color(10, 50, 188);
    private double currX;
    private double currY;

    private double deltaX;
    private double deltaY;

    // Constructs an ball
    // EFFECTS: ball is positioned at coordinates (x, y) with velocity (2.0, 2.0)
    public Ball(int x, int y) {
        this.currX = x;
        this.currY = y;
        deltaX = 2.0;
        deltaY = 2.0;
    }

    public int getCurrX() {
        return (int) currX;
    }

    public int getCurrY() {
        return (int) currY;
    }

    public double getDx() {
        return deltaX;
    }

    public double getDy() {
        return deltaY;
    }

    // Bounce ball off paddle
    // MODIFIES: this
    // EFFECTS: vertical component of ball's velocity is reversed
    public void bounceOffPaddle() {
        deltaY *= -1;
    }

    // Updates ball on clock tick
    // MODIFIES: this
    // EFFECTS:  ball is moved (dx, dy) units
    public void move() {
        currX = currX + deltaX;
        currY = currY + deltaY;

        bounceOffWalls();
    }

    // Determines if this ball has collided with the paddle
    // EFFECTS:  returns true if this ball has collided with paddle p,
    //           false otherwise
    public boolean hasCollision(Paddle p) {
        Rectangle ballBoundingRectangle = new Rectangle(getCurrX() - SIZE / 2, getCurrY() - SIZE / 2, SIZE, SIZE);
        Rectangle paddleBoundingRectangle = new Rectangle(p.getCurrX() - Paddle.DIMENSION1 / 2,
                Paddle.Y_POS - Paddle.DIMENSION2 / 2,
                Paddle.DIMENSION1,
                Paddle.DIMENSION2);
        return ballBoundingRectangle.intersects(paddleBoundingRectangle);
    }

    // Constrains ball so that it bounces off top and vertical walls
    // MODIFIES: this
    // EFFECTS: ball is constrained to bounce off top and vertical walls
    private void bounceOffWalls() {
        if (getCurrX() - SIZE / 2 < 0) {
            currX = SIZE / 2;
            deltaX *= -1;
        } else if (getCurrX() + SIZE / 2 > PBG.DIMENSION1) {
            currX = PBG.DIMENSION1 - SIZE / 2;
            deltaX *= -1;
        } else if (getCurrY() - SIZE / 2 < 0) {
            currY = SIZE / 2;
            deltaY *= -1;
        }
    }
}
