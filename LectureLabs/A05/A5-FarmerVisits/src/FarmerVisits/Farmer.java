package FarmerVisits;

import java.util.ArrayList;

public class Farmer {
 //   ArrayList<Cow> cows;
 //   ArrayList<Goat> goats;
 //   ArrayList<Pig> pigs;
 //   ArrayList<Chicken> chickens;
    ArrayList<Animal> animals;
    ArrayList<Outsider> grazers;

    private void farm() {
        for (Animal a: animals) {
            a.feed(); // feed the animals
        }

        for (Outsider g : grazers) {
            g.putOutside(); // put animals outside
        }
        /*
        for (Cow cow : cows){
            cow.feed();
        }

        for (Goat goat : goats){
            goat.feed();
        }

        for (Pig pig : pigs){
            pig.feed();
        }

        for (Chicken chicken : chickens){
            chicken.feed();
        }

        for (Cow cow : cows){
            cow.putOutside();
        }

        for (Goat goat : goats){
            goat.putOutside();
        }
        */
    }


    public Farmer(){
      //  cows = new ArrayList<>();
      //  goats = new ArrayList<>();
      //  pigs = new ArrayList<>();
      //  chickens = new ArrayList<>();
        animals = new ArrayList<>();
        grazers = new ArrayList<>();
        animals.add(new Cow());
        animals.add(new Cow());
        animals.add(new Cow());
        animals.add(new Goat());
        animals.add(new Goat());
        animals.add(new Goat());
        animals.add(new Pig());
        animals.add(new Pig());
        animals.add(new Chicken());
        animals.add(new Chicken());
        animals.add(new Chicken());
        animals.add(new Chicken());

        grazers.add(new Cow());
        grazers.add(new Goat());
    }

    public static void main(String[] args) {
        Farmer jo = new Farmer();
        jo.farm();
    }



}
