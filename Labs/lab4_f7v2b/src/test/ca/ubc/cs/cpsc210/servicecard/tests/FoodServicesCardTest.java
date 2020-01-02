package ca.ubc.cs.cpsc210.servicecard.tests;

import ca.ubc.cs.cpsc210.servicecard.model.FoodServicesCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Unit tests for FoodServiceCard class
class FoodServicesCardTest {
    public FoodServicesCard foodServicesCard;
    public int initialBalance, reloadAmount;

    @BeforeEach
    public void runBefore() {
        initialBalance = 0;
        reloadAmount = 100;
        foodServicesCard = new FoodServicesCard(initialBalance);
    }

    @Test
    // Test reload method
    public void testReload() {
        foodServicesCard.reload(reloadAmount);
        assertEquals(reloadAmount, foodServicesCard.getBalance());
    }

    @Test
    // Test getBalance method
    public void testGetBalance() {
        assertTrue(foodServicesCard.getBalance() >= 0);
        foodServicesCard.reload(reloadAmount);
        assertEquals(reloadAmount, foodServicesCard.getBalance());
    }

    @Test
    // Test getRewardPoints method
    public void testGetRewardPoints() {
        assertTrue(foodServicesCard.getRewardPoints() >= 0);
        assertEquals(foodServicesCard.points, foodServicesCard.getRewardPoints());
    }

    @Test
    // Test makePurchase method
    // Test for balance is enough to make purchase, balance is not enough to make purchase
    // rewards are given, reward points are deducted, purchase amount is deducted,
    // reward points points are added to card
    public void testMakePurchase() {
        boolean purchased;
        purchased = foodServicesCard.makePurchase(100);
        assertFalse(purchased);

        foodServicesCard.reload(1000);
        purchased = foodServicesCard.makePurchase(1000);
        assertTrue(purchased);
        assertTrue(foodServicesCard.getRewardPoints() >= 0);
        assertEquals(1000, foodServicesCard.getRewardPoints());
        assertTrue(foodServicesCard.getBalance() >= 0);

        foodServicesCard.reload(5000);
        purchased = foodServicesCard.makePurchase(4000);
        assertTrue(purchased);
        assertTrue(foodServicesCard.getBalance() >= 0);
        assertEquals(1020, foodServicesCard.getBalance());
        assertTrue(foodServicesCard.getRewardPoints() >= 0);
        assertEquals(1000, foodServicesCard.getRewardPoints());
    }
}