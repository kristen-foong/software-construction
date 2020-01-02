package ui;

import java.util.ArrayList;
import java.util.List;

/*** DO NOT ALTER THIS CLASS! ***/

// Represents a printer that records what has been printed to the screen
public class Printer {
    private static List<String> printed = new ArrayList<>();

    // EFFECTS: prints a string of the form:
    //          itemName on onTopOf
    //          to the screen and records that this string has been printed.
    //          So ui.Printer.print("jacket", "name tag") will print the following to the screen
    //          "name tag on jacket"
    //          and record that this string was printed to the screen
    public static void print(String onTopOf, String itemName) {
        String toPrint = itemName + " on " + onTopOf;
        System.out.println(toPrint);
        printed.add(toPrint);
    }

    public static List<String> getPrinted() {
        return printed;
    }

    // EFFECTS: clears recorded output
    public static void reset() {
        printed.clear();
    }
}

