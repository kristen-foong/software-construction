package exceptions;

public class InsufficientBalanceException extends IllegalArgumentException {
    public InsufficientBalanceException() {
        super("Insufficient balance.");
    }
}
