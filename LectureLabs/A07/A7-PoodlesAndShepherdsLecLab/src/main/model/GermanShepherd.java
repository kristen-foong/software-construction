package model;

import java.util.ArrayList;
import java.util.List;

public class GermanShepherd extends Dog {

    //EFFECTS: creates a new German Shepherd with a 24 hour schedule capacity
    public GermanShepherd(String name){
        super(name);
    }

    //EFFECTS: prints and returns "woof woof\ngrrrrr\nwoof woof"
    public String bark(){
        System.out.println("woof woof");
        System.out.println("grrrrrrr");
        System.out.println("woof woof");
        return "woof woof\ngrrrrr\nwoof woof";
    }


    //EFFECTS: takes defensive action
    public String defend(){
        String retString = "I AM PROTECTING YOU!!!";
        System.out.println(retString);
        return retString;
    }


    //EFFECTS: prints out greeting things and then waits for a treat
    public String greet(){
        return super.greet("Woof Woof!");
    }


}
