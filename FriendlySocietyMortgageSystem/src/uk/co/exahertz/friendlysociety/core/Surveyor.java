package uk.co.exahertz.friendlysociety.core;

/**
 * This class holds the information for a surveyor who surveys properties
 *
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 * @see Person
 */
public class Surveyor {
    private int surveyorID;
    private String surveyorName;
    private String propertyName;
    private String streetName;
    private String town;
    private String country;
    private String postCode;
    private String telephone;
    private String faxNumber;
    private String email;

    /**
     * Initiate an instance of a surveyor
     *
     * @param surveyorID The unique ID of the surveyor
     * @param surveyorName The name of the surveyor
     * @param propertyName The property name of where the surveyor is
     * @param streetName The street name of where the surveyor is
     * @param town The town of where the surveyor is
     * @param country The country of where the surveyor is
     * @param postCode The post code of where the surveyor is
     * @param telephone The telephone number of the surveyor
     * @param faxNumber The fax number of the surveyor
     * @param email The email address of the surveyor
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public Surveyor(final int surveyorID, final String surveyorName,
            final String propertyName, final String streetName,
            final String town, final String country, final String postCode,
            final String telephone, final String faxNumber, final String email)
            throws IllegalArgumentException
    {
        checkSurveyorID(surveyorID);
        checkSurveyorName(surveyorName);
        checkPropertyName(propertyName);
        Person.checkStreetName(streetName);
        Person.checkTown(town);
        Person.checkCountry(country);
        Person.checkPostCode(postCode);
        Person.checkTelephone(telephone);
        Person.checkFaxNumber(faxNumber);
        Person.checkEmail(email);

        this.surveyorID = surveyorID;
        this.surveyorName = surveyorName.trim();
        this.propertyName = propertyName.trim();
        this.streetName = streetName.trim();
        this.town = town.trim();
        this.country = country.trim();
        this.postCode = postCode.trim();
        this.telephone = telephone.trim();
        if(faxNumber == null) {
            this.faxNumber = "";
        } else {
            this.faxNumber = faxNumber.trim();
        }
        if(email == null) {
            this.email = "";
        } else {
            this.email = email.trim();
        }
    }

    /**
     * Get the unique surveyor ID
     *
     * @return The unique surveyor ID
     * @since 0.0.1
     */
    public int getSurveyorID() {
        return surveyorID;
    }

    /**
     * Get the name of the surveyor
     *
     * @return The name of the surveyor
     * @since 0.0.1
     */
    public String getSurveyorName() {
        return surveyorName;
    }

    /**
     * Get the property name of the address of the surveyor
     *
     * @return The property name of the address of the surveyor
     * @since 0.0.1
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Get the street name of the surveyor
     *
     * @return The street name of the surveyor
     * @since 0.0.1
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Get the town name of the surveyor
     *
     * @return The town name of the surveyor
     * @since 0.0.1
     */
    public String getTownName() {
        return town;
    }

    /**
     * Get the country name of the surveyor
     *
     * @return The country of the surveyor
     * @since 0.0.1
     */
    public String getCountry() {
        return country;
    }

    /**
     * Get the post code of the surveyor
     *
     * @return The post code of the surveyor
     * @since 0.0.1
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Get the full address of the surveyor, in the format<br>
     * House, Street, Town, Post Code
     *
     * @return The full address of the surveyor
     */
    public String getFullAddress() {
        return propertyName + ", " + streetName + ", " + town + ", " + country +
                ", " + postCode;
    }

    /**
     * Get the contact telephone number of the surveyor
     *
     * @return The contact telephone number of the surveyor
     * @since 0.0.1
     */
    public String getTelephoneNumber() {
        return telephone;
    }

    /**
     * Get the fax number of the surveyor
     *
     * @return The fax number of the surveyor
     * @since 0.0.1
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Get the email address of the surveyor
     *
     * @return The email address of the surveyor
     * @since 0.0.1
     */
    public String getEmailAddress() {
        return email;
    }

    /**
     * Set the name of the surveyor
     *
     * @param surveyorName The new name of the surveyor
     * @throws java.lang.IllegalArgumentException When an illegal name is
     * supplied
     * @since 0.0.1
     */
    public void setSurveyorName(final String surveyorName)
            throws IllegalArgumentException
    {
        checkSurveyorName(surveyorName);
        this.surveyorName = surveyorName.trim();
    }

