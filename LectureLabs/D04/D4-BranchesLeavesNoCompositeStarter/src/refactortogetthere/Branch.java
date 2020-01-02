package refactortogetthere;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Offshoot {
    private List<Offshoot> offshoots;
    private List<Branch> branches;
    private List<Leaf> leaves;
    private String name;

    public Branch(String name) {
        this.name = name;
        branches = new ArrayList<>();
        leaves = new ArrayList<>();
    }

//    public void grow(Branch branch) {
//        branches.add(branch);
//    }

//    public void grow(Leaf leaf) {
//        leaves.add(leaf);
//    }

    public void grow(Offshoot offshoot) {
        offshoots.add(offshoot);
    }

    public void changeColor(String colour) {
//        for (Branch branch: branches) {
//            branch.changeColor(colour);
//        }
//        for (Leaf leaf : leaves) {
//            leaf.changeColor(colour);
//        }
        for(Offshoot offshoot: offshoots) {
            offshoot.changeColor(colour);
        }
    }
}
