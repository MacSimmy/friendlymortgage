package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Details of the mortgage will be stored here.
 *
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 * @see MortgageApplicationStatus
 * @see MortgagesOffered
 * @see Property
 * @see Customer
 */
public class Mortgage {
    private int mortgageID;
    private Customer customer;
    private Customer customerSpouse;
    private Property property;
    private GregorianCalendar dateOfApplication;
    private float deposit;
    private int mortgageLengthInMonths;
    private float amountRequested;
    private MortgageApplicationStatus applicationStatus;
    private MortgagesOffered mortgageType;
    private GregorianCalendar paymentsBegin;
    private ArrayList<MortgagePaymentDetails> mortgagePayments;

    /**
     * Create a new mortgage
     *
     * @param mortgageID The unique ID of the mortgage
     * @param customer The customer of the mortgage
     * @param customerSpouse The spouse of the customer, can be null
     * @param property The property for which the mortgage is for
     * @param dateOfApplication The date the application was submitted
     * @param deposit The deposit of the mortgage
     * @param mortgageLengthInMonths The term the mortgage is taken for, in
     * months
     * @param amountRequested The amount requested for the mortgage
     * @param applicationStatus The application status of the mortgage
     * @param mortgageType The type of mortgage
     * @param paymentsBegin The date the payments begin
     * @throws java.lang.IllegalArgumentException When an invalid argument is
     * supplied
     * @since 0.0.1
     */
    public Mortgage(final int mortgageID, final Customer customer,
            final Customer customerSpouse, final Property property,
            final GregorianCalendar dateOfApplication, final float deposit,
            final int mortgageLengthInMonths, final float amountRequested,
            final MortgageApplicationStatus applicationStatus,
            final MortgagesOffered mortgageType,
            final GregorianCalendar paymentsBegin)
            throws IllegalArgumentException
    {
        checkMortgageID(mortgageID);
        checkCustomer(customer);
        checkProperty(property);
        checkDateOfApplication(dateOfApplication);
        checkDeposit(deposit);
        checkMortgageLengthInMonths(mortgageLengthInMonths);
        checkAmountRequested(amountRequested);
        checkPaymentsBegin(paymentsBegin);

        this.mortgageID = mortgageID;
        this.customer = customer;
        this.customerSpouse = customerSpouse;
        this.property = property;
        this.dateOfApplication = dateOfApplication;
        this.deposit = deposit;
        this.mortgageLengthInMonths = mortgageLengthInMonths;
        this.amountRequested = amountRequested;
        this.applicationStatus = applicationStatus;
        this.mortgageType = mortgageType;
        this.paymentsBegin = paymentsBegin;
        mortgagePayments = new ArrayList<MortgagePaymentDetails>();
    }

    /**
     * Get the unique ID of the mortgage
     *
     * @return The unique ID of the mortgage
     * @since 0.0.1
     */
    public int getMortgageID() {
        return mortgageID;
    }

    /**
     * Get the customer of this mortgage
     *
     * @return The customer of this mortgage
     * @since 0.0.1
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Get the spouse of the customer
     *
     * @return The spouse of the customer
     * @since 0.0.1
     */
    public Customer getCustomerSpouse() {
        return customerSpouse;
    }

    /**
     * Get the property for which this mortgage is for
     *
     * @return The property for which this mortgage is for
     * @since 0.0.1
     */
    public Property getProperty() {
        return property;
    }

    /**
     * Get the date the application was submitted
     *
     * @return The date the application was submitted
     * @since 0.0.1
     */
    public GregorianCalendar getDateOfApplication() {
        return dateOfApplication;
    }

    /**
     * Get the deposit of the mortgage
     *
     * @return The deposit of the mortgage
     * @since 0.0.1
     */
    public float getDeposit() {
        return deposit;
    }

    /**
     * Get the mortgage length in months
     *
     * @return The mortgage length in months
     * @since 0.0.1
     */
    public int getMortgageLengthInMonths() {
        return mortgageLengthInMonths;
    }

    /**
     * Get the amount requested for this mortgage
     * @return
     */
    public float getAmountRequested() {
        return amountRequested;
    }

    /**
     * Get the application status of the mortgage
     *
     * @return The application status of the mortgage
     * @since 0.0.1
     */
    public MortgageApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    /**
     * Get the type of the mortgage
     *
     * @return The type of the mortgage
     * @since 0.0.1
     */
    public MortgagesOffered getMortgageType() {
        return mortgageType;
    }

    /**
     * Get the date the payments begin/began
     *
     * @return The date the payments begin/began
     * @since 0.0.1
     */
    public GregorianCalendar getPaymentsBegin() {
        return paymentsBegin;
    }

    /**
     * Get a clone of the ArrayList which holds the mortgage payments for this
     * mortgage
     *
     * @return A clone of the ArrayList which holds the mortgage payments for
     * this mortgage
     * @since 0.0.1
     */
    public ArrayList<MortgagePaymentDetails> getMortgagePayments() {
        return (ArrayList<MortgagePaymentDetails>)mortgagePayments.clone();
    }

