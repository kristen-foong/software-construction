package flyers;

public interface Flyer {

    //REQUIRES: height > 5m
    //EFFECTS: travels through the air at an altitude of no more than height metres
    public void fly(int height);

    public boolean isHealthy();
}
