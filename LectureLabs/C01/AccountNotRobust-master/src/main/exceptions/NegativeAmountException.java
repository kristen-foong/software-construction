package exceptions;

public class NegativeAmountException extends IllegalArgumentException {
    public NegativeAmountException() {
        super("Invalid amount.");
    }
}
