package ca.ubc.cpsc210.nowserving.test;

import ca.ubc.cpsc210.nowserving.model.CustomerCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Unit Tests for the CustomerCounter class
class CustomerCounterTest {
    private CustomerCounter testCounter;
    
    @BeforeEach
    void runBefore() {
        testCounter = new CustomerCounter();
    }
    
    @Test
    void testConstructor() {
        assertEquals(1, testCounter.getNextCustomer());
    }
    
    @Test
    void testNextCustomer() {
        testCounter.nextCustomer();
        assertEquals(2, testCounter.getNextCustomer());
        
        testCounter.nextCustomer();
        assertEquals(3, testCounter.getNextCustomer());
    }

    // Uncommented testNextCustomerRollAround
    @Test
    void testNextCustomerRollAround() {
        for(int i = 0; i < CustomerCounter.MAX_CUSTOMER_NUMBER; i++) {
            testCounter.nextCustomer();
        }

        assertEquals(1, testCounter.getNextCustomer());
    }
}