package starter;

import java.util.ArrayList;

public class LogEntry {
    private String operation;
    private ArrayList<Integer> operands;
    private int result;

    public LogEntry() {
        operation = "";
        operands = new ArrayList<>();
        result = 0;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void addOperand(Integer operand) {
        operands.add(operand);
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String toString() {
        return operation + " " + operands + " equals " + result;
    }
}
