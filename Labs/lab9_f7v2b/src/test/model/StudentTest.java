package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    public Student jane;
    public Bus bus;

    @BeforeEach
    void runBefore() {
        jane = new Student(1, "Jane", 5);
        bus = new Bus(1, 10);
    }

    @Test
    void testGetters() {
        assertEquals(1, jane.getId());
        assertEquals("Jane", jane.getName());
        assertEquals(5, jane.getGrade());
        assertEquals(null, jane.getAssignedBus());
    }

    @Test
    void testAssignToBus() {
        assertEquals(null, jane.getAssignedBus());
        jane.assignToBus(bus);
        assertEquals(bus, jane.getAssignedBus());
        for(int i = 0; i < bus.getCapacity(); i++) {
            bus.students.add(new Student(i, "Helen", 5));
        }
        jane.assignToBus(bus);
        assertNull(jane.getAssignedBus());
    }

    @Test
    void removeFromBus() {
        jane.assignToBus(bus);
        assertEquals(bus, jane.getAssignedBus());
        Bus bus2 = new Bus(1, 10);
        jane.assignToBus(bus2);
        assertEquals(bus2, jane.getAssignedBus());
        jane.removeFromBus();
        assertEquals(null, jane.getAssignedBus());
    }
}