import java.util.ArrayList;
import java.util.List;

// Represents a zoo
public class Zoo {
    private List<Animal> animals;
    private String name;

    // EFFECTS: constructs a zoo with given name
    public Zoo(String name) {
        this.name = name;
        animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // MODIFIES: this
    // EFFECTS: adds animal a to the zoo
    public void addAnimal(Animal a) {
        animals.add(a);
    }
}
