package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;

/**
 * The Employment class holds details concerning a customer's employment which
 * is used when making a decision about awarding a customer a mortgage
 *
 * @author Niall Scott
 * @version 0.0.3
 * @since 0.0.1
 * @see Person
 */
public class Employment {
    private int employmentID;
    private String employerName;
    private Address employerAddress;
    private String employerTelephone;
    private String employerFax;
    private GregorianCalendar dateStarted;
    private GregorianCalendar dateEnded;
    private float hoursPerWeek;
    private float currentAnnualSalery;
    private boolean permenant;
    private boolean selfEmployed;

    /**
     * Create a new employment for a customer. It is important that if a
     * customer is still employed by their employer that NULL is supplied to
     * the dateEnded argument
     *
     * @param employmentID The unique ID of this employment
     * @param employerName The name of the employer
     * @param employerAddress The address details of the employer
     * @param employerTelephone The telephone contact number of the employer
     * @param employerFax The fax number of the employer
     * @param dateStarted The date on which the customer started their
     * employment with this employer
     * @param dateEnded The date on which the employment ended with this
     * employer. Null should be supplied if the customer is still employed by
     * this employer.
     * @param hoursPerWeek The number of hours a week the customer works in
     * their employment
     * @param currentAnnualSalery The current annual salery the customer
     * receives from this employment
     * @param permenant This person's permenant employment status
     * @param selfEmployed This person's self employment status
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public Employment(final int employmentID, final String employerName,
            final Address employerAddress, final String employerTelephone,
            final String employerFax, final GregorianCalendar dateStarted,
            final GregorianCalendar dateEnded, final float hoursPerWeek,
            final float currentAnnualSalery, final boolean permenant,
            final boolean selfEmployed)
            throws IllegalArgumentException
    {
        checkEmploymentID(employmentID);
        checkEmployerName(employerName);
        checkEmployerAddress(employerAddress);
        Person.checkTelephone(employerTelephone);
        Person.checkFaxNumber(employerFax);
        checkStartDate(dateStarted);
        checkHoursPerWeek(hoursPerWeek);
        checkCurrentAnnualSalery(currentAnnualSalery);

        this.employmentID = employmentID;
        this.employerName = employerName.trim();
        this.employerAddress = employerAddress;
        this.employerTelephone = employerTelephone.trim();
        // 02/04/09 added modif to prevent NullPointerException:
        if (employerFax != null)
            this.employerFax = employerFax.trim();
        else
            this.employerFax = null;
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        this.hoursPerWeek = hoursPerWeek;
        this.currentAnnualSalery = currentAnnualSalery;
        this.permenant = permenant;
        this.selfEmployed = selfEmployed;
    }

    /**
     * Get the unique employment ID
     * 
     * @return The unique employment ID
     * @since 0.0.3
     */
    public int getEmploymentID() {
        return employmentID;
    }

    /**
     * Get the name of the employer for this customer
     *
     * @return The name of the employer for this customer
     * @since 0.0.1
     */
    public String getEmployerName() {
        return employerName;
    }

    /**
     * Get the Address instance for the address of this employer
     *
     * @return The Address instance for the address of this employer
     * @since 0.0.1
     */
    public Address getEmployerAddressObject() {
        return employerAddress;
    }

    /**
     * Get the telephone number of the employer
     *
     * @return The telephone number of the employer
     * @since 0.0.1
     */
    public String getEmployerTelephone() {
        return employerTelephone;
    }

    /**
     * Get the fax number of the employer
     *
     * @return The fax number of the employer
     * @since 0.0.1
     */
    public String getEmployerFax() {
        return employerFax;
    }

    /**
     * Get the date on which the customer started their employment with this
     * employer
     *
     * @return The date on which the customer started their employment with
     * this employer
     * @since 0.0.1
     */
    public GregorianCalendar getDateStarted() {
        return dateStarted;
    }

    /**
     * Get the date on which the customer ended their employment with this
     * employer. The return value may be null, this indicates that they are
     * still employed by this employer.
     *
     * @return The date on which the customer ended their employment with this
     * employer. May be null to signify that the customer is still with this
     * employer
     * @since 0.0.1
     */
    public GregorianCalendar getDateEnded() {
        return dateEnded;
    }

    /**
     * Get the hours per week that the customer works in their employment
     *
     * @return The hours per week that the customer works in their employment
     * @since 0.0.1
     */
    public float getHoursPerWeek() {
        return hoursPerWeek;
    }

    /**
     * Get the current annual salery the customer receives in their employment
     *
     * @return The current annual salery the customer receives in their
     * employment
     * @since 0.0.1
     */
    public float getCurrentAnnualSalery() {
        return currentAnnualSalery;
    }

    /**
     * Get the permenant status of this person's employment
     *
     * @return The permenant status of this person's employment
     * @since 0.0.1
     */
    public boolean isEmploymentPermenant() {
        return permenant;
    }

    /**
     * Get the person's self employment status
     *
     * @return The person's self employment status
     * @since 0.0.1
     */
    public boolean isSelfEmployed() {
        return selfEmployed;
    }

    /**
     * Set the name of the employer
     *
     * @param employerName The new name of the employer
     * @throws java.lang.IllegalArgumentException When an illegal employer name
     * is supplied
     * @since 0.0.1
     */
    public void setEmployerName(final String employerName)
            throws IllegalArgumentException
    {
        checkEmployerName(employerName);
        this.employerName = employerName.trim();
    }

