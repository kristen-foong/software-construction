package test;

import model.*;
import model.PlantList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestPlantList {
    public PlantList plantList;
    public ArrayList<Plant> yourPlants;
    Plant petunia, cosmos, maple;

    @BeforeEach
    void runBefore() {
        plantList = new PlantList();
        yourPlants = plantList.yourPlants;
        petunia = new Flower("Petunia");
        cosmos = new Flower("Cosmos",
                SunAmount.FULL_SUN,
                Season.AUTUMN,
                "12 - 18 inches apart");
        maple = new Tree("Maple");
    }

    @Test
    // Test the addPlant method
    // Check that plants are added into the arrayList
    void testAddPlant() {
        yourPlants.add(petunia);
        yourPlants.add(cosmos);
        yourPlants.add(maple);
        assertTrue(yourPlants.contains(petunia));
        assertTrue(yourPlants.contains(cosmos));
        assertTrue(yourPlants.contains(maple));
    }

    @Test
    // Test the size method
    void testSize() {
        assertEquals(0, plantList.size());
        yourPlants.add(petunia);
        yourPlants.add(cosmos);
        yourPlants.add(maple);
        assertEquals(3, plantList.size());
    }

    @Test
    // test print plant method
    void testPrintPlants() {
        assertEquals(0, plantList.size());
        plantList.printPlants();
        plantList.toString();
        yourPlants.add(maple);
        plantList.printPlants();
        plantList.toString();
    }
}
