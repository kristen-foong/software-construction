package ui;

import network.ReadFromWeb;

import javax.swing.*;
import java.io.IOException;

public class Main {
    // Main Method
    // Checks User, plants, and displays messages
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Plant Panel");
        frame.add(new UserInput());
        frame.setVisible(true);

        ReadFromWeb rfw = new ReadFromWeb();
        UserInput userInput = new UserInput();
        userInput.run();
    }
}
