package exception;

public class StringTooLongException extends InvalidStringException {

    // EFFECTS: prints out the error message
    public StringTooLongException() {
        super("The input string is to long.");
    }
}