    /**
     * Set the address object of this employer
     *
     * @param employerAddress The new address object of this employer
     * @throws java.lang.IllegalArgumentException When a null address object is
     * supplied
     * @since 0.0.1
     */
    public void setEmployerAddressObject(final Address employerAddress)
            throws IllegalArgumentException
    {
        checkEmployerAddress(employerAddress);
        this.employerAddress = employerAddress;
    }

    /**
     * Set the telephone number of the employer
     *
     * @param employerTelephone The new telephone number of the employer
     * @throws java.lang.IllegalArgumentException When an illegal telephone
     * number is supplied
     * @since 0.0.1
     */
    public void setEmployerTelephone(final String employerTelephone)
            throws IllegalArgumentException
    {
        Person.checkTelephone(employerTelephone);
        this.employerTelephone = employerTelephone.trim();
    }

    /**
     * Set the fax number of the employer
     *
     * @param employerFax The new fax number of the employer
     * @throws java.lang.IllegalArgumentException When an illegal fax number is
     * supplied
     * @since 0.0.1
     */
    public void setEmployerFax(final String employerFax)
            throws IllegalArgumentException
    {
        Person.checkFaxNumber(employerFax);
        this.employerFax = employerFax.trim();
    }

    /**
     * Set the end date of the employment with this employer for the customer
     *
     * @param dateEnded The end date of the employment with this employer
     * @since 0.0.1
     */
    public void setDateEnded(final GregorianCalendar dateEnded) {
        this.dateEnded = dateEnded;
    }

    /**
     * Set the hours per week that the customer works in this employment
     *
     * @param hoursPerWeek The amount of hours per week the customer works in
     * this employment
     * @throws java.lang.IllegalArgumentException When 0 or less hours are
     * specified
     * @since 0.0.1
     */
    public void setHoursPerWeek(final float hoursPerWeek)
            throws IllegalArgumentException
    {
        checkHoursPerWeek(hoursPerWeek);
        this.hoursPerWeek = hoursPerWeek;
    }

    /**
     * Set the current annual salery the customer receives in this employment
     *
     * @param currentAnnualSalery The current annual salery the customer
     * receives in this employment
     * @throws java.lang.IllegalArgumentException When a salery of 0 or less is
     * specified
     * @since 0.0.1
     */
    public void setCurrentAnnualSalery(final float currentAnnualSalery)
            throws IllegalArgumentException
    {
        checkCurrentAnnualSalery(currentAnnualSalery);
        this.currentAnnualSalery = currentAnnualSalery;
    }

    /**
     * Set the permenant status of this person's employment
     *
     * @param permenant The new permenant status of this person's employment
     * @since 0.0.1
     */
    public void setJobIsPermenant(final boolean permenant) {
        this.permenant = permenant;
    }

    /**
     * Set the self employment status for this person
     *
     * @param selfEmployed The new self employment status for this person
     * @since 0.0.1
     */
    public void setSelfEmployed(final boolean selfEmployed) {
        this.selfEmployed = selfEmployed;
    }

    /**
     * Check the employment ID is not less than 0
     *
     * @param employmentID The employment ID to be checked
     * @since 0.0.3
     */
    private static void checkEmploymentID(final int employmentID) {
        if(employmentID < 0) throw new IllegalArgumentException("The " +
                "employment ID must be 0 or greater.");
    }

    /**
     * Check to ensure the employer name is not null and is of sane length
     *
     * @param employerName The employer name to be checked
     * @since 0.0.1
     */
    private static void checkEmployerName(final String employerName) {
        if(employerName == null) throw new IllegalArgumentException("The " +
                "employer name must not be null.");
        if(employerName.trim().length() < 1 ||
                employerName.trim().length() > 30)
            throw new IllegalArgumentException("The length of the employer " +
                    "name must be between 1 and 30 characters long.");
    }

    /**
     * Check the employer address to ensure it is not null
     *
     * @param employerAddress The employer address to be checked
     * @since 0.0.1
     */
    private static void checkEmployerAddress(final Address employerAddress) {
        if(employerAddress == null) throw new IllegalArgumentException("The " +
                "employer address must not be null.");
    }

    /**
     * Check to ensure the start date is not null
     *
     * @param startDate The start date to be checked
     * @since 0.0.1
     */
    private static void checkStartDate(final GregorianCalendar startDate) {
        if(startDate == null) throw new IllegalArgumentException("The start " +
                "date must not be null.");
    }

    /**
     * Check to ensure the hours per week is not 0
     *
     * @param hoursPerWeek The hours per week to be checked
     * @since 0.0.1
     */
    private static void checkHoursPerWeek(final float hoursPerWeek) {
        if(hoursPerWeek <= 0) throw new IllegalArgumentException("The hours " +
                "per week of this employment must be greater than 0.");
    }

    /**
     * Check to ensure the current annual salery is not 0
     *
     * @param currentAnnualSalery The annual salery to be checked
     * @since 0.0.1
     */
    private static void checkCurrentAnnualSalery(
            final float currentAnnualSalery)
    {
        if(currentAnnualSalery <= 0) throw new IllegalArgumentException("The " +
                "current yearly salery of this employment must be greater " +
                "0.");
    }
}