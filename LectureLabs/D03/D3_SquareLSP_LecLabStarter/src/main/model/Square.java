package main.model;

public class Square {
    private Rectangle innerRectangle;

    public Square(int side) {
        innerRectangle = new Rectangle(side, side);
    }
//
//    //EFFECTS: changes both height and width of the rectangle
//    public void setDimensions(int height) {
//        innerRectangle.setHeight(height);
//        innerRectangle.setWidth(height);
//    }

    public void resize(int side) {
        innerRectangle.setHeight(side);
        innerRectangle.setWidth(side);
    }


    // EFFECTS: return the area of the rectangle
    public int getArea() {
        return innerRectangle.getArea();
    }

    // EFFECTS: return the length of the perimeter of the rectangle
    public int getPerimeter() {
        return innerRectangle.getPerimeter();
    }
}

