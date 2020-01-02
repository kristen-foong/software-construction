package ca.ubc.cs.cpsc210.snake.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// Represents a snake.
public class Snake {
    public static final int NUTRITION_TO_GROW = 50;
    private Cell head;
    private List<Cell> body;
    private Direction direction;
    private int nutritionConsumed;

    // EFFECTS: snake's head is at given position, body is empty and direction is right;
    //          snake has consumed no nutrition
    public Snake(Cell head) {
        this.head = head;
        body = new LinkedList<>();
        direction = Direction.RIGHT;
        nutritionConsumed = 0;
    }

    public Cell getPosition() {
        return head;
    }

    public Direction getDirection() {
        return direction;
    }

    public List<Cell> getBodyPositions() {
        return Collections.unmodifiableList(body);
    }

    // EFFECTS: returns true if snake head is at same position of any of the cells in the snake body;
    //          otherwise returns false
    public boolean selfIntersects() {
        return body.contains(head);
    }

    // MODIFIES: this
    // EFFECTS:  snake rotates left 90 degrees
    public void rotateLeft() {
        switch (direction) {
            case LEFT:
                direction = Direction.DOWN;
                break;
            case RIGHT:
                direction = Direction.UP;
                break;
            case UP:
                direction = Direction.LEFT;
                break;
            case DOWN:
                direction = Direction.RIGHT;
                break;
            default:
                break;
        }
    }

    // MODIFIES: this
    // EFFECTS:  snake rotates right 90 degrees
    public void rotateRight() {
        switch (direction) {
            case LEFT:
                direction = Direction.UP;
                break;
            case RIGHT:
                direction = Direction.DOWN;
                break;
            case UP:
                direction = Direction.RIGHT;
                break;
            case DOWN:
                direction = Direction.LEFT;
                break;
            default:
                break;
        }
    }

    // EFFECTS: returns length of snake (head & body)
    public int length() {
        return 1 + body.size();
    }

    // MODIFIES: this
    // EFFECTS:  snake moves one cell in current direction; if snake consumed enough nutrition to
    //           grow *before* this move, it grows by one cell and amount of nutrition needed to grow is deducted from
    //           nutrition consumed
    public void move() {
        body.add(0, new Cell(head.getRow(), head.getColumn()));

        if (canGrow()) {
            nutritionConsumed -= NUTRITION_TO_GROW;
        } else {
            body.remove(body.size() - 1);
        }

        moveHead();
    }

    // EFFECTS: return true if snake has consumed enough nutrition to grow
    public boolean canGrow() {
        return nutritionConsumed >= NUTRITION_TO_GROW;
    }

    // MODIFIES: this
    // EFFECTS:  move head one cell in current direction
    private void moveHead() {
        switch (direction) {
            case LEFT:
                head = new Cell(head.getRow(), head.getColumn() - 1);
                break;
            case RIGHT:
                head = new Cell(head.getRow(), head.getColumn() + 1);
                break;
            case UP:
                head = new Cell(head.getRow() - 1, head.getColumn());
                break;
            case DOWN:
                head = new Cell(head.getRow() + 1, head.getColumn());
                break;
            default:
                break;
        }
    }

    // REQUIRES: this.getPosition().equals(food.getPosition())
    // MODIFIES: this
    // EFFECTS:  consumes all the nutritional value in food
    public void eat(Food food) {
        nutritionConsumed += food.getNutritionalValue();
    }
}
