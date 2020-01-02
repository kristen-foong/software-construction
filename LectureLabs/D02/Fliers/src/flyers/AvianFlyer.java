package flyers;

public abstract class AvianFlyer implements Flyer, LongHaulTraveller {
    protected boolean healthy = true;
    public boolean isHealthy() {
        return healthy;
    }
}
