package test.model;

import main.model.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSquare {
    protected Square s;

    @BeforeEach
    public void setup() {
        s = new Square(20);
    }

    @Test
    public void testSetWidth() {
        s.resize(10);
        assertEquals(100, s.getArea());
        assertEquals(40, s.getPerimeter());
    }

    @Test
    public void testSetHeight() {
        s.resize(10);
        assertEquals(100, s.getArea());
        assertEquals(40, s.getPerimeter());
    }
}
