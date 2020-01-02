package exception;

public class InvalidStringException extends InvalidInputException {

    // EFFECTS: prints out the error message
    public InvalidStringException() {
        super("Input is not a string.");
    }

    // EFFECTS: prints out the error message
    public InvalidStringException(String message) {
        super(message);
    }
}
