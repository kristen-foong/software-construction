package ui;

import model.Accessory;
import model.Clothing;

public class Main {
    public static void main(String[] args) {
        Clothing uniform = new Clothing("uniform");
        Clothing apron = new Clothing("apron");
        Accessory belt = new Accessory("belt");
        Clothing jacket = new Clothing("jacket");
        Accessory nametag = new Accessory("name tag");
        Accessory scarf = new Accessory("scarf");
        uniform.add(belt);
        uniform.add(jacket);
        jacket.add(nametag);
        jacket.add(scarf);
        uniform.add(apron);
        uniform.display("Barista");
    }
}

