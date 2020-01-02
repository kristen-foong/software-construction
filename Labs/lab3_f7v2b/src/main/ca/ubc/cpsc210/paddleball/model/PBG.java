package ca.ubc.cpsc210.paddleball.model;

import java.awt.event.KeyEvent;
import java.util.Random;

/*
 * Represents a paddle Ball game.
 */
public class PBG {
    public static final int DIMENSION1 = 800;
    public static final int DIMENSION2 = 600;
    private static final Random RND = new Random();

    private Ball ballObject;
    private Paddle paddleObject;
    private boolean stop;

    // Constructs a Paddle Ball Game
    // EFFECTS:  creates Ball at random location at top of screen
    public PBG() {
        setUp();
    }

    public Paddle getPaddle() {
        return paddleObject;
    }

    public Ball getBall() {
        return ballObject;
    }

    // Is game over?
    // EFFECTS: returns true if game is over, false otherwise
    public boolean isOver() {
        return stop;
    }

    // Updates the game on clock tick
    // MODIFIES: this
    // EFFECTS:  updates Ball, paddle and game over status
    public void update() {
        ballObject.move();
        paddleObject.move();

        checkHitSomething();
        checkstyle();
    }

    // Responds to key press codes
    // MODIFIES: this
    // EFFECTS:  turns paddle and resets game (if game over) in response to
    //           given key pressed code
    public void keyPressed(int keyCode) {
        if (keyCode == KeyEvent.VK_R && stop) {
            setUp();
        } else if (keyCode == KeyEvent.VK_X) {
            System.exit(0);
        } else {
            paddleControl(keyCode);
        }
    }

    // Sets / resets the game
    // MODIFIES: this
    // EFFECTS:  clears list of missiles and invaders, initializes tank
    private void setUp() {
        ballObject = new Ball(RND.nextInt(PBG.DIMENSION1), Ball.SIZE / 2);
        paddleObject = new Paddle(DIMENSION1 / 2);
        stop = false;
    }

    // Controls the paddle
    // MODIFIES: this
    // EFFECTS: changes direction of paddle in response to key code
    private void paddleControl(int keyCode) {
        if (keyCode == KeyEvent.VK_KP_LEFT || keyCode == KeyEvent.VK_LEFT) {
            paddleObject.moveLeft();
        } else if (keyCode == KeyEvent.VK_KP_RIGHT || keyCode == KeyEvent.VK_RIGHT) {
            paddleObject.moveRight();
        }
    }

    // Checks for collision between Ball and paddle
    // MODIFIES: this
    // EFFECTS:  bounces Ball if it collides with paddle
    private void checkHitSomething() {
        if (ballObject.hasCollision(paddleObject)) {
            ballObject.bounceOffPaddle();
        }
    }

    // Is game over? (Has Ball hit ground?)
    // MODIFIES: this
    // EFFECTS:  if Ball has hit ground, game is marked as over
    private void checkstyle() {
        if (ballObject.getCurrY() > DIMENSION2) {
            stop = true;
        }
    }
}
