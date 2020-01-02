package ca.ubc.cs.cpsc210.snake.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


// jUnit tests for SnakeGame class
class SnakeGameTest {
    private SnakeGame testSnakeGame;

    @BeforeEach
    void runBefore() {
        testSnakeGame = new SnakeGame();
    }

    @Test
    void testIsGameOverMoveRight() {
        setSnakeDirection(Direction.RIGHT);
        Cell snakePosition = testSnakeGame.getSnakeHeadPosition();
        int distanceToRightWall = SnakeGame.BOARD_COLS - snakePosition.getColumn();

        for(int i = 0; i < distanceToRightWall - 1; i++) {
            testSnakeGame.update();
        }

        assertFalse(testSnakeGame.isOver());

        testSnakeGame.update();

        assertTrue(testSnakeGame.isOver());
    }

    @Test
    void testIsGameOverMoveLeft() {
        setSnakeDirection(Direction.LEFT);
        Cell snakePosition = testSnakeGame.getSnakeHeadPosition();
        int distanceToLeftWall = snakePosition.getColumn();

        for(int i = 0; i < distanceToLeftWall - 1; i++) {
            testSnakeGame.update();
        }

        assertFalse(testSnakeGame.isOver());

        testSnakeGame.update();

        assertTrue(testSnakeGame.isOver());
    }

    @Test
    void testIsGameOverMoveDown() {
        setSnakeDirection(Direction.DOWN);
        Cell snakePosition = testSnakeGame.getSnakeHeadPosition();
        int distanceToBottomWall = SnakeGame.BOARD_ROWS - snakePosition.getRow();

        for(int i = 0; i < distanceToBottomWall - 1; i++) {
            testSnakeGame.update();
        }

        assertFalse(testSnakeGame.isOver());

        testSnakeGame.update();

        assertTrue(testSnakeGame.isOver());
    }

    @Test
    void testIsGameOverMoveUp() {
        setSnakeDirection(Direction.UP);
        Cell snakePosition = testSnakeGame.getSnakeHeadPosition();
        int distanceToTopWall = snakePosition.getRow();

        for(int i = 0; i < distanceToTopWall - 1; i++) {
            testSnakeGame.update();
        }

        assertFalse(testSnakeGame.isOver());

        testSnakeGame.update();

        assertTrue(testSnakeGame.isOver());
    }

    @Test
    void testIsGameOverSnakeSelfIntersects() {
        while(testSnakeGame.getSnakeLength() < 5) {
            eatFood();
        }

        for (int count = 0; count < 3; count++) {
            testSnakeGame.rotateSnakeRight();
            testSnakeGame.update();
        }

        assertTrue(testSnakeGame.isOver());
    }

    @Test
    void testRotateSnakeLeft() {
        setSnakeDirection(Direction.UP);
        testSnakeGame.rotateSnakeLeft();
        assertEquals(Direction.LEFT, testSnakeGame.getSnakeDirection());
    }

    @Test
    void testRotateSnakeRight() {
        setSnakeDirection(Direction.UP);
        testSnakeGame.rotateSnakeRight();
        assertEquals(Direction.RIGHT, testSnakeGame.getSnakeDirection());
    }

    @Test
    void testSnakeGrowsWhenEating() {
        while(testSnakeGame.getSnakeLength() == 1) {
            eatFood();
        }

        assertTrue(testSnakeGame.getSnakeLength() > 1);
        assertEquals(testSnakeGame.getSnakeLength(), 1 + testSnakeGame.getSnakeBodyPositions().size());
    }

    @Test
    void testNewFoodCreatedWhenEaten() {
        eatFood();
        assertNotEquals(testSnakeGame.getFoodPosition(), testSnakeGame.getSnakeHeadPosition());
        assertEquals(Food.INITIAL_NUTRITIONAL_VALUE, testSnakeGame.getFoodNutritionalValue());
    }

    // MODIFIES: this
    // EFFECTS:  move snake to cell containing food so that food is eaten by snake
    private void eatFood() {
        Cell foodPosition = testSnakeGame.getFoodPosition();
        Cell snakePosition = testSnakeGame.getSnakeHeadPosition();
        int rowDiff = foodPosition.getRow() - snakePosition.getRow();
        int colDiff = foodPosition.getColumn() - snakePosition.getColumn();

        if (rowDiff > 0) {
            moveSnake(rowDiff, Direction.DOWN);
        }
        else if (rowDiff < 0) {
            moveSnake(-rowDiff, Direction.UP);
        }

        if (colDiff > 0) {
            moveSnake(colDiff, Direction.RIGHT);
        }
        else if (colDiff < 0) {
            moveSnake(-colDiff, Direction.LEFT);
        }
    }

    // MODIFIES: this
    // EFFECTS: update game so that snake moves given number of steps in given direction
    private void moveSnake(int steps, Direction direction) {
        setSnakeDirection(direction);
        for (int i = 0; i < steps; i++)
            testSnakeGame.update();
    }

    // MODIFIES: this
    // EFFECTS:  rotates snake until its direction is d
    private void setSnakeDirection(Direction d) {
        while (testSnakeGame.getSnakeDirection() != d)
            testSnakeGame.rotateSnakeLeft();
    }
}