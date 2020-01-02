package ca.ubc.cpsc210.helpdesk.model;

import java.util.ArrayList;
import java.util.LinkedList;

// Represents a queue of incidents to be handled by helpdesk
// with maximum size MAX_SIZE
public class IncidentQueue {
    public static final int MAX_SIZE = 10;
    // TODO: complete the design of the IncidentQueue class
    public LinkedList<Incident> incidentQueue;

    public IncidentQueue() {
        incidentQueue = new LinkedList<>();
    }

    // MODIFIES: incidentQueue
    // EFFECT: Adds an incident to the end of the queue
    public boolean addIncident(Incident incident) {
        if (incidentQueue.size() < MAX_SIZE) {
            incidentQueue.add(incident);
            return true;
        } else {
            return false;
        }
    }

    // REQUIRES: the incidentQueue list is not empty
    // MODIFIES: incidentQueue
    // EFFECT: removes the first incident in the queue and returns it
    public Incident getNextIncident() {
        return incidentQueue.remove(0);
    }

    // REQUIRES: each incident has a unique case number
    // EFFECT: returns the position of an incident with the given case number
    public int getPositionInQueueOfCaseNumber(int caseNum) {
        int position = 0;
        for (Incident incident : incidentQueue) {
            if (incident.getCaseNum() == caseNum) {
                position = incidentQueue.indexOf(incident) + 1;
            }
        }
        if (position == 0) {
            return -1;
        } else {
            return position;
        }
    }

    // EFFECT: returns the length of the queue
    public int length() {
        return incidentQueue.size();
    }

    // EFFECT: returns true if the queue is empty, false otherwise
    public boolean isEmpty() {
        if (incidentQueue.isEmpty()) {
            return true;
        }
        return false;
    }

    // EFFECT: returns true if the queue is full, false otherwise
    public boolean isFull() {
        if (incidentQueue.size() == MAX_SIZE) {
            return true;
        }
        return false;
    }
}
