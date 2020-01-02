package model;

public class Flower extends Plant implements Pottable {

    public Flower(String name) {
        super(name);
        this.type = "flower";
    }

    public Flower(String name, SunAmount sunAmount, Season plantingSeason, String spaceNeeded) {
        super(name);
        this.sunAmount = sunAmount;
        this.plantingSeason = plantingSeason;
        this.spaceNeeded = spaceNeeded;
    }

    @Override
    // EFFECTS: returns the name of the plant and its type
    // also modifies the Java print default
    public String toString() {
        return this.name + " [" + this.type + "]";
    }

    // MODIFIES: this
    // EFFECT: set the amount of space needed
    public void setSpaceNeeded(String spaceNeeded) {
        this.spaceNeeded = spaceNeeded;
    }

    // returns the amount of space needed
    public String getSpaceNeeded() {
        return this.spaceNeeded;
    }

    // returns the name of the plant
    public String getName() {
        return this.name;
    }

    // MODIFIES: this
    // EFFECT: sets the amount of sun required
    public void setSun(SunAmount s) {
        this.sunAmount = s;
    }

    // gets the amount of sun required
    public SunAmount getSun() {
        return this.sunAmount;
    }

    // gets the best season to plant this plant
    public Season getPlantingSeason() {
        return this.plantingSeason;
    }

    // MODIFIES: this
    // EFFECT: sets the best season to plant this plant
    public void setPlantingSeason(Season s) {
        this.plantingSeason = s;
    }

}
