package ca.ubc.cs.cpsc210.snake.model;

// Represents a cell - a location on the board.
public class Cell {
    // size of cell in screen coordinates
    public static final int CELL_PIXELS = 30;

    private int column;   // the column that this cell lies in (first column is 0, second is 1, ...)
    private int row;      // the row that this cell lies in (first row is 0, second is 1, ...)

    // EFFECTS: constructs cell at given row and column on board
    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    // EFFECTS: returns column in which cell is located
    public int getColumn() {
        return column;
    }

    // EFFECTS: returns row in which cell is located
    public int getRow() {
        return row;
    }

    // EFFECTS: returns horizontal screen coordinate of top-left corner of cell
    public int getScreenHorizontalCoord() {
        return column * CELL_PIXELS;
    }

    // EFFECTS: returns vertical screen coordinate of top-left corner of cell
    public int getScreenVerticalCoord() {
        return row * CELL_PIXELS;
    }

    /// NOTE: don't concern yourselves with the equals() and hashCode() methods for now.
    /// We'll talk about what they do later in the course.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Cell cell = (Cell) o;

        if (column != cell.column) {
            return false;
        }
        return row == cell.row;
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        return result;
    }
}
