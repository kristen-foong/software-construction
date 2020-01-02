package starter;

import java.util.Observable;
import java.util.Observer;

public class LeafMonitor implements Observer {
    public void update(Observable ob, Object arg) {
        Leaf aleaf = (Leaf) arg;
        System.out.println("LEAFY MONITOR --- a leaf changed to " + aleaf.getColour());
    }
}
