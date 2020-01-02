package model;

// Represents a chaperone with a name
public class Chaperone {
    private String name;

    // EFFECTS: constructs chaperone with name
    public Chaperone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
