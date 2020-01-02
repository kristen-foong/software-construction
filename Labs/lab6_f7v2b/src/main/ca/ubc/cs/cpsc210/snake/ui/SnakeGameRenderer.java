package ca.ubc.cs.cpsc210.snake.ui;

import ca.ubc.cs.cpsc210.snake.model.Cell;
import ca.ubc.cs.cpsc210.snake.model.Food;
import ca.ubc.cs.cpsc210.snake.model.SnakeGame;

import java.awt.*;
import java.awt.geom.AffineTransform;

// Renderer for snake game
class SnakeGameRenderer {
    private static final Color HEAD_COLOUR = new Color(150, 150, 10);
    private static final Color BODY_COLOUR = new Color(210, 210, 10);
    private SnakeGame game;

    // EFFECTS: game to render is set to given game
    SnakeGameRenderer(SnakeGame game) {
        this.game = game;
    }

    // MODIFIES: graphics
    // EFFECTS:  draws snake game onto graphics
    void draw(Graphics graphics) {
        drawFood(graphics);
        drawSnake(graphics);
    }

    // MODIFIES: graphics
    // EFFECTS:  draws food onto graphics
    private void drawFood(Graphics graphics) {
        final double FILL_PERCENT = 0.75;
        final int OFFSET = (int) (Cell.CELL_PIXELS * (1.0 - FILL_PERCENT)) / 2;
        final int SIZE = (int) (Cell.CELL_PIXELS * FILL_PERCENT);
        Cell foodPosition = game.getFoodPosition();

        graphics.setColor(computeColour());
        graphics.fillRect(foodPosition.getScreenHorizontalCoord() + OFFSET,
                foodPosition.getScreenVerticalCoord() + OFFSET,
                SIZE, SIZE);
    }

    // EFFECTS: computes colour of food based on nutritional value (on a linear scale
    //          of red for zero nutritional value to green for maximum nutritional value)
    private Color computeColour() {
        final double PERCENT_DECAYED = 1.0 - (double) game.getFoodNutritionalValue() / Food.INITIAL_NUTRITIONAL_VALUE;
        final int MAX_COLOUR = 255;
        final int RED = (int) (PERCENT_DECAYED * MAX_COLOUR);
        final int GREEN = MAX_COLOUR - RED;
        final int BLUE = 0;

        return new Color(RED, GREEN, BLUE);
    }

    // MODIFIES: graphics
    // EFFECTS:  draws snake onto graphics
    private void drawSnake(Graphics graphics) {
        drawBody(graphics);
        drawHead(graphics);
    }

    // MODIFIES: graphics
    // EFFECTS:  draws head onto graphics
    private void drawHead(Graphics graphics) {
        switch (game.getSnakeDirection()) {
            case LEFT:
                drawAtAngle(graphics, Math.PI / 2);
                break;
            case RIGHT:
                drawAtAngle(graphics, -Math.PI / 2);
                break;
            case UP:
                drawAtAngle(graphics, Math.PI);
                break;
            case DOWN:
                drawAtAngle(graphics, 0.0);
                break;
            default:
                break;
        }
    }

    // MODIFIES: graphics
    // EFFECTS:  draws head at given angle onto graphics
    private void drawAtAngle(Graphics graphics, double angle) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        AffineTransform savedTransform = setUpTransform(graphics2D);

        drawBackground(graphics);

        graphics2D.rotate(angle);
        drawEyes(graphics);
        graphics2D.rotate(-angle);

        undoTransform(graphics2D, savedTransform);
    }

    // MODIFIES: graphics
    // EFFECTS:  draws head background onto graphics
    private void drawBackground(Graphics graphics) {
        graphics.setColor(HEAD_COLOUR);
        graphics.fillOval(-Cell.CELL_PIXELS / 2, -Cell.CELL_PIXELS / 2, Cell.CELL_PIXELS, Cell.CELL_PIXELS);
    }

    // MODIFIES: graphics
    // EFFECTS:  draws eyes onto graphics
    private void drawEyes(Graphics graphics) {
        final int OFFSET = Cell.CELL_PIXELS / 8;
        final int EYE_DIAMETER = Cell.CELL_PIXELS / 5;

        graphics.setColor(Color.BLACK);
        graphics.fillOval(-OFFSET - EYE_DIAMETER, OFFSET, EYE_DIAMETER, EYE_DIAMETER);
        graphics.fillOval(OFFSET, OFFSET, EYE_DIAMETER, EYE_DIAMETER);
    }

    // MODIFIES: g
    // EFFECTS:  draws snake's body onto graphics
    private void drawBody(Graphics graphics) {
        graphics.setColor(BODY_COLOUR);
        for (Cell next : game.getSnakeBodyPositions()) {
            drawCell(graphics, next);
        }
    }

    // MODIFIES: g
    // EFFECTS:  draws cell onto graphics
    private void drawCell(Graphics graphics, Cell cell) {
        graphics.fillOval(cell.getScreenHorizontalCoord(), cell.getScreenVerticalCoord(),
                Cell.CELL_PIXELS, Cell.CELL_PIXELS);
    }

    // MODIFIES: graphics
    // EFFECTS:  transforms graphics so it is centred on cell
    private AffineTransform setUpTransform(Graphics2D graphics) {
        Cell head = game.getSnakeHeadPosition();

        AffineTransform savedTransform = graphics.getTransform();
        graphics.translate(head.getScreenHorizontalCoord() + Cell.CELL_PIXELS / 2,
                head.getScreenVerticalCoord() + Cell.CELL_PIXELS / 2);
        return savedTransform;
    }

    // MODIFIES: graphics
    // EFFECTS:  restores graphics to original transform
    private void undoTransform(Graphics2D graphics, AffineTransform savedTransform) {
        graphics.setTransform(savedTransform);
    }
}
