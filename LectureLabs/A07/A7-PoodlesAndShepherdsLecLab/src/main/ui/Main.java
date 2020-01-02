package ui;

import model.GermanShepherd;
import model.Poodle;
import model.Dog;

public class Main {
    public static void main(String[] args) {
        GermanShepherd khaleesi = new GermanShepherd("Khaleesi");
        khaleesi.printSchedule();
        Poodle biff = new Poodle("Biff");
        khaleesi.addToSchedule("Conquer Westeros", 9);
        biff.addToSchedule("nap", 11);
        khaleesi.bark();
        biff.bark();
        khaleesi.defend();
        biff.prance();
        biff.printSchedule();
        khaleesi.printSchedule();
    }
}
