package observer;

import model.Plant;

import java.util.ArrayList;

public class Subject {
    public ArrayList<PlantObserver> observers = new ArrayList<>();

    // MODIFIES: This
    // EFFECTS: Adds observers to the observer list
    public void addObserver(PlantObserver po) {
        if (!observers.contains(po)) {
            observers.add(po);
        }
    }

    // MODIFIES: This
    // EFFECTS: updates each of the observers
    public void notifyObservers(Plant plant) {
        for (PlantObserver po : observers) {
            po.update(plant);
        }
    }

}
