package ca.ubc.cs.cpsc210.snake.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// jUnit tests for Snake class
class SnakeTest {
    private Snake testSnake;

    @BeforeEach
    void runBefore() {
        testSnake = new Snake(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2));
    }

    @Test
    void testConstructor() {
        assertEquals(1, testSnake.length());
        assertFalse(testSnake.canGrow());
    }

    @Test
    void testRotateLeft() {
        setSnakeDirection(testSnake, Direction.RIGHT);
        testSnake.rotateLeft();
        assertEquals(Direction.UP, testSnake.getDirection());
        testSnake.rotateLeft();
        assertEquals(Direction.LEFT, testSnake.getDirection());
        testSnake.rotateLeft();
        assertEquals(Direction.DOWN, testSnake.getDirection());
        testSnake.rotateLeft();
        assertEquals(Direction.RIGHT, testSnake.getDirection());
    }

    @Test
    void testRotateRight() {
        setSnakeDirection(testSnake, Direction.RIGHT);
        testSnake.rotateRight();
        assertEquals(Direction.DOWN, testSnake.getDirection());
        testSnake.rotateRight();
        assertEquals(Direction.LEFT, testSnake.getDirection());
        testSnake.rotateRight();
        assertEquals(Direction.UP, testSnake.getDirection());
        testSnake.rotateRight();
        assertEquals(Direction.RIGHT, testSnake.getDirection());
    }

    @Test
    void testMoveRight() {
        setSnakeDirection(testSnake, Direction.RIGHT);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 1), testSnake.getPosition());
    }

    @Test
    void testMoveLeft() {
        setSnakeDirection(testSnake, Direction.LEFT);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 - 1), testSnake.getPosition());
    }

    @Test
    void testMoveUp() {
        setSnakeDirection(testSnake, Direction.UP);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 - 1, SnakeGame.BOARD_COLS / 2), testSnake.getPosition());
    }

    @Test
    void testMoveDown() {
        setSnakeDirection(testSnake, Direction.DOWN);
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2 + 1, SnakeGame.BOARD_COLS / 2), testSnake.getPosition());
    }

    @Test
    void testMoveBody() {
        setSnakeDirection(testSnake, Direction.RIGHT);
        growBodyByTwo();
        testSnake.move();
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 3), testSnake.getPosition());

        List<Cell> body = testSnake.getBodyPositions();
        assertEquals(2, body.size());
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 2), body.get(0));
        assertEquals(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 1), body.get(1));
    }

    @Test
    void testGrowOnFeed() {
        Food food = new Food(testSnake.getPosition(), Snake.NUTRITION_TO_GROW);
        testSnake.eat(food);
        assertEquals(1, testSnake.length());
        assertTrue(testSnake.canGrow());

        testSnake.move();
        assertEquals(2, testSnake.length());
        assertFalse(testSnake.canGrow());
    }

    @Test
    void testGrowOnceOverMultipleFeeds() {
        Food food = new Food(testSnake.getPosition(), Snake.NUTRITION_TO_GROW / 2 + 1);
        testSnake.eat(food);
        assertFalse(testSnake.canGrow());
        testSnake.eat(food);

        assertEquals(1, testSnake.length());
        assertTrue(testSnake.canGrow());

        testSnake.move();
        assertEquals(2, testSnake.length());
        assertFalse(testSnake.canGrow());
    }

    @Test
    void testGrowMultipleTimesOverMultipleFeeds() {
        Food food = new Food(testSnake.getPosition(), Snake.NUTRITION_TO_GROW / 2 + 1);
        testSnake.eat(food);
        assertFalse(testSnake.canGrow());
        testSnake.eat(food);
        assertTrue(testSnake.canGrow());
        assertEquals(1, testSnake.length());

        testSnake.move();

        assertEquals(2, testSnake.length());
        assertFalse(testSnake.canGrow());

        testSnake.eat(food);
        testSnake.eat(food);
        assertTrue(testSnake.canGrow());

        testSnake.move();
        assertEquals(3, testSnake.length());
        assertFalse(testSnake.canGrow());
    }

    @Test
    void testGetBodyPositions() {
        growBodyByTwo();
        testSnake.rotateRight();
        growBodyByTwo();
        List<Cell> snakeBody = testSnake.getBodyPositions();
        assertEquals(4, snakeBody.size());

        List<Cell> expected = new LinkedList<>();
        expected.add(new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2));
        expected.add(0, new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 1));
        expected.add(0, new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2 + 2));
        expected.add(0, new Cell(SnakeGame.BOARD_ROWS / 2 + 1, SnakeGame.BOARD_COLS / 2 + 2));
        assertEquals(expected, snakeBody);

        testSnake.move();
        expected.add(0, new Cell(SnakeGame.BOARD_ROWS / 2 + 2, SnakeGame.BOARD_COLS / 2 + 2));
        expected.remove(expected.size() - 1);
        assertEquals(expected, testSnake.getBodyPositions());
    }

    @Test
    void testSelfIntersects() {
        growBodyByTwo();
        testSnake.rotateRight();
        growBodyByTwo();
        testSnake.rotateRight();
        testSnake.move();
        assertFalse(testSnake.selfIntersects());
        testSnake.rotateRight();
        testSnake.move();
        assertFalse(testSnake.selfIntersects());
        testSnake.rotateRight();
        testSnake.move();
        assertTrue(testSnake.selfIntersects());
    }

    // EFFECTS: rotate snake so that it is facing in direction d
    private void setSnakeDirection(Snake snake, Direction d) {
        while (snake.getDirection() != d)
            snake.rotateLeft();
    }

    // MODIFIES: this
    // EFFECTS:  get snake to eat enough food so that its body has length 2
    private void growBodyByTwo() {
        Food food = new Food(testSnake.getPosition(), 2 * Snake.NUTRITION_TO_GROW);
        testSnake.eat(food);
        testSnake.move();
        testSnake.move();
    }
}