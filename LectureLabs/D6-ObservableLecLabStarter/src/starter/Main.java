package starter;

public class Main {
    public static void main(String[] args) {
        Branch tree = new Branch("tree");
        Branch b1 = new Branch("b1");
        tree.grow(b1);
        b1.grow(new Leaf("leafy", new LeafMonitor()));
        tree.changeColor();
        tree.changeColor();
        tree.changeColor();
    }
}
