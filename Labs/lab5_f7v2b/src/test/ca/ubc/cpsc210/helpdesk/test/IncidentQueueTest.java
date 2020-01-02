package ca.ubc.cpsc210.helpdesk.test;


import ca.ubc.cpsc210.helpdesk.model.Incident;
import ca.ubc.cpsc210.helpdesk.model.IncidentQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IncidentQueueTest {
    // Design your unit tests for the IncidentQueue class here
    public IncidentQueue theQueue;
    public Incident incidentOne;

    @BeforeEach
    void runBefore() {
        theQueue = new IncidentQueue();
        incidentOne = new Incident(1, "Chrome is broken.");
    }

    @Test
    // Test that adding an incident works
    void testAddIncident() {
        theQueue.addIncident(incidentOne);
        assertTrue(theQueue.length() != 0);
        assertEquals(1, theQueue.getPositionInQueueOfCaseNumber(1));
    }

    @Test
    // test that getNextIncident works
    void testGetNextIncident() {
        theQueue.addIncident(incidentOne);
        theQueue.addIncident(new Incident(2, "Laptop won't start"));
        assertEquals(1, theQueue.getNextIncident().getCaseNum());
        assertEquals(1, theQueue.length());
    }

    @Test
    // test getPositionInQueueOfCaseNumber method
    void testGetPositionInQueueOfCaseNumber() {
        assertEquals(-1, theQueue.getPositionInQueueOfCaseNumber(1));
        for (int i = 0; i <= theQueue.MAX_SIZE; i++) {
            theQueue.addIncident(new Incident(i+1, "Something broke"));
        }
        assertEquals(2, theQueue.getPositionInQueueOfCaseNumber(2));
    }

    @Test
    // test the length method
    void testLength() {
        assertEquals(0, theQueue.length());
        theQueue.addIncident(incidentOne);
        assertEquals(1, theQueue.length());
    }

    @Test
    // test the isEmpty method
    void testIsEmpty() {
        assertTrue(theQueue.isEmpty());
        theQueue.addIncident(incidentOne);
        assertFalse(theQueue.isEmpty());
    }

    @Test
    // test the isFull method
    void testIsFull() {
        assertFalse(theQueue.isFull());
        for (int i = 0; i <= theQueue.MAX_SIZE; i++) {
            theQueue.addIncident(new Incident(i+1, "Something broke"));
        }
        assertTrue(theQueue.isFull());

    }
}