package test;

import model.PlantList;
import model.Plant;
import exception.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.UserInput;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TestExceptions {
    public UserInput userInput;
    public PlantList plantList;
    public ArrayList<Plant> yourPlants;
    String invalidName, validName, notAlpha;

    @BeforeEach
    void runBefore() {
        userInput = new UserInput();
        plantList = userInput.plantList;
        yourPlants = plantList.yourPlants;
        invalidName = "ThisPlantDoesNotExistInAnyUniverseWhatsoever";
        validName = "Birch";
        notAlpha = "0W#(jm";
    }

    @Test
    void testStringTooLongExceptionIsThrown () {
        try {
            userInput.checkLetters(invalidName);
            fail("Did not catch the exception");
        } catch (StringTooLongException stle) {
            System.out.println("Caught: " + stle.getMessage());
        }
    }

    @Test
    void testStringTooLongExceptionNotThrown () {
        try {
            userInput.checkLetters(validName);
            System.out.println("Passed: testStringTooLongExceptionNotThrown");
        } catch (StringTooLongException stle) {
            fail("Unexpectedly thrown exception");
        }
    }

    @Test
    void testInvalidStringExceptionIsThrown() {
        try {
            userInput.checkLetters(notAlpha);
            fail("Did not catch the exception");
        } catch (InvalidStringException ise) {
            System.out.println("Caught: " + ise.getMessage());
        }
    }

    @Test
    void testInvalidStringExceptionNotThrown() {
        try {
            userInput.checkLetters(validName);
            System.out.println("Passed: invalidStringExceptionNotThrown");
        } catch (InvalidStringException ise) {
            fail("Unexpectedly thrown exception");
        }
    }
}
