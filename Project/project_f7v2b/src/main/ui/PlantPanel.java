package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlantPanel extends JPanel {

    private JTextField input;
    private JLabel output;

    public PlantPanel() {
        JLabel ins = new JLabel("Enter text here:");
        input = new JTextField(10);
        input.addActionListener(new UserNameListener());
        output = new JLabel("Output: ");

        add(ins);
        add(input);
        //add(button);
        add(output);
        setPreferredSize(new Dimension(350,299));
        setBackground(Color.ORANGE);
    }

    private class UserNameListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String text = input.getText();
            output.setText(text);
        }
    }
}
