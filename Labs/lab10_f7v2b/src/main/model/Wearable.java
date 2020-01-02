package model;

import ui.Printer;

// Represents a wearable item
public abstract class Wearable {
    protected String name;

    // EFFECTS: constructs a wearable item with the given name
    public Wearable(String name) {
        this.name = name;
    }

    // EFFECTS: displays the result of placing this wearable on top of an item named onTopOf
    public void display(String onTopOf) {
        Printer.print(onTopOf, name);
    }
}
