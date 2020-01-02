package people;

import resolutions.ResolutionMaker;

public class Person {
    ResolutionMaker resolutionMaker;

    public Person() {
        resolutionMaker = new ResolutionMaker();
    }

    public void getFit(){
        sayResolution();
        resolutionMaker.workOut();
    }

    public void eatBetter(){
        sayResolution();
        resolutionMaker.eatSalad();
        sayResolution();
        resolutionMaker.drinkSmoothies();
    }

    private void sayResolution(){
        System.out.print("I am going to ....");
    }

}
