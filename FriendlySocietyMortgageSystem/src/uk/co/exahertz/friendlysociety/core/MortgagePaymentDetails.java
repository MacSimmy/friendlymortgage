package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;

/**
 * Details about one of a mortage's payments
 * One or more objects from this class are used in
 * 
 * 
 * @author gp79
 */
public class MortgagePaymentDetails {

    
    private int paymentReferenceNo;
    private GregorianCalendar paymentDueDate;
    private GregorianCalendar paymentMadeDate;
    private MethodOfPayment methodOfPayment;
    private float amountPaid;
    private float amountDue;
    
    /**
     * 
     * @param paymentReferenceNo
     * @param paymentDueDate
     * @param paymentMadeDate
     * @param methodOfPayment
     * @param amountPaid
     * @param amountDue
     */
    public MortgagePaymentDetails(int paymentReferenceNo, 
            GregorianCalendar paymentDueDate, GregorianCalendar paymentMadeDate,
            MethodOfPayment methodOfPayment, float amountPaid, float amountDue){
        
        if (paymentReferenceNo < 0) throw new IllegalArgumentException(" The " +
                "payment reference number must be greater than 0");
        
        if (paymentDueDate == null) throw new IllegalArgumentException("A " +
                "paynmentDueDate must be provided");
        
        // don't check the paymentmade:
        // consider that paymentMadeDate == null means that the payment 
        //has not be made yet
        
       // check method of paynment
        if ( methodOfPayment == null) throw new IllegalArgumentException(" A" +
                "method of payment must be provided");
        
        //check amount paid:
        if ( amountPaid < 0 ) throw new IllegalArgumentException(" The " +
                "amount paid must be positive");
        
        //check amount due
        if ( amountDue < 0) throw new IllegalArgumentException(" The amount " +
                "due must be positive");
        
        this.paymentReferenceNo = paymentReferenceNo;
        this.paymentDueDate = paymentDueDate;
        this.paymentMadeDate = paymentMadeDate;
        this.methodOfPayment = methodOfPayment;
        this.amountPaid = amountPaid;
        this.amountDue = amountDue;
        
    }
    
    /**
     * 
     * @return the amount due
     */
    public float getAmountDue() {
        return amountDue;
    }

    /**
     * 
     * @return the amount already paid
     */
    public float getAmountPaid() {
        return amountPaid;
    }

    /**
     * 
     * @return the method of payment
     */
    public MethodOfPayment getMethodOfPayment() {
        return methodOfPayment;
    }

    /**
     * 
     * @return the date at which the payment is due
     */
    public GregorianCalendar getPaymentDueDate() {
        return paymentDueDate;
    }

    /**
     * 
     * @return The date at which the payment have been made (null if the 
     * payment have not been made yet)
     */
    public GregorianCalendar getPaymentMadeDate() {
        return paymentMadeDate;
    }

    /**
     * 
     * @return The payment reference number
     */
    public int getPaymentReferenceNo() {
        return paymentReferenceNo;
    }

    /**
     * 
     * @param amountDue the amount due (must be positive)
     */
    public void setAmountDue(float amountDue) {
        if ( amountDue < 0) throw new IllegalArgumentException(" The amount " +
                "due must be positive");
        this.amountDue = amountDue;
    }

    /**
     * 
     * @param amountPaid The amount already paid (must be positive)
     */
    public void setAmountPaid(float amountPaid) {
        if ( amountPaid < 0 ) throw new IllegalArgumentException(" The " +
                "amount paid must be positive");
        this.amountPaid = amountPaid;
    }

    /**
     * 
     * @param methodOfPayment
     */
    public void setMethodOfPayment(MethodOfPayment methodOfPayment) {
        this.methodOfPayment = methodOfPayment;
    }

    /**
     * 
     * @param paymentDueDate the date at which the payment is due
     */
    public void setPaymentDueDate(GregorianCalendar paymentDueDate) {
        if (paymentDueDate == null) throw new IllegalArgumentException("The " +
                "paynmentDueDate can not be null");
        this.paymentDueDate = paymentDueDate;
    }

    /**
     * 
     * @param paymentMadeDate The date at which the payment have been made 
     * (null if the payment have not been made yet)
     */
    public void setPaymentMadeDate(GregorianCalendar paymentMadeDate) {
        this.paymentMadeDate = paymentMadeDate;
    }

    /**
     * 
     * @param paymentReferenceNo The reference number of this payment
     */
    public void setPaymentReferenceNo(int paymentReferenceNo) {
        if (paymentReferenceNo < 0) throw new IllegalArgumentException(" The " +
                "payment reference number must be greater than 0");
        this.paymentReferenceNo = paymentReferenceNo;
    }
    
    
}
