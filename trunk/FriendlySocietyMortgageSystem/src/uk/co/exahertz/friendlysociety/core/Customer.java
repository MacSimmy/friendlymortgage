package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;
import java.util.ArrayList;

/**
 * The Customer class contains all of the properties which belong to one
 * customer. A customer may have a savings account number if they already hold
 * a savings account with the Friendly Society, otherwise they wont. Every
 * customer MUST have a National Insurance Number.
 *
 * @author Niall Scott
 * @version 0.0.3
 * @since 0.0.1
 * @see Person
 */
public class Customer extends Person {
    private int customerID;
    private String nationalInsuranceNumber;
    private String savingsAccountNumber;
    private ArrayList<Employment> employment;

    /**
     * Initiate a new instance of a Customer
     *
     * @param title The title of the customer
     * @param forenames The forenames of the customer
     * @param surname The surname of the customer
     * @param dateOfBirth The date of birth of the customer
     * @param isFemale The gender of the customer
     * @param address An address object containing the address details for this
     * customer
     * @param telephone The telephone number of the customer
     * @param faxNumber The fax number of the customer
     * @param email The email address of the customer
     * @param customerID The unique ID of the customer
     * @param nationalInsuranceNumber The National Insurance Number of the
     * customer
     * @param savingsAccountNumber A savings account number if the customer
     * already holds a savings account with the Friendly Society
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public Customer(final String title, final String forenames,
            final String surname, final GregorianCalendar dateOfBirth,
            final boolean isFemale, final Address address, 
            final String telephone, final String faxNumber, final String email,
            final int customerID, final String nationalInsuranceNumber,
            final String savingsAccountNumber)
            throws IllegalArgumentException
    {
        super(title, forenames, surname, dateOfBirth, isFemale, address,
                telephone, faxNumber, email);

        checkCustomerID(customerID);
        checkNationalInsuranceNumber(nationalInsuranceNumber);

        this.customerID = customerID;
        this.nationalInsuranceNumber = nationalInsuranceNumber.trim();
        if(savingsAccountNumber == null) {
            this.savingsAccountNumber = "";
        } else {
            this.savingsAccountNumber = savingsAccountNumber.trim();
        }
        employment = new ArrayList<Employment>();
    }

    /**
     * Get the unique ID of the customer
     *
     * @return The unique ID of the customer
     * @since 0.0.1
     */
    public int getID() {
        return customerID;
    }

    /**
     * Get the National Insurance Number of the customer
     *
     * @return The National Insurance Number of the customer
     * @since 0.0.1
     */
    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    /**
     * Get the savings account number of the customer. If the customer does
     * not hold a savings account with the Friendly Society, a blank String
     * will be returned
     *
     * @return The savings account number of a customer, or a blank String
     * @since 0.0.1
     */
    public String getSavingsAccountNumber() {
        return savingsAccountNumber;
    }

    /**
     * Get a clone of the ArrayList<Employment> which holds all employment
     * details for a customer
     *
     * @return A clone of the ArrayList<Employment> holding the employment
     * details for a customer
     * @since 0.0.1
     */
    public ArrayList<Employment> getEmploymentDetails() {
        return (ArrayList<Employment>)employment.clone();
    }

    /**
     * Add a new employment for this customer
     *
     * @param employmentDetails The employment details for a customer
     * @since 0.0.1
     */
    public void addEmploymentDetails(final Employment employmentDetails) {
        employment.add(employmentDetails);
    }

    /**
     * Set the National Insurance Number of a customer. A valid number must be
     * in the form AB123456C
     *
     * @param nationalInsuranceNumber The new National Insurance Number of the
     * customer
     * @throws java.lang.IllegalArgumentException When an illegal National
     * Insurance Number is supplied
     * @since 0.0.1
     */
    public void setNationalInsuranceNumber(final String nationalInsuranceNumber)
            throws IllegalArgumentException
    {
        checkNationalInsuranceNumber(nationalInsuranceNumber);
        this.nationalInsuranceNumber = nationalInsuranceNumber.trim();
    }

    /**
     * Set the savings account number of the customer, if they hold a savings
     * account with the Friendly Society
     *
     * @param savingsAccountNumber A new savings account number for the customer
     * @since 0.0.1
     */
    public void setSavingsAccountNumber(final String savingsAccountNumber) {
        this.savingsAccountNumber = savingsAccountNumber.trim();
    }

    /**
     * Checks to make sure the customerID is not less than 0
     *
     * @param customerID The customer ID to be checked
     * @since 0.0.1
     */
    private static void checkCustomerID(final int customerID) {
        if(customerID < 0) throw new IllegalArgumentException("The customerID" +
                " must not be less than 0.");
    }

    /**
     * Check to make sure the National Insurance Number is valid. National
     * Insurance Numbers must be in the format AB123456C
     *
     * @param nationalInsuranceNumber A National Insurance Number to be checked
     * for validity
     * @since 0.0.1
     */
    private static void checkNationalInsuranceNumber(
            final String nationalInsuranceNumber)
    {
        if(nationalInsuranceNumber == null)
            throw new IllegalArgumentException("The National Insurance " +
                    "Number must not be null.");
        if(nationalInsuranceNumber.trim().length() != 9)
            throw new IllegalArgumentException("The length of a valid UK " +
                    "National Insurance Number is 9 characters.");
        for(int i=0; i < 9; i++) {
            if(i == 0 || i == 1 || i == 8) {
                if(!Character.isLetter(
                        nationalInsuranceNumber.trim().charAt(i)))
                    throw new IllegalArgumentException("National Insurance " +
                            "Numbers must be in the format AB123456C.");
            } else {
                if(!Character.isDigit(
                        nationalInsuranceNumber.trim().charAt(i)))
                    throw new IllegalArgumentException("National Insurance " +
                            "Numbers must be in the format AB123456C.");
            }
        }
    }
}