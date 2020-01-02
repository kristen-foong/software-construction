package starter;

import java.util.ArrayList;
import java.util.Scanner;

public class LoggingCalculator {
    private ArrayList<LogEntry> operationLog;
    private Scanner scanner;

    public LoggingCalculator() {
        operationLog = new ArrayList<>();
        scanner = new Scanner(System.in);
        processOperations();
    }

    private void processOperations() {
        String operation = "";

        while (true) {
            System.out.println("Please select an option (plus or quit):");
            operation = scanner.nextLine();
            System.out.println("you selected: " + operation);

            if (operation.equals("quit")) {
                break;
            }

            LogEntry logEntry = new LogEntry();
            int result = processOperation(logEntry, operation);
            System.out.println("that equals: " + result);
        }

        System.out.println("Operation log: " + operationLog);
    }

    private int processOperation(LogEntry logEntry, String operation) {
        int result = 0;

        System.out.println("Please enter the first number to " + operation);
        int first = scanner.nextInt();
        System.out.println("Please enter the second number to " + operation);
        int second = scanner.nextInt();
        scanner.nextLine(); // clears the line;
                            // otherwise the carriage return is taken as the
                            // next input and you get a blank "selected" loop

        if (operation.equals("plus")) {
            result = first + second;
        }

        logResult(logEntry, operation, first, second, result);

        //return 0;
        return result;
    }

    private void logResult(LogEntry logEntry, String operation, int first, int second, int result) {
        logEntry.setOperation(operation);
        logEntry.addOperand(first);
        logEntry.addOperand(second);
        logEntry.setResult(result);
        operationLog.add(logEntry);
    }

    public static void main(String[] args) {
        new LoggingCalculator();
    }
}
