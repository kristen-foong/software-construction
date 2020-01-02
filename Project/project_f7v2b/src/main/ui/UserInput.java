package ui;

import exception.*;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UserInput extends JPanel implements Loadable, Saveable  {
    public static PlantList plantList;
    public static ArrayList<Plant> yourPlants;
    //    public Map<String, Plant> plantCollection = new HashMap<String, Plant>();
    public String user;
    public Scanner scan;
    public Season season;
    public PrintWriter writer;
    public static List<String> database;
    public String inputFile;
    public String outputFile;

    private JTextField input;
    private JLabel output;
    private JLabel instruction;
    private JLabel userMessage;
    private JButton seePlants;
    private JButton addAPlant;
    private JButton deleteButton;
    private JButton flowerButton;
    private JButton treeButton;

    public UserInput() {
        season = Season.SUMMER;
        inputFile = "yourPlantList.txt";
        outputFile = "yourPlantList.txt";
        plantList = new PlantList();
        yourPlants = plantList.yourPlants;
        instruction = new JLabel("Enter your name: ");
        userMessage = new JLabel();
        input = new JTextField(20);
        input.addActionListener(new UserNameListener());
        output = new JLabel("Output: ");
        add(instruction);
        add(input);
        add(userMessage);
        setPreferredSize(new Dimension(350,299));
        setBackground(Color.PINK);
    }

    // Run method
    // EFFECTS: calls the other methods to start program
    public void run() throws IOException {
        load();

//        scan = new Scanner(System.in);
//        checkUser();
        // menu(); // recursive unless choice is 0

//        scan.close();
        save();
        writer.close();
    }

    // load method
    // MODIFIES: This
    // EFFECTS: loads data from the file and adds it to the array list
    public void load() throws IOException {
        database = Files.readAllLines(Paths.get(inputFile));
        if (database.isEmpty()) {
            System.out.println("You have no plants");
        } else {
            for (String line : database) {
                ArrayList<String> splitLine = splitOnSpace(line);
                if (splitLine.contains("[flower]")) {
                    Flower flower = new Flower(splitLine.get(0));
                    yourPlants.add(flower);
                } else {
                    Tree tree = new Tree(splitLine.get(0));
                    yourPlants.add(tree);
                }
            }
        }
        writer = new PrintWriter(outputFile,"UTF-8");
    }

    // Taken from FileWriter code example provided on EdX.
    // MODIFIES: line
    // EFFECTS: splits the line by the spaces
    public ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }

    // MODIFIES: this
    // EFFECTS: writes to the database
    public void save() {
        for (String line : database) {
            writer.println(line);
        }
    }
//
//    // EFFECTS: runs a method based on user's choice
//    public void menu() {
//        getSeason();
//        getMenuOptions();
//        checkValidInput();
//        int choice = scan.nextInt();
//        if (choice != 1) {
//            if (choice == 2) {
//                plantList.printPlants();
//            } else if (choice == 3) {
//                sendToAddPlant();
//            } else {
//                System.out.println("Invalid choice. Try again: ");
//            }
//            menu();
//        }
//    }
//
//    // checks if the input is valid integer
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

//    // REQUIRES: Scanner
//    // MODIFIES: User (if none)
//    // EFFECTS: Prints out the user's name, or asks for it
//    // checks if there is an existing user name, otherwise asks for one
//    public void checkUser() {
//        instruction.setText("Enter your name:");
////        System.out.println("Enter your name:");
////        user = keepGettingString(); // REFACTORED
////        System.out.println("Welcome, " + user);
//    }


    // EFFECTS: Prints out the current season
    public void getSeason() {
        System.out.println("The season is " + season + ".");
    }

    // checks if string is valid and returns it if it is,
    // otherwise keeps asking fr a valid input
    // REFACTORED
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

    // EFFECTS: check that the given input has only alphabet letters
    // returns a boolean
    public void checkLetters(String input) throws InvalidStringException {
        boolean isAlpha = input.matches("[a-zA-Z]+");
        if (!isAlpha || input.isEmpty()) {
            throw new InvalidStringException();
        }
        if (input.length() > 20) {
            throw new StringTooLongException();
        }
    }

//    // REQUIRES: yourPlants has been initialized
//    // MODIFIES: yourPlants
//    // EFFECTS: asks to add plants, adds plant to list if answer is yes
//    public void sendToAddPlant() {
////        int input = checkPlantType();
//        checkPlantType();
//        System.out.println("Enter the name of the plant:");
//        String name = keepGettingString(); // REFACTORED
////        addTypeOfPlant(input, name);
//    }


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

