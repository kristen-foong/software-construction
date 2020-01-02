package refactortogetthere;

public class Berry extends Offshoot {
    public String name;

    public Berry(String name) {
        super();
        this.name = name;
    }

    public void changeColor(String colour) {
        System.out.println(name + " changing colour to: " + colour);
    }
}