    /**
     * Get the mortgage payment by its ID if it exists for this mortgage,
     * otherwise return null
     *
     * @param paymentID The mortgage payment ID
     * @return The mortgage payment object, or null if not found
     * @since 0.0.1
     */
    public MortgagePaymentDetails getMortgagePaymentByID(final int paymentID) {
        MortgagePaymentDetails temp;

        for(Iterator it = mortgagePayments.iterator(); it.hasNext();) {
            temp = (MortgagePaymentDetails)it.next();
            if(temp.getPaymentID() == paymentID) return temp;
        }
        return null;
    }

    /**
     * Set the spouse of the customer for this mortgage
     *
     * @param customerSpouse The spouse of the customer for this mortgage
     * @since 0.0.1
     */
    public void setCustomerSpouse(final Customer customerSpouse) {
        this.customerSpouse = customerSpouse;
    }

    /**
     * Set the status of the mortgage application status
     *
     * @param applicationStatus The status of this mortgage application
     * @since 0.0.1
     */
    public void setApplicationStatus(
            final MortgageApplicationStatus applicationStatus)
    {
        this.applicationStatus = applicationStatus;
    }

    /**
     * Set the date payments begin
     *
     * @param paymentsBegin The date the payments begin
     * @throws java.lang.IllegalArgumentException When paymentsBegin is null
     * @since 0.0.1
     */
    public void setPaymentsBegin(final GregorianCalendar paymentsBegin)
            throws IllegalArgumentException
    {
        checkPaymentsBegin(paymentsBegin);
        this.paymentsBegin = paymentsBegin;
    }

    /**
     * Add a new payment for this mortgage
     *
     * @param mortgagePayment The payment to be added for this mortgage
     * @throws java.lang.IllegalArgumentException When a null mortgagePayment
     * is supplied
     * @since 0.0.1
     */
    public void addMortgagePayment(
            final MortgagePaymentDetails mortgagePayment)
            throws IllegalArgumentException
    {
        checkMortgagePayment(mortgagePayment);
        mortgagePayments.add(mortgagePayment);
    }

    /**
     * Check that the mortgage ID is not less than 0
     *
     * @param mortgageID The mortgage ID to be checked
     * @since 0.0.1
     */
    private static void checkMortgageID(final int mortgageID) {
        if(mortgageID < 0) throw new IllegalArgumentException("The mortgage " +
                "ID must not be less than 0.");
    }

    /**
     * Check the customer is not null
     *
     * @param customer The customer to be checked
     * @since 0.0.1
     */
    private static void checkCustomer(final Customer customer) {
        if(customer == null) throw new IllegalArgumentException("The " +
                "customer must not be null.");
    }

    /**
     * Check the property is not null
     *
     * @param property The property to be checked
     * @since 0.0.1
     */
    private static void checkProperty(final Property property) {
        if(property == null) throw new IllegalArgumentException("The " +
                "property must not be null.");
    }

    /**
     * Check the date of application is not null
     *
     * @param dateOfApplication The application date to be checked
     * @since 0.0.1
     */
    private static void checkDateOfApplication(
            final GregorianCalendar dateOfApplication)
    {
        if(dateOfApplication == null)
            throw new IllegalArgumentException("The date of the application " +
                    "must not be null.");
    }

    /**
     * Check the deposit is not less than 0
     *
     * @param deposit The deposit to be checked
     * @since 0.0.1
     */
    private static void checkDeposit(final float deposit) {
        if(deposit < 0) throw new IllegalArgumentException("The deposit must " +
                "not be less than 0.");
    }

    /**
     * Check the mortgage length in months is not less than 1
     *
     * @param mortgageLengthInMonths The mortgage length in months to be checked
     * @since 0.0.1
     */
    private static void checkMortgageLengthInMonths(
            final int mortgageLengthInMonths)
    {
        if(mortgageLengthInMonths < 1)
            throw new IllegalArgumentException("The mortgage length in " +
                    "months must not be less than 1.");
    }

    /**
     * Check the amount requested is greater than 0
     *
     * @param amountRequested The amount requested to be checked
     * @since 0.0.1
     */
    private static void checkAmountRequested(final float amountRequested) {
        if(amountRequested <= 0) throw new IllegalArgumentException("The " +
                "amount requested must be greater than 0.");
    }

    /**
     * Check the payments begin is not null
     *
     * @param paymentsBegin The payments begin to be checked
     * @since 0.0.1
     */
    private static void checkPaymentsBegin(
            final GregorianCalendar paymentsBegin)
    {
        if(paymentsBegin == null) throw new IllegalArgumentException("The " +
                "payments begin must not be null.");
    }

    /**
     * Check the mortgage payment is not null
     *
     * @param mortgagePayment The mortgage payment to be checked
     * @since 0.0.1
     */
    private static void checkMortgagePayment(
            final MortgagePaymentDetails mortgagePayment)
    {
        if(mortgagePayment == null) throw new IllegalArgumentException("The " +
                "mortgage payment must not be null.");
    }
}