//
//    // adds the type of plant to the array
//    public void addTypeOfPlant(int input, String name) {
//        if (input == 1) {
//            Flower newPlant = new Flower(name);
//            addPlant(newPlant); // REFACTORED
//        } else if (input == 2) {
//            Tree newPlant = new Tree(name);
//            addPlant(newPlant); // REFACTORED
//        }
////        System.out.println(name + " has been added.");
//    }

    // MODIFIES: this
    // EFFECTS: adds plant to array & database
    public static void addPlant(Plant plant) {
        plantList.addObserver(plant);
        yourPlants.add(plant);
//            plantCollection.put(newPlant.getName(), newPlant);
        database.add(plant.toString());
        plantList.notifyObservers(plant);
    }
//
//    // check what plant to add to arrayList
//    public int checkPlantType() {
//        System.out.println("Would you like to add a Flower or Tree? 1 = Flower, 2 = Tree");
//        int input = scan.nextInt();
//        if (input == 1) {
//            System.out.println("Flower selected.");
//        } else if (input == 2) {
//            System.out.println("Tree selected.");
//        }
//        return input;
//
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


    // EFFECTS: Gets the user name and sets it to the UserMessage label
    // sets up the buttons for the menu options.
    private class UserNameListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String text = input.getText();
            checkLetters(text);
            user = text;
            userMessage.setText("Welcome, " + text + ".");
            remove(instruction);
            remove(input);
            instruction = new JLabel("Choose an option: ");
            seePlants = new JButton("See Plants");
            seePlants.addActionListener(new SeePlantListener());
            addAPlant = new JButton("Add a plant");
            addAPlant.addActionListener(new AddPlantListener());
            deleteButton = new JButton("Remove a plant");
            deleteButton.addActionListener(new RemovePlantListener());
            add(instruction);
            add(seePlants);
            add(addAPlant);
            add(deleteButton);
            add(output);
        }
    }

    //EFFECTS: prints out the list of plants
    private class SeePlantListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            remove(input);
            remove(instruction);
            String out = "<html>";
            if (!yourPlants.isEmpty()) {
                for (Plant plant : yourPlants) {
                    out += plant.toString() + "<br/>";
                }
            } else {
                out = "You have no plants.";
            }
            output.setText(out);
            repaint();
        }
    }

    // EFFECTS: asks if user would like to add a flower or plant
    private class AddPlantListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            output.setText("Adding plants.");
            remove(instruction);
            remove(input);
            instruction = new JLabel("Would you like to add a: ");
            add(instruction);

            flowerButton = new JButton("Flower");
            flowerButton.addActionListener(new FlowerAdderListener());
            treeButton = new JButton("Tree");
            treeButton.addActionListener(new TreeAdderListener());
            add(flowerButton);
            add(treeButton);
            repaint();
        }
    }

    // EFFECTS: Gets the name of the plant and adds it to the list
    private class FlowerAdderListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            remove(flowerButton);
            remove(treeButton);
            instruction.setText("Enter the name of the plant:");
            input = new JTextField(20);
            input.addActionListener(new FlowerNameAdder());
            add(input);
            repaint();
        }
    }

    private class FlowerNameAdder implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String name = input.getText();
            Flower thisFlower = new Flower(name);
            addPlant(thisFlower);
            output.setText("Added " + name);
            remove(input);
            remove(instruction);
            remove(flowerButton);
            remove(treeButton);
            repaint();
        }
    }

    // EFFECTS: Asks for the name of the tree
    private class TreeAdderListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            remove(flowerButton);
            remove(treeButton);
            instruction.setText("Enter the name of the plant:");
            input = new JTextField(20);
            input.addActionListener(new TreeNameAdder());
            add(input);
            repaint();
        }
    }

    // EFFECTS: gets the name of the tree and adds it to the list
    private class TreeNameAdder implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String name = input.getText();
            Tree thisTree = new Tree(name);
            addPlant(thisTree);
            output.setText("Added " + name);
            remove(input);
            remove(instruction);
            remove(flowerButton);
            remove(treeButton);
            repaint();
        }
    }

    // EFFECTS: Asks for the name of the plant that should be removed
    private class RemovePlantListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            output.setText("Removing plant.");
            remove(instruction);
            remove(input);
            instruction = new JLabel("What plant would you like to remove: ");
            add(instruction);
            input = new JTextField(20);
            input.addActionListener(new RemovePlantNameListener());
            add(input);
            repaint();
        }
    }

    // EFFECTS: deletes the tree from the list
    private class RemovePlantNameListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String name = input.getText();
            String res = "You do not have this plant.";
            for (Plant plant : yourPlants) {
                if ((plant.name).equals(name)) {
                    int index = yourPlants.indexOf(plant);
                    yourPlants.remove(index);
                    remove(input);
                    remove(instruction);
                    res = "Removed " + name + ".";
                    break;
                }
            }
            output.setText(res);
            repaint();
        }
    }

}

