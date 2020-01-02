package ca.ubc.cpsc210.paddleball.model;

import java.awt.Color;

/**
 * Represents a paddle
 */
public class Paddle {
    public static final int DIMENSION1 = 26;  // must be even integer
    public static final int DIMENSION2 = 10;
    public static final int DX = 3;
    public static final int Y_POS = PBG.DIMENSION2 - 40;
    public static final Color COLOR = new Color(250, 222, 54);

    private int whichWay;
    private int currX;

    // Construct a paddle.
    // EFFECTS: places paddle at position (x, Y_POS) moving right.
    public Paddle(int xcoord) {
        this.currX = xcoord;
        whichWay = 1;
    }

    public int getCurrX() {
        return currX;
    }

    // Paddle moves to right
    // MODIFIES: this
    // EFFECTS: paddle is moving right
    public void moveRight() {
        whichWay = 1;
    }

    // Paddle moves to left
    // MODIFIES: this
    // EFFECTS: paddle is moving left
    public void moveLeft() {
        whichWay = -1;
    }

    // Updates the paddle on clock tick
    // MODIFIES: this
    // EFFECTS:  paddle is moved DX units in whatever direction it is facing and is
    //           constrained to remain within boundaries of game
    public void move() {
        currX = currX + whichWay * DX;
        checkWall();
    }

    // Constrains paddle so that it doesn't travel off sides of screen
    // MODIFIES: this
    // EFFECTS: paddle is constrained to remain within vertical boundaries of game
    private void checkWall() {
        if (currX - DIMENSION1 / 2 < 0) {
            currX = DIMENSION1 / 2;
        } else if (currX + DIMENSION1 / 2 > PBG.DIMENSION1) {
            currX = PBG.DIMENSION1 - DIMENSION1 / 2;
        }
    }
}
