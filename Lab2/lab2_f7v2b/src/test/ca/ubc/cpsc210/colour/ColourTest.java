package ca.ubc.cpsc210.colour;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ColourTest {
    Colour red, green, blue, gray, black;

    @BeforeEach
    void runBefore() {
        red = new Colour(255,0,0);
        green = new Colour(0,255,0);
        blue = new Colour(0,0,255);
        gray = new Colour(100,100,100);
        black = new Colour(0,0,0);
    }

    @Test
    void testIsGreyScale() {
        assertEquals(255, red.getR());
        assertEquals(255, green.getG());
        assertEquals(255, blue.getB());
        assertFalse(red.isGreyScale());
        assertFalse(green.isGreyScale());
        assertFalse(blue.isGreyScale());
        assertTrue(gray.isGreyScale());
        assertTrue(black.isGreyScale());
    }

    @Test
    void testToHex() {
        assertEquals("ff0000", red.toHex());
        assertEquals("ff00", green.toHex());
        assertEquals("ff", blue.toHex());
        assertEquals("0", black.toHex());
    }
}