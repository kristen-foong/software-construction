package model;

// Represents a student with an id, name, the grade in which the student is registered and bus to which
// student is assigned to travel
public class Student {

    //implemented fields
    public int id;
    public String name;
    public int grade;
    public Bus bus;

    // EFFECTS: constructs student with id, name and registered grade
    public Student(int id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getGrade() {
        return this.grade;
    }

    public Bus getAssignedBus() {
        return this.bus;
    }

    // EFFECTS: returns true if student is assigned to a bus, false otherwise
    public boolean isAssignedToBus() {
        if (this.bus != null) {
            return true;
        }
        return false;
    }

    // REQUIRES: !bus.isFull()
    // MODIFIES: this, bus
    // EFFECTS: assigns student to travel on bus
    public void assignToBus(Bus bus) {
        if (!bus.isFull()) {
            if (isAssignedToBus()) {
                Bus prevBus = getAssignedBus();
                prevBus.removeStudent(this);
            }
            bus.addStudent(this);
            this.bus = bus;
        }
    }

    // MODIFIES: this, Bus b = getAssignedBus()
    // EFFECTS: if student is assigned to a bus, removes student from assigned bus;
    // otherwise has no effect
    public void removeFromBus() {
        if (isAssignedToBus()) {
            Bus b = this.bus;
            this.bus = null;
            b.removeStudent(this);
        }
    }
}
