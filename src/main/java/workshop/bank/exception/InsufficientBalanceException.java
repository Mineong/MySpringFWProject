package workshop.bank.exception;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) { super(msg); }
}