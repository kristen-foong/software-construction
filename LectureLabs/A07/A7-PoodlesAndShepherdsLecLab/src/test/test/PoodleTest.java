package test;

import model.Poodle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PoodleTest {
    Poodle voldemort;

    @BeforeEach
    public void setup(){
        voldemort = new Poodle("Voldmort");
    }

    @Test
    public void testConstructor(){
        String startingSchedule = "Voldmort's schedule: [free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free]";
        assertEquals(startingSchedule,voldemort.printSchedule());
    }

    @Test
    public void testAddToSchedule(){
        String expectedSchedule = "Voldmort's schedule: [free, free, free, Take Over Wizarding World, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free, free]";
        voldemort.addToSchedule("Take Over Wizarding World", 3);
        assertEquals(expectedSchedule, voldemort.printSchedule());
    }

    @Test
    public void testBark(){
        String expected = "yip yip yip";
        assertEquals(expected,voldemort.bark());
    }

    @Test
    public void testPrance(){
        String expected = "I'm fancy!";
        assertEquals(expected, voldemort.prance());
    }
    @Test
    public void testGreet(){
        String expected = "yap yap!"+"\n"+"waiting for a treat!";
        assertEquals(expected, voldemort.greet());
    }
}
