package uk.co.exahertz.friendlysociety.core;

/**
 * A PaymentAlreadyMadeException should be thrown when a payment has already 
 * been made
 * 
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 */
public class PaymentAlreadyMadeException extends Exception {

    /**
     * Create a new PaymentAlreadyMadeException with error string<br>
     * A payment has already been made.
     * 
     * @since 0.0.1
     */
    public PaymentAlreadyMadeException() {
        super("A payment has already been made.");
    }

    /**
     * Create a new PaymentAlreadyMadeException with a customer error string
     * 
     * @param err The customer error string
     * @since 0.0.1
     */
    public PaymentAlreadyMadeException(final String err) {
        super(err);
    }
}