package model;

import ui.Printer;

import java.util.ArrayList;

public class Clothing extends Wearable {

    public ArrayList<Wearable> clothingList;

    public Clothing(String name) {
        super(name);
        clothingList = new ArrayList<>();
    }

    public void add(Wearable c) {
        clothingList.add(c);
    }

    public void display(String onTopOf) {
        super.display(onTopOf);
        for (Wearable w : clothingList) {
            w.display(this.name);
        }
    }
}
