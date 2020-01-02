package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

// Represents a bus having an id, capacity, chaperone and set of students assigned to travel on bus
public class Bus {

    //implement fields
    public int id;
    public int capacity;
    public Chaperone chaperone;
    public boolean hasChaperone = false;
    public Set<Student> students;

    // EFFECTS: constructs bus with id and capacity
    public Bus(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.students = new HashSet<Student>(capacity);
    }

    public int getId() {
        return this.id;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public Chaperone getChaperone() {
        return this.chaperone;
    }

    // EFFECTS: returns true if bus has a chaperone assigned, false otherwise
    public boolean hasChaperone() {
        return this.hasChaperone;
    }

    // EFFECTS: returns an unmodifiable set of students assigned to travel on this bus
    public Set<Student> getStudents() {
        return this.students;
    }

    // MODIFIES: this
    // EFFECTS: assigns the chaperone for this bus
    public void setChaperone(Chaperone chaperone) {
        this.chaperone = chaperone;
        this.hasChaperone = true;
    }

    // EFFECTS: returns true if bus is full, false otherwise
    public boolean isFull() {
        if (students.size() >= capacity) {
            return true;
        }
        return false;
    }

    // REQUIRES: !isFull()
    // MODIFIES: this, student
    // EFFECTS: adds student to this bus
    public void addStudent(Student student) {
        if (!students.contains(student)) {
            if (!isFull()) {
                student.removeFromBus();
                students.add(student);
                student.bus = this;
            }
        }
    }

    // MODIFIES: this, student
    // EFFECTS: removes student from this bus
    public void removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            student.removeFromBus();
        }
    }
}
