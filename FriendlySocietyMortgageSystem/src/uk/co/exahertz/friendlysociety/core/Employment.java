package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;

/**
 * The Employment class holds details concerning a customer's employment which
 * is used when making a decision about awarding a customer a mortgage
 *
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 * @see Person
 */
public class Employment {
    private String employerName;
    private String employerPropertyName;
    private String employerStreetName;
    private String employerTownName;
    private String employerCountryName;
    private String employerPostCode;
    private String employerTelephone;
    private String employerFax;
    private GregorianCalendar dateStarted;
    private GregorianCalendar dateEnded;
    private float hoursPerWeek;
    private float currentAnnualSalery;

    /**
     * Create a new employment for a customer. It is important that if a
     * customer is still employed by their employer that NULL is supplied to
     * the dateEnded argument
     *
     * @param employerName The name of the employer
     * @param employerPropertyName The property name of where the employer is
     * @param employerStreetName The street name of where the employer is
     * @param employerTownName The town name of where the employer is
     * @param employerCountryName The name of the country where the employer is
     * @param employerPostCode The post code of the employer
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
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public Employment(final String employerName,
            final String employerPropertyName, final String employerStreetName,
            final String employerTownName, final String employerCountryName,
            final String employerPostCode, final String employerTelephone,
            final String employerFax, final GregorianCalendar dateStarted,
            final GregorianCalendar dateEnded, final float hoursPerWeek,
            final float currentAnnualSalery)
            throws IllegalArgumentException
    {
        checkEmployerName(employerName);
        checkPropertyName(employerPropertyName);
        Person.checkStreetName(employerStreetName);
        Person.checkTown(employerTownName);
        Person.checkCountry(employerCountryName);
        Person.checkPostCode(employerPostCode);
        Person.checkTelephone(employerTelephone);
        Person.checkFaxNumber(employerFax);
        checkStartDate(dateStarted);
        checkHoursPerWeek(hoursPerWeek);
        checkCurrentAnnualSalery(currentAnnualSalery);

        this.employerName = employerName.trim();
        this.employerPropertyName = employerPropertyName.trim();
        this.employerStreetName = employerStreetName.trim();
        this.employerTownName = employerTownName.trim();
        this.employerCountryName = employerCountryName.trim();
        this.employerPostCode = employerPostCode.trim();
        this.employerTelephone = employerTelephone.trim();
        this.employerFax = employerFax.trim();
        this.dateStarted = dateStarted;
        this.dateEnded = dateEnded;
        this.hoursPerWeek = hoursPerWeek;
        this.currentAnnualSalery = currentAnnualSalery;
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
     * Get the property name of the employer
     *
     * @return The property name of the employer
     * @since 0.0.1
     */
    public String getEmployerPropertyName() {
        return employerPropertyName;
    }

    /**
     * Get the street name of where the employer is
     *
     * @return The street name of where the employer is
     * @since 0.0.1
     */
    public String getEmployerStreetName() {
        return employerStreetName;
    }

    /**
     * Get the town name of where the employer is
     *
     * @return The town name of where the employer is
     * @since 0.0.1
     */
    public String getEmployerTownName() {
        return employerTownName;
    }

    /**
     * Get the town name of where the employer is
     *
     * @return The town name of where the employer is
     * @since 0.0.1
     */
    public String getEmployerCountryName() {
        return employerCountryName;
    }

    /**
     * Get the post code of the employer
     *
     * @return The post code of the employer
     * @since 0.0.1
     */
    public String getEmployerPostCode() {
        return employerPostCode;
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
     * Set the property name of the employer
     *
     * @param employerPropertyName The new property name of the employer
     * @throws java.lang.IllegalArgumentException When an illegal property name
     * is supplied
     * @since 0.0.1
     */
    public void setEmployerPropertyName(final String employerPropertyName)
            throws IllegalArgumentException
    {
        checkPropertyName(employerPropertyName);
        this.employerPropertyName = employerPropertyName.trim();
    }

    /**
     * Set the street name of where the employer is located
     *
     * @param employerStreetName The new street name of the employer
     * @throws java.lang.IllegalArgumentException When an illegal street name
     * is supplied
     * @since 0.0.1
     */
    public void setEmployerStreetName(final String employerStreetName)
            throws IllegalArgumentException
    {
        Person.checkStreetName(employerStreetName);
        this.employerStreetName = employerStreetName.trim();
    }

    /**
     * Set the town name of where the employer is located
     *
     * @param employerTownName The new town name of the employer
     * @throws java.lang.IllegalArgumentException When an illegal town name is
     * supplied
     * @since 0.0.1
     */
    public void setEmployerTownName(final String employerTownName)
            throws IllegalArgumentException
    {
        Person.checkTown(employerTownName);
        this.employerTownName = employerTownName.trim();
    }

    /**
     * Set the name of the country where the employer is located
     *
     * @param employerCountryName The new country name of the employer
     * @throws java.lang.IllegalArgumentException When an illegal country name
     * is supplied
     * @since 0.0.1
     */
    public void setEmployerCountryName(final String employerCountryName)
            throws IllegalArgumentException
    {
        Person.checkCountry(employerCountryName);
        this.employerCountryName = employerCountryName.trim();
    }

    /**
     * Set the post code of the employer
     *
     * @param employerPostCode The new post code of the employer
     * @throws java.lang.IllegalArgumentException When an illegal post code is
     * supplied
     * @since 0.0.1
     */
    public void setEmployerPostCode(final String employerPostCode)
            throws IllegalArgumentException
    {
        Person.checkPostCode(employerPostCode);
        this.employerPostCode = employerPostCode.trim();
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
     * Check the property name of the employer
     *
     * @param propertyName The property name to be checked
     * @since 0.0.1
     */
    private static void checkPropertyName(final String propertyName) {
        if(propertyName == null) throw new IllegalArgumentException("The " +
                "property name must not be null.");
        if(propertyName.trim().length() < 1 ||
                propertyName.trim().length() > 30)
            throw new IllegalArgumentException("The length of the property " +
                    "name must not be shorter than 1 character and must not " +
                    "exceed 30 characters.");
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