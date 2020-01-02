package ui;

import javax.swing.JFrame;

/** Don't run this one!! This was used for a reference **/
// Reference came from a previous panel project I did in another course
public class TheFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Plant Panel");
        frame.add(new PlantPanel());
        frame.setVisible(true);
    }
}
