package flyers;

public class Penguin extends AvianFlyer {

    //REQUIRES: height <= 1m
    //MODIFIES: this
    //EFFECTS: travels through the air at an altitude of no more than height metres and then dies
    @Override
    public void fly(int height) {
        System.out.println("EEEEEEEEEEEEK!");
        healthy = false;
    }

    //REQUIRES: miles < 75
    //MODIFIES: this
    //EFFECTS: travels specified distance
    @Override
    public void travel(int miles) {
        for (int i = 0; i < miles; i++){
            waddle();
        }
    }

    private void waddle() {
        System.out.println("waddling");
    }
}


