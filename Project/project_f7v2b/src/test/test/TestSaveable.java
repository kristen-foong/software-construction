package test;

import model.Flower;
import model.Plant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.PlantList;
import ui.UserInput;

import java.io.IOException;
import java.io.PrintWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

public class TestSaveable {
    public UserInput userInput;
    public PlantList plantList;
    public ArrayList<Plant> yourPlants;
    public Plant petunia;

    @BeforeEach
    void runBefore() {
        userInput = new UserInput();
        plantList =  userInput.plantList;
        yourPlants = plantList.yourPlants;
        petunia = new Flower("Petunia");
    }

    @Test
    // test the load function
    void testLoad() throws IOException {
        userInput.inputFile = "plantDatabase.txt";
        userInput.load();
        assertEquals(yourPlants.get(0).toString(), "Holly [tree]");
        assertEquals(yourPlants.get(1).toString(), "Tulip [flower]");
    }

    @Test
    // test that save method works
    void testSave() throws IOException {
        userInput.load();
        yourPlants.add(petunia);
        yourPlants.add(petunia);
        yourPlants.add(petunia);
        userInput.save();
        for (String line : userInput.database) {
            assertEquals("Petunia", line);
        }
    }

}
