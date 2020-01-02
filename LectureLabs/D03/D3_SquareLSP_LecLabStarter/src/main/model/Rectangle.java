package main.model;

public class Rectangle {
    protected int height;
    protected int width;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    //EFFECTS: changes just the height of the rectangle
    public void setHeight(int height) {
        this.height = height;
    }

    //EFFECTS: changes just the width of the rectangle
    public void setWidth(int width) {
        this.width = width;
    }

    // EFFECTS: return the area of the rectangle
    public int getArea() {
        return height * width;
    }

    // EFFECTS: return the length of the perimeter of the rectangle
    public int getPerimeter() {
        return 2 * height + 2 * width;
    }
}
