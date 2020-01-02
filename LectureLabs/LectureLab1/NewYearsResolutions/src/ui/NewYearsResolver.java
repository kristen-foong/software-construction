package ui;

import people.Person;

public class NewYearsResolver {

    public NewYearsResolver(){
    }

    public void start(){
        Person p = new Person();
        p.eatBetter();
        p.getFit();
    }


    public static void main(String[] args) {
        NewYearsResolver nyr = new NewYearsResolver();
        nyr.start();
    }
}
