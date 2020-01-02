package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BusTest {

    public Bus bus;
    public int cap = 10;
    public int id = 1;

    @BeforeEach
    void runBefore() {
        bus = new Bus(id, cap);
    }

    @Test
    void testGetId() {
        assertEquals(id, bus.getId());
    }

    @Test
    void testGetCapacity() {
        assertEquals(cap, bus.getCapacity());
    }

    @Test
    void testChaperone() {
        assertFalse(bus.hasChaperone());
        Chaperone chap = new Chaperone("Steve");
        bus.setChaperone(chap);
        assertTrue(bus.hasChaperone());
        assertEquals(chap, bus.getChaperone());
    }

    @Test
    void testGetStudents() {
        assertTrue(bus.getStudents().isEmpty());
    }

    @Test
    void testIsFull() {
        assertFalse(bus.isFull());
        int grade = 5;
        for (int i = 0; i < bus.getCapacity(); i++) {
            bus.addStudent(new Student(i, "Steve", grade));
        }
        assertTrue(bus.isFull());
        bus.addStudent(new Student(cap + 1, "Jane", grade));
        assertEquals(cap, bus.getCapacity());
    }

    @Test
    void testRemove() {
        Student bob = new Student(1, "Bob", 5);
        bus.addStudent(bob);
        assertTrue(bus.students.contains(bob));
        bus.removeStudent(bob);
        assertFalse(bus.students.contains(bob));
        assertFalse(bob.isAssignedToBus());
    }

    @Test
    void testAddStudent() {
        Student bob = new Student(1, "Bob", 5);
        assertFalse(bus.students.contains(bob));
        bus.addStudent(bob);
        assertTrue(bus.students.contains(bob));
        bus.addStudent(bob);
        Bus bus2 = new Bus(2,10);
        bob.assignToBus(bus2);
        assertEquals(bus2, bob.getAssignedBus());
    }
}