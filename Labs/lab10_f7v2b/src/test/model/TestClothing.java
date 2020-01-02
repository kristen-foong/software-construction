package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Printer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestClothing {
    private List<String> worn;

    @BeforeEach
    void runBefore() {
        worn = new ArrayList<>();
        Printer.reset();
    }

    @Test
    void testMakeOnePieceOfWearableClothingWithNothingOnIt() {
        worn.add("clothing on ");
        Clothing c = new Clothing("clothing");
        c.display("");
        assertEquals(worn, Printer.getPrinted());
    }

    @Test
    void testMakeOnePieceOfWearableAccessory() {
        worn.add("accessory on ");
        Accessory a = new Accessory("accessory");
        a.display("");
        assertEquals(worn, Printer.getPrinted());
    }

    @Test
    void testPutAnAccessoryOnAPieceOfClothing() {
        Clothing c = new Clothing("clothing");
        worn.add("clothing on ");
        Accessory a = new Accessory("accessory");
        worn.add("accessory on clothing");
        c.add(a);
        c.display("");
        assertEquals(worn, Printer.getPrinted());
    }

    @Test
    void testPutAPieceOfClothingOnAPieceOfClothing() {
        Clothing c = new Clothing("clothing");
        worn.add("clothing on ");
        Clothing c2 = new Clothing("clothing");
        worn.add("clothing on clothing");
        c.add(c2);
        c.display("");
        assertEquals(worn, Printer.getPrinted());
    }
}
