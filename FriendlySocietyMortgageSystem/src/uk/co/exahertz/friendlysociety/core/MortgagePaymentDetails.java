package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;

/**
 * MortgagePaymentDetails holds details for upcoming mortgage payments and to 
 * hold details of payments made
 * 
 * @author Guillaume Pasquet
 * @version 0.0.1
 * @since 0.0.1
 */
public class MortgagePaymentDetails {
    private int paymentID;
    private GregorianCalendar paymentDueDate;
    private GregorianCalendar paymentMadeDate;
    private MethodOfPayment methodOfPayment;
    private float amount;

    /**
     * Create a new mortgage payment
     * 
     * @param paymentID The unique ID of the mortgage payment
     * @param paymentDueDate The date the payment is due
     * @param methodOfPayment The method of payment
     * @param amount The amount of the payment
     * @throws java.lang.IllegalArgumentException When an illegal argument is 
     * supplied
     */
    public MortgagePaymentDetails(final int paymentID,
            final GregorianCalendar paymentDueDate,
            final MethodOfPayment methodOfPayment,
            final float amount) throws IllegalArgumentException
    {
        checkPaymentID(paymentID);
        checkPaymentDueDate(paymentDueDate);
        checkAmount(amount);

        this.paymentID = paymentID;
        this.paymentDueDate = paymentDueDate;
        this.paymentMadeDate = null;
        this.methodOfPayment = methodOfPayment;
        this.amount = amount;
    }

    /**
     * Get the ID of a payment
     * 
     * @return The ID of a payment
     * @since 0.0.1
     */
    public int getPaymentID() {
        return paymentID;
    }
    
    /**
     * Get the payment due date
     * 
     * @return The payment due date
     * @since 0.0.1
     */
    public GregorianCalendar getPaymentDueDate() {
        return paymentDueDate;
    }
    
    /**
     * Get the payment made date. If the payment has not been made, null will 
     * be returned
     * 
     * @return The payment made date, or null if the payment is yet to be made
     * @since 0.0.1
     */
    public GregorianCalendar getPaymentMadeDate() {
        return paymentMadeDate;
    }
    
    /**
     * Get the payment made status. If a payment has been made, true will be 
     * returned otherwise false will be returned
     * 
     * @return A boolean result stating if a payment has been made or not
     * @since 0.0.1
     */
    public boolean getPaymentMade() {
        if(paymentMadeDate == null) {
            return false;
        } else return true;
    }
    
    /**
     * Get the method of payment made for this payment
     * 
     * @return The method of payment for this payment
     * @since 0.0.1
     */
    public MethodOfPayment getMethodOfPayment() {
        return methodOfPayment;
    }
    
    /**
     * Get the amount of this payment
     * 
     * @return The amount of this payment
     * @since 0.0.1
     */
    public float getAmount() {
        return amount;
    }
    
    /**
     * Set the date the payment was made
     * 
     * @param paymentMadeDate The date the payment was made
     * @throws uk.co.exahertz.friendlysociety.core.PaymentAlreadyMadeException 
     * When a payment has already been made
     * @since 0.0.1
     */
    public void setPaymentMadeDate(final GregorianCalendar paymentMadeDate)
            throws PaymentAlreadyMadeException
    {
        if(paymentMadeDate != null) throw new PaymentAlreadyMadeException();
        this.paymentMadeDate = paymentMadeDate;
    }
    
    /**
     * Set the method of payment
     * 
     * @param methodOfPayment The method of payment
     * @since 0.0.1
     */
    public void setMethodOfPayment(final MethodOfPayment methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }
    
    /**
     * Set the amount of the payment
     * 
     * @param amount The amount of the payment
     * @throws java.lang.IllegalArgumentException When a value of 0 or less is 
     * supplied
     */
    public void setAmount(final float amount) throws IllegalArgumentException {
        checkAmount(amount);
        this.amount = amount;
    }
    
    /**
     * Check the payment ID is not less than 0
     * 
     * @param paymentID The payment ID to be checked
     * @since 0.0.1
     */
    private static void checkPaymentID(final int paymentID) {
        if (paymentID < 0) {
            throw new IllegalArgumentException("The payment ID " +
                    "must be 0 or greater.");
        }
    }

    /**
     * Check the payment due date is not null
     * 
     * @param paymentDueDate The patyment due date to be checked
     * @since 0.0.1
     */
    private static void checkPaymentDueDate(
            final GregorianCalendar paymentDueDate) {
        if (paymentDueDate == null) {
            throw new IllegalArgumentException("The " +
                    "payment due must not be null.");
        }
    }

    /**
     * Check the amount due is greater than 0
     * 
     * @param amount The amount to be checked
     * @since 0.0.1
     */
    private static void checkAmount(final float amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("The amount must " +
                    "be greater than 0.");
        }
    }
}
