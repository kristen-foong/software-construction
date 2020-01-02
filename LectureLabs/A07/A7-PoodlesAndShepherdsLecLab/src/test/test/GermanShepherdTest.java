package test;

import model.GermanShepherd;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GermanShepherdTest {
    GermanShepherd buffy;

    @BeforeEach
    public void setup(){
        buffy = new GermanShepherd("Buffy");
    }

    @Test
    public void testConstructor(){
        String startingSchedule = "Buffy's schedule: [free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free]";
        assertEquals(startingSchedule,buffy.printSchedule());
    }

    @Test
    public void testAddToSchedule(){
        String expectedSchedule = "Buffy's schedule: [free, free, free, free, Kill Vampires, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free]";
        buffy.addToSchedule("Kill Vampires", 4);
        assertEquals(expectedSchedule, buffy.printSchedule());
    }

    @Test
    public void testBark(){
        String expected = "woof woof\ngrrrrr\nwoof woof";
        assertEquals(expected,buffy.bark());
    }

    @Test
    public void testDefend(){
        String expected = "I AM PROTECTING YOU!!!";
        assertEquals(expected, buffy.defend());
    }
    @Test
    public void testGreet(){
        String expected = "Woof Woof!" + "\n" + "waiting for a treat!";
        assertEquals(expected, buffy.greet());
    }
}
