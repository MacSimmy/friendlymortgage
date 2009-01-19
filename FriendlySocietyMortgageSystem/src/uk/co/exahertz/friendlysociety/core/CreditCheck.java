package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;

/**
 * The CreditCheck class holds the data relevant to a credit check against a
 * customer
 *
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 */
public class CreditCheck {
    private int creditCheckID;
    private GregorianCalendar creditCheckDate;
    private int creditCheckScore;
    private String creditCheckRiskStatus;
    private Customer customer;

    /**
     * Create a new instance of the credit check class.
     *
     * @param creditCheckID The unique ID of the credit check
     * @param creditCheckDate The date the customer was credit checked
     * @param creditCheckScore The credit check score for the customer
     * @param creditCheckRiskStatus The credit check risk status for the
     * customer
     * @param customer The customer that has been credit checked
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public CreditCheck(final int creditCheckID,
            final GregorianCalendar creditCheckDate, final int creditCheckScore,
            final String creditCheckRiskStatus, final Customer customer)
            throws IllegalArgumentException
    {
        checkCreditCheckID(creditCheckID);
        checkCreditCheckDate(creditCheckDate);
        checkCreditCheckScore(creditCheckScore);
        checkCreditCheckRiskStatus(creditCheckRiskStatus);
        checkCustomer(customer);

        this.creditCheckID = creditCheckID;
        this.creditCheckDate = creditCheckDate;
        this.creditCheckScore = creditCheckScore;
        this.creditCheckRiskStatus = creditCheckRiskStatus.trim();
        this.customer = customer;
    }

    /**
     * Get the unique ID of the credit check
     * 
     * @return The unique ID of the credit check
     * @since 0.0.1
     */
    public int getID() {
        return creditCheckID;
    }

    /**
     * Get the date the credit check was done for a customer
     *
     * @return The date the credit check was done for the customer
     * @since 0.0.1
     */
    public GregorianCalendar getCreditCheckDate() {
        return creditCheckDate;
    }

    /**
     * Get the score of a credit check on the customer
     *
     * @return The score of a credit check on the customer
     * @since 0.0.1
     */
    public int getCreditCheckScore() {
        return creditCheckScore;
    }

    /**
     * Get the credit check risk status on a customer
     *
     * @return The credit check risk status on a customer
     * @since 0.0.1
     */
    public String getCreditCheckRiskStatus() {
        return creditCheckRiskStatus.toLowerCase();
    }

    /**
     * Get the customer for whom this credit check is for
     * 
     * @return The customer for whom this credit check is for
     * @since 0.0;1
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Check to make sure the credit check ID is not less than 0
     *
     * @param creditCheckID The credit check ID to be checked
     * @since 0.0.1
     */
    private static void checkCreditCheckID(final int creditCheckID) {
        if(creditCheckID < 0) throw new IllegalArgumentException("The credit " +
                "check ID must not be less than 0.");
    }

    /**
     * Check to make sure the credit check date is not null
     *
     * @param date The date to be checked
     * @since 0.0.1
     */
    private static void checkCreditCheckDate(final GregorianCalendar date) {
        if(date == null) throw new IllegalArgumentException("The credit " +
                "check date must not be null.");
    }

    /**
     * Check the credit check score to ensure it is in the range of 1 to 1000
     *
     * @param creditCheckScore The credit check score to be checked
     * @since 0.0.1
     */
    private static void checkCreditCheckScore(final int creditCheckScore) {
        if(creditCheckScore < 1 || creditCheckScore > 1000)
            throw new IllegalArgumentException("The credit check score must " +
                    "be in the range of 1 to 1000.");
    }

    /**
     * Check the credit risk status for a customer is either 'high', 'medium'
     * or 'low'
     *
     * @param creditCheckRiskStatus The credit check status to be checked
     * @since 0.0.1
     */
    private static void checkCreditCheckRiskStatus(
            final String creditCheckRiskStatus)
    {
        if(!creditCheckRiskStatus.trim().toLowerCase().equals("high") &&
                !creditCheckRiskStatus.trim().toLowerCase().equals("medium") &&
                !creditCheckRiskStatus.trim().toLowerCase().equals("low"))
            throw new IllegalArgumentException("The credit check risk status " +
                    "must be high, medium or low.");
    }

    /**
     * Check the customer supplied is not null
     *
     * @param customer The customer to be checked
     * @since 0.0.1
     */
    private static void checkCustomer(final Customer customer) {
        if(customer == null) throw new IllegalArgumentException("The " +
                "customer must not be null.");
    }
}