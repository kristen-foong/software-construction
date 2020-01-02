package starter;

import java.util.Observable;

public abstract class Offshoot extends Observable {
    private String name;

    // EFFECTS: constructs offshoot with name
    public Offshoot(String name) {
        this.name = name;
    }

    // MODIFIES: this
    // EFFECTS: optionally changes the color from red to green or vice versa
    public abstract void changeColor();

    // EFFECTS: returns name
    public String getName() {
        return this.name;
    }
}
