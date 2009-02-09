package uk.co.exahertz.friendlysociety.core;

/**
 * This class holds the information for a surveyor who surveys properties
 *
 * @author Niall Scott
 * @version 0.0.2
 * @since 0.0.1
 * @see Person
 */
public class Surveyor {
    private int surveyorID;
    private String surveyorName;
    private Address address;
    private String telephone;
    private String faxNumber;
    private String email;

    /**
     * Initiate an instance of a surveyor
     *
     * @param surveyorID The unique ID of the surveyor
     * @param surveyorName The name of the surveyor
     * @param address The address details of the surveyor
     * @param telephone The telephone number of the surveyor
     * @param faxNumber The fax number of the surveyor
     * @param email The email address of the surveyor
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public Surveyor(final int surveyorID, final String surveyorName,
            final Address address, final String telephone,
            final String faxNumber, final String email)
            throws IllegalArgumentException
    {
        checkSurveyorID(surveyorID);
        checkSurveyorName(surveyorName);
        checkSurveyorAddress(address);
        Person.checkTelephone(telephone);
        Person.checkFaxNumber(faxNumber);
        Person.checkEmail(email);

        this.surveyorID = surveyorID;
        this.surveyorName = surveyorName.trim();
        this.address = address;
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
     * Get the address object of this surveyor
     *
     * @return The address object of this surveyor
     * @since 0.0.1
     */
    public Address getSurveyorAddressObject() {
        return address;
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
     * Set the address object of this surveyor
     *
     * @param address The new address object of this surveyor
     * @since 0.0.1
     */
    public void setSurveyorAddressObject(final Address address) {
        checkSurveyorAddress(address);
        this.address = address;
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
     * Check the surveyor address to ensure it is not null
     *
     * @param address The surveyor address to be checked
     * @since 0.0.1
     */
    private static void checkSurveyorAddress(final Address address) {
        if(address == null) throw new IllegalArgumentException("The address " +
                "must not be null.");
    }
}