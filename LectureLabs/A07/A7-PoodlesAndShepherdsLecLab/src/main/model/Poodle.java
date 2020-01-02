package model;

import java.util.ArrayList;
import java.util.List;

public class Poodle extends Dog {

    //EFFECTS: creates a new Poodle with a 24 hour schedule capacity
    public Poodle(String name){
        super(name);
    }

    //EFFECTS: prints and returns "yip yip yip"
    public String bark(){
        String retString = "yip yip yip";
        System.out.println(retString);
        return retString;
    }

    //EFFECTS: prints out and returns something prancey
    public String prance(){
        String retString = "I'm fancy!";
        System.out.println(retString);
        return retString;
    }


    //EFFECTS: prints out greeting things and then waits for a treat
    public String greet(){
        return super.greet("yap yap!");
    }


}
