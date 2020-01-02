package ui;

import model.Pizza;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pizza> pizzas = new ArrayList<>();
        Pizza pizza1 = new Pizza("pizza1");
        Pizza pizza2 = new Pizza("pizza2");
        pizzas.add(pizza1);
        pizzas.add(pizza2);

        //added toppings to pizza1
        pizzas.get(0).addATopping();
        //added toppings to pizza2
        pizzas.get(1).addATopping();
        pizzas.get(1).addATopping();

        pizzas.get(0).print();
        pizzas.get(1).print();
    }
}
