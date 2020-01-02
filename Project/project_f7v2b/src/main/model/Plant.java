package model;

import observer.PlantObserver;

public abstract class Plant implements PlantObserver {
    public String name = "";
    protected SunAmount sunAmount;
    protected Season plantingSeason;
    protected String spaceNeeded;
    protected String type;

    public Plant(String name) {
        this.name = name;
        this.sunAmount = SunAmount.UNKNOWN;
        this.plantingSeason = Season.UNKNOWN;
        this.spaceNeeded = "Unknown";
        this.type = "plant";
    }

    // print out the plant name
    public abstract String toString();

    // returns the name of the plant
    public abstract String getName();

    @Override
    // MODIFIES:
    // EFFECT: prints out an update
    public void update(Plant plant) {
        System.out.println(plant.getName() + " has been added.");
    }

}
