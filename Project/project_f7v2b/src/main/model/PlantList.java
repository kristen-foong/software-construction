package model;

import exception.*;
import model.*;
import observer.PlantObserver;
import observer.Subject;

import java.util.*;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PlantList extends Subject {
    public ArrayList<Plant> yourPlants;

    public Season season;
//    public Map<String, Plant> plantCollection = new HashMap<String, Plant>();
//    public String user;
//    public Scanner scan;
//    public PrintWriter writer;
//    public List<String> database;
//    public String inputFile;
//    public String outputFile;

    public PlantList() {
        yourPlants = new ArrayList<>();
        season = Season.SUMMER;
//        user = "Stranger";
//        inputFile = "yourPlantList.txt";
//        outputFile = "yourPlantList.txt";
    }

    // EFFECTS: prints out the arrayList of plants
    public void printPlants() {
        if (!yourPlants.isEmpty()) {
            for (Plant p : yourPlants) {
                System.out.println(p);
            }
        } else {
            System.out.println("You have no plants.");
        }
    }

    // EFFECTS: prints out all the plants in the array.
    public String toString() {
        String output = "";
        if (!yourPlants.isEmpty()) {
            for (Plant p : yourPlants) {
                output += p.toString() + "\n";
            }
        } else {
            output = "You have no plants.";
        }
        return output;
    }


    // EFFECTS: returns the size of the list yourPlants
    public int size() {
        return yourPlants.size();
    }
//
//    // EFFECTS: Prints out the current season
//    public void getSeason() {
//        System.out.println("The season is " + season + ".");
//    }

//
//    // Run method
//    public void run() throws IOException {
//        load();
//
//        scan = new Scanner(System.in);
//        checkUser();
//        menu(); // recursive unless choice is 0
//
//        save();
//        writer.close();
//        scan.close();
//    }
//
//    // load method
//    public void load() throws IOException {
//        database = Files.readAllLines(Paths.get(inputFile));
//        if (database.isEmpty()) {
//            System.out.println("You have no plants");
//        } else {
//            for (String line : database) {
//                ArrayList<String> splitLine = splitOnSpace(line);
//                if (splitLine.contains("[flower]")) {
//                    Flower flower = new Flower(splitLine.get(0));
//                    yourPlants.add(flower);
////                    plantCollection.put(flower.getName(), flower);
//                } else {
//                    Tree tree = new Tree(splitLine.get(0));
//                    yourPlants.add(tree);
////                    plantCollection.put(tree.getName(), tree);
//                }
//            }
//        }
//        writer = new PrintWriter(outputFile,"UTF-8");
//    }
//
//    // Taken from FileWriter code example provided on EdX.
//    public ArrayList<String> splitOnSpace(String line) {
//        String[] splits = line.split(" ");
//        return new ArrayList<>(Arrays.asList(splits));
//    }
//
//    // save method
//    public void save() {
//        for (String line : database) {
//            writer.println(line);
//        }
//    }
//
//    // EFFECTS: runs a method based on user's choice
//    public void menu() {
//        getSeason();
//        getMenuOptions();
//        checkValidInput();
//        int choice = scan.nextInt();
//        if (choice != 1) {
//            if (choice == 2) {
//                printPlants();
//            } else if (choice == 3) {
//                addPlants();
//            } else {
//                System.out.println("Invalid choice. Try again: ");
//            }
//            menu();
//        }
//    }
//
//    public void checkValidInput() {
//        while (!scan.hasNextInt()) {
//            System.out.println("Input is not a number. Try again:");
//            scan.nextLine();
//        }
//    }
//
//    // EFFECTS: prints out menu options
//    public void getMenuOptions() {
//        System.out.println("What would you like to do?");
//        System.out.println("1. Exit");
//        System.out.println("2. See all plants");
//        System.out.println("3. Add a plant");
//    }
//
//    // REQUIRES: Scanner
//    // MODIFIES: User (if none)
//    // EFFECTS: Prints out the user's name, or asks for it
//    // checks if there is an existing user name, otherwise asks for one
//    public void checkUser() {
//        System.out.println("Enter your name:");
//        user = keepGettingString(); // REFACTORED
//        System.out.println("Welcome, " + user);
//    }
//    public String keepGettingString() {
//        String output = "";
//        boolean keepGoing = true;
//        while (keepGoing) {
//            String exception = "Exception thrown";
//            try {
//                output = scan.next();
//                checkLetters(output);
//                keepGoing = false;
//                exception = "No exception thrown";
//            } catch (InvalidStringException ise) {
//                System.out.println(ise.getMessage());
//                scan.nextLine();
//            } finally {
//                System.out.println(exception);
//            }
//        }
//        return output;
//    }
//
//    // EFFECTS: check that the given input has only alphabet letters
//    // returns a boolean
//    public void checkLetters(String input) throws InvalidStringException {
//        boolean isAlpha = input.matches("[a-zA-Z]+");
//        if (!isAlpha || input.isEmpty()) {
//            throw new InvalidStringException();
//        }
//        if (input.length() > 20) {
//            throw new StringTooLongException();
//        }
//    }
//
//    // searches for a certain plant in the hashmap
//    public void searchPlant() {
//        System.out.println("What plant are you looking for?");
//        String input = scan.next();
//        checkLetters(input);
//        System.out.println("Searching for your plant ...");
//        if (plantCollection.get(input) != null) {
//            System.out.println(plantCollection.get(input));
//        } else {
//            System.out.println("You don't have this plant.");
//        }
//    }
}