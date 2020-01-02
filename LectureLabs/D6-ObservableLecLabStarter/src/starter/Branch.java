package starter;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Offshoot {
    private List<Offshoot> offshoots;

    // EFFECTS: constructs branch with name
    public Branch(String name) {
        super(name);
        offshoots = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds offshoot to branch
    public void grow(Offshoot offshoot) {
        offshoots.add(offshoot);
    }

    @Override
    public void changeColor() {
        for (Offshoot offshoot : offshoots) {
            offshoot.changeColor();
        }
    }
}