    /**
     * Set the name of the property
     *
     * @param propertyName The new name of the property
     * @throws java.lang.IllegalArgumentException When an illegal property name
     * is supplied
     * @since 0.0.1
     */
    public void setPropertyName(final String propertyName)
            throws IllegalArgumentException
    {
        checkPropertyName(propertyName);
        this.propertyName = propertyName.trim();
    }

    /**
     * Set the street name of the surveyor
     *
     * @param streetName The new name of the street where the surveyor is
     * @throws java.lang.IllegalArgumentException When an illegal street name
     * is supplied
     * @since 0.0.1
     */
    public void setStreetName(final String streetName)
            throws IllegalArgumentException
    {
        Person.checkStreetName(streetName);
        this.streetName = streetName.trim();
    }

    /**
     * Set the town name of where the surveyor is
     *
     * @param town The new town of where the surveyor is
     * @throws java.lang.IllegalArgumentException When an illegal town name is
     * supplied
     * @since 0.0.1
     */
    public void setTown(final String town) throws IllegalArgumentException {
        Person.checkTown(town);
        this.town = town.trim();
    }

    /**
     * Set the country name of where the surveyor is
     *
     * @param country The new country of where the surveyor is
     * @throws java.lang.IllegalArgumentException When an illegal country name
     * is supplied
     * @since 0.0.1
     */
    public void setCountry(final String country)
            throws IllegalArgumentException
    {
        Person.checkCountry(country);
        this.country = country.trim();
    }

    /**
     * Set the post code of where the surveyor us
     *
     * @param postCode The new post code of where the surveyor is
     * @throws java.lang.IllegalArgumentException When an illegal post code is
     * supplied
     * @since 0.0.1
     */
    public void setPostCode(final String postCode)
            throws IllegalArgumentException
    {
        Person.checkPostCode(postCode);
        this.postCode = postCode.trim();
    }

    /**
     * Set the telephone contact number of the surveyor
     *
     * @param telephone The new telephone number of the surveyor
     * @throws java.lang.IllegalArgumentException When an illegal telephone
     * number is supplied
     * @since 0.0.1
     */
    public void setTelephone(final String telephone)
            throws IllegalArgumentException
    {
        Person.checkTelephone(telephone);
        this.telephone = telephone.trim();
    }

    /**
     * Set the fax number of the surveyor
     *
     * @param faxNumber The new fax number of the surveyor
     * @throws java.lang.IllegalArgumentException When an illegal fax number is
     * supplied
     * @since 0.0.1
     */
    public void setFaxNumber(final String faxNumber)
            throws IllegalArgumentException
    {
        Person.checkFaxNumber(faxNumber);
        if(faxNumber == null) {
            this.faxNumber = "";
        } else {
            this.faxNumber = faxNumber.trim();
        }
    }

    /**
     * Set the contact email of the surveyor
     * @param email The new email address of the surveyor
     * @throws java.lang.IllegalArgumentException When an illegal email
     * is supplied
     * @since 0.0.1
     */
    public void setEmail(final String email) throws IllegalArgumentException {
        Person.checkEmail(email);
        if(email == null) {
            this.email = "";
        } else {
            this.email = email.trim();
        }
    }

    /**
     * Check the unique ID of the surveyor
     *
     * @param surveyorID The unique surveyor ID to be checked
     * @since 0.0.1
     */
    private static void checkSurveyorID(final int surveyorID) {
        if(surveyorID < 0) throw new IllegalArgumentException("The surveyor " +
                "ID must not be less than 0.");
    }

    /**
     * Check the name of the surveyor
     *
     * @param surveyorName The surveyor name to be checked
     * @since 0.0.1
     */
    private static void checkSurveyorName(final String surveyorName) {
        if(surveyorName == null) throw new IllegalArgumentException("The " +
                "surveyor name must not be null.");
        if(surveyorName.trim().length() < 2 ||
                surveyorName.trim().length() > 30)
            throw new IllegalArgumentException("The surveyor name must not " +
                    "be less than 2 characters long and must not exceed 30 " +
                    "characters in length.");
    }

    /**
     * Check the property name of the surveyor
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
}