package ca.ubc.cpsc210.nowserving.model;

// Represents a counter to indicate the number of the next customer to be served
public class CustomerCounter {
    public static final int MAX_CUSTOMER_NUMBER = 10;
    private int nextCustomer;
    
    // EFFECTS: constructs counter with next customer number set to one
    public CustomerCounter() {
        nextCustomer = 1;
    }
    
    // EFFECTS: returns number of next customer to be served
    public int getNextCustomer() {
        return nextCustomer;
    }
    
    // MODIFIES: this
    // EFFECTS: next customer number is increased by 1, unless it is currently
    // MAX_CUSTOMER_NUMBER, in which case it is reset to 1
    public void nextCustomer() {
        nextCustomer++;
        if (nextCustomer > MAX_CUSTOMER_NUMBER)
            nextCustomer = 1;
    }
}