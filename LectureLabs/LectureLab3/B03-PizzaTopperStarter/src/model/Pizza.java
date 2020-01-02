package model;

public class Pizza {
    private int numToppings;
    private String name;

    public Pizza(String name) {
        //assigned parameter name to this object name
        this.name = name;
        numToppings = 0;
    }

    public void addATopping() {
        //changed -- to ++
        numToppings++;
    }

    public void removeATopping() {
        //changed ++ to --
        numToppings--;
    }

    public void print() {
        System.out.println(name + " has " + numToppings + " toppings");
    }
}
