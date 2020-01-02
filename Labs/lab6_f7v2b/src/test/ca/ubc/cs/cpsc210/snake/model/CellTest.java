package ca.ubc.cs.cpsc210.snake.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// jUnit tests for the Cell class
class CellTest {
    private Cell testCell;

    @BeforeEach
    void runBefore() {
        testCell = new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2);
    }

    @Test
    void testScreenHorizontalCoord() {
        assertEquals(testCell.getColumn() * Cell.CELL_PIXELS, testCell.getScreenHorizontalCoord());
    }

    @Test
    void testScreenVerticalCoord() {
        assertEquals(testCell.getRow() * Cell.CELL_PIXELS, testCell.getScreenVerticalCoord());
    }

    @Test
    void testEquals() {
        Cell other = new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2);
        assertEquals(testCell, other);
    }

    @Test
    void testHashCode() {
        Cell other = new Cell(SnakeGame.BOARD_ROWS / 2, SnakeGame.BOARD_COLS / 2);
        assertEquals(testCell.hashCode(), other.hashCode());
    }
}