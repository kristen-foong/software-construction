package test.model;

import main.model.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRectangle {
    protected Rectangle r;

    @BeforeEach
    public void setup() {
        r = new Rectangle(20, 20);
    }

    @Test
    public void testGetArea() {
        assertEquals(400, r.getArea());
    }

    @Test
    public void testGetPerimeter() {
        assertEquals(80, r.getPerimeter());
    }

    @Test
    public void testSetWidth() {
        r.setWidth(10);
        assertEquals(200, r.getArea());
        assertEquals(60, r.getPerimeter());
    }

    @Test
    public void testSetHeight() {
        r.setHeight(10);
        assertEquals(200, r.getArea());
        assertEquals(60, r.getPerimeter());
    }
}
