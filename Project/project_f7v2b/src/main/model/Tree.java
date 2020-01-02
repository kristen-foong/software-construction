package model;

public class Tree extends Plant {

    public Tree(String name) {
        super(name);
        this.type = "tree";
        this.spaceNeeded = "A Lot";
    }

    public Tree(String name, SunAmount sunAmount, Season plantingSeason, String spaceNeeded) {
        super(name);
        this.sunAmount = sunAmount;
        this.plantingSeason = plantingSeason;
        this.spaceNeeded = spaceNeeded;
    }

    @Override
    // EFFECT: print out the plant name
    public String toString() {
        return this.name + " [" + this.type + "]";
    }

    // returns the name of the plant
    public String getName() {
        return this.name;
    }

    // MODIFIES:this
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

    // returns the amount of space needed
    public String spaceNeeded() {
        return this.spaceNeeded;
    }

}
