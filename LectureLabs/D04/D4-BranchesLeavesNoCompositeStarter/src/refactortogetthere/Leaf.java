package refactortogetthere;

public class Leaf extends Offshoot {
    String colour = "GREEN";
    String name;

    public Leaf(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void changeColor(String colour) {
        System.out.println(name + " changing colour to: " + colour);
        this.colour = colour;
    }
}
