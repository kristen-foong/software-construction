package FarmerVisits;

public class Cow implements Animal, Outsider {
    public void feed() {
        System.out.println("Moooo!");
    }

    public void putOutside() {
        System.out.println("Walk walk walk");
    }
}
