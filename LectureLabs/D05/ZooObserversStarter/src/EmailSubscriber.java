// Represents an email subscriber to the zoo
public class EmailSubscriber {
    private String name;

    // EFFECTS: constructs an email subscriber with name
    public EmailSubscriber(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
