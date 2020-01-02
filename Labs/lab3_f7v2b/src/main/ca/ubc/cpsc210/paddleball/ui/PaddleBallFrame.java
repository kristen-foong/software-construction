package ca.ubc.cpsc210.paddleball.ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

import ca.ubc.cpsc210.paddleball.model.PBG;

/*
 * Represents the main window in which the paddle ball
 * game is played
 */
@SuppressWarnings("serial")
public class PaddleBallFrame extends JFrame {
    private static final int INTERVAL = 20;
    private PBG game;
    private GamePanel gp;

    // Constructs main window
    // EFFECTS: sets up window in which the paddle ball game will be played
    PaddleBallFrame() {
        super("Paddle Ball");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        game = new PBG();
        gp = new GamePanel(game);
        add(gp);
        addKeyListener(new KeyHandler());
        pack();
        centreOnScreen();
        setVisible(true);
        addTimer();
    }

    // Set up timer
    // MODIFIES: none
    // EFFECTS: initializes a timer that updates game each
    // INTERVAL milliseconds
    private void addTimer() {
        Timer t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.update();
                gp.repaint();
            }
        });
        t.start();
    }

    // Centres frame on desktop
    // MODIFIES: this
    // EFFECTS: location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    /*
     * A key handler to respond to key events
     */
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            game.keyPressed(e.getKeyCode());
        }
    }

    /*
     * Play the game
     */
    public static void main(String[] args) {
        new PaddleBallFrame();
    }
}
