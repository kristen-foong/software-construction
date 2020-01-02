package ca.ubc.cpsc210.helpdesk.model;

// Represents an incident having a case number, description and open/closed status
public class Incident {
    private int caseNum;
    private String description;
    private boolean isClosed;

    // EFFECTS: incident has given case number and description, and is not closed
    public Incident(int caseNum, String description) {
        this.caseNum = caseNum;
        this.description = description;
        isClosed = false;
    }

    // EFFECTS: returns case number
    public int getCaseNum() {
        return caseNum;
    }

    // EFFECTS: returns description
    public String getDescription() {
        return description;
    }

    // EFFECTS: returns true if case is closed, false otherwise
    public boolean isClosed() {
        return isClosed;
    }

    // MODIFIES: this
    // EFFECTS: closes the incident
    public void close() {
        isClosed = true;
    }

    // REQUIRES: isClosed()
    // MODIFIES: this
    // EFFECTS: re-opens the incident
    public void reopen() {
        isClosed = false;
    }
}
