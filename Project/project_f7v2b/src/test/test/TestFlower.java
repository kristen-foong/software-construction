package test;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import exception.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFlower {
    public Flower tulip, orchid;
    public Tree maple;
    public Plant holly;

    @BeforeEach
    void runBefore() {
        tulip = new Flower("Tulip");
        orchid = new Flower("Orchid",
                SunAmount.PART_SUN,
                Season.SPRING,
                "3-4 inches");
        maple = new Tree("Maple");
        holly = new Tree("Holly",
                SunAmount.PART_SHADE,
                Season.SUMMER,
                "3 feet");
    }

    @Test
    // Test the getName method
    void testGetName() {
        assertEquals("Tulip", tulip.getName());
        assertEquals("Tulip [flower]", tulip.toString());
        assertEquals("Orchid", orchid.getName());
        assertEquals("Maple", maple.getName());
        assertEquals("Holly [plant]", holly.toString());
    }

    @Test
    // Test setSun & getSun methods
    void testSetSun() {
        tulip.setSun(SunAmount.FULL_SUN);
        assertEquals(SunAmount.FULL_SUN, tulip.getSun());
        assertEquals(SunAmount.PART_SUN, orchid.getSun());
        maple.setSun(SunAmount.PART_SUN);
        assertEquals(SunAmount.PART_SUN, maple.getSun());
    }

    @Test
    // Tests setPlantingSeason & getPlantingSeason methods
    void testSetSeason() {
        tulip.setPlantingSeason(Season.AUTUMN);
        assertEquals(Season.AUTUMN, tulip.getPlantingSeason());
        assertEquals(Season.SPRING, orchid.getPlantingSeason());
        maple.setPlantingSeason(Season.SUMMER);
        assertEquals(Season.SUMMER, maple.getPlantingSeason());
    }

    @Test
    // check if plant is Pottable
    void testPottable() {
        String tulipSpace = tulip.getSpaceNeeded();
        assertTrue(!tulipSpace.isEmpty());
        orchid.setSpaceNeeded("4-6 inches");
        assertEquals("4-6 inches", orchid.getSpaceNeeded());
        assertEquals("A Lot", maple.spaceNeeded());
    }
}
