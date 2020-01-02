package exception;

import java.util.InputMismatchException;

public class InvalidInputException extends IllegalArgumentException {

    // EFFECTS: prints out the error message
    public InvalidInputException(String message) {
        super(message);
    }
}
