package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Dog {

    private String name;
    private List<String> schedule;

    public abstract String bark();

    public Dog(String name) {
        this.name = name;
        this.schedule = new ArrayList<>(24);
        for (int i=0; i<24; i++){
            this.schedule.add(i, "free");
        }
    }


    //EFFECTS: prints out the schedule
    public String printSchedule(){
        String scheduleStr = name + "'s schedule: " + schedule;
        System.out.println(scheduleStr);
        return scheduleStr;
    }

    //REQUIRES: a time between 0 and 23
    //MODIFIES: this
    //EFFECTS:  adds the thing to add to the schedule,
    //          prints out what has been added and when
    public void addToSchedule(String thingToAdd, int time){
        System.out.println("Adding "+thingToAdd+" to schedule at "+time);
        schedule.set(time, thingToAdd);
    }

    //EFFECTS: prints out greeting things and then waits for a treat
    public String greet(String greeting){
        System.out.println(greeting);
        System.out.println("waiting for a treat!");
        return greeting + "\n" + "waiting for a treat!";
    }
}
