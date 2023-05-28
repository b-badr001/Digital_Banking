package ma.enset.digital_banking.exceptions;

public class BalanceNotSufficentException extends Exception {
    public BalanceNotSufficentException(String message) {
        super(message);
    }
}
