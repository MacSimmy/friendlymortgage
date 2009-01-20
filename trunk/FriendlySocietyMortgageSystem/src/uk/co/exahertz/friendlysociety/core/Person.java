package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 * The Person abstract class contains all of the properties which are common to
 * both a Customer and a member of Staff.
 *
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 * @see StaffMember
 * @see Customer
 */
public abstract class Person {
    private String title;
    private String forenames;
    private String surname;
    private GregorianCalendar dateOfBirth;
    private boolean isFemale;
    private String houseName;
    private String streetName;
    private String town;
    private String country;
    private String postCode;
    private String telephone;
    private String faxNumber;
    private String email;

    /** The minimum age a person can be */
    public static final int MINAGE = 18;
    /** The maximum age a person can be */
    public static final int MAXAGE = 80;

    /**
     * The constructor for the Person class. This class can not be initialised
     * directly as it is abstract, it can only be initialised from its
     * decendants.<br>
     * This class holds most details for a person who may be involved with the
     * system, be it a member of staff or a customer.
     * 
     * @param title The title (eg Mr/Mrs) of the person
     * @param forenames The person's forenames
     * @param surname The person's surname
     * @param dateOfBirth The date of birth of the person, in GregorianCalendar
     * form
     * @param isFemale The sex of the person
     * @param houseName The house name or number of occupancy of the person
     * @param streetName The street name of occupancy of the person
     * @param town The town in which the person resides
     * @param country The country in which the person resides
     * @param postCode The post code of the address the person resides
     * @param telephone The contact telephone number of the person
     * @param faxNumber The fax number of the person, if it exists
     * @param email The email address of the person, if it exists
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public Person(final String title, final String forenames,
            final String surname, final GregorianCalendar dateOfBirth,
            final boolean isFemale, final String houseName,
            final String streetName, final String town, final String country,
            final String postCode, final String telephone,
            final String faxNumber, final String email)
            throws IllegalArgumentException
    {
        checkTitle(title);
        checkForenames(forenames);
        checkSurname(surname);
        checkDateOfBirth(dateOfBirth);
        checkHouseName(houseName);
        checkStreetName(streetName);
        checkTown(town);
        checkCountry(country);
        checkPostCode(postCode);
        checkTelephone(telephone);
        checkFaxNumber(faxNumber);
        checkEmail(email);

        this.title = title.trim();
        this.forenames = forenames.trim();
        this.surname = surname.trim();
        this.dateOfBirth = dateOfBirth;
        this.isFemale = isFemale;
        this.houseName = houseName.trim();
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
     * Get the title of the person, eg Mr/Mrs
     *
     * @return The title of the person
     * @since 0.0.1
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the forenames of the person
     *
     * @return The forenames of the person
     * @since 0.0.1
     */
    public String getForenames() {
        return forenames;
    }

    /**
     * Get the surname of the person
     *
     * @return The surname of the person
     * @since 0.0.1
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Get the full name of the person, not including their title
     *
     * @return The full name of the person, excluding their title
     * @since 0.0.1
     */
    public String getFullName() {
        return forenames + " " + surname;
    }

    /**
     * Get the full name of the person, including their title
     *
     * @return The full name of the person, including their title
     * @since 0.0.1
     */
    public String getFullNameAndTitle() {
        return title + " " + forenames + " " + surname;
    }

    /**
     * Get the date of birth of the person as a GregorianCalendar object
     *
     * @return The date of birth of the person as a GregorianCalendar object
     * @since 0.0.1
     */
    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Get the age of the person
     *
     * @return The age of the person
     * @since 0.0.1
     */
    public int getAge() {
        return getYearsSinceBirth(dateOfBirth);
    }

    /**
     * Get the "is female" status of a person
     * @return True if person is female
     */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Get the sex of the person as a single character, M or F
     *
     * @return Thre sex of the person as a single character, M or F
     * @since 0.0.1
     */
    public char getSexByChar() {
        if(isFemale) {
            return 'F';
        } else {
            return 'M';
        }
    }

    /**
     * Get the sex of the person as a String, Male or Female
     *
     * @return The sex of the person as a String, Male or Female
     * @since 0.0.1
     */
    public String getSexByString() {
        if(isFemale) {
            return "Female";
        } else {
            return "Male";
        }
    }

    /**
     * Get the house name or number of where the person lives
     *
     * @return The house name or number of where the person lives
     * @since 0.0.1
     */
    public String getHouseName() {
        return houseName;
    }

    /**
     * Get the street name of where the person lives
     *
     * @return The street name of where the person lives
     * @since 0.0.1
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Get the town name of where the person lives
     *
     * @return The town name of where the person lives
     * @since 0.0.1
     */
    public String getTownName() {
        return town;
    }

    /**
     * Get the country name of where the person lives
     *
     * @return The country of where the person lives
     * @since 0.0.1
     */
    public String getCountry() {
        return country;
    }

    /**
     * Get the post code of where the person lives
     *
     * @return The post code of where the person lives
     * @since 0.0.1
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Get the full address of where the person lives, in the format<br>
     * House, Street, Town, Post Code
     *
     * @return The full address of where the person lives
     */
    public String getFullAddress() {
        return houseName + ", " + streetName + ", " + town + ", " + country +
                ", " + postCode;
    }

    /**
     * Get the contact telephone number of the person
     *
     * @return The contact telephone number of the person
     * @since 0.0.1
     */
    public String getTelephoneNumber() {
        return telephone;
    }

    /**
     * Get the fax number of the person
     *
     * @return The fax number of the person
     * @since 0.0.1
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Get the email address of the person
     *
     * @return The email address of the person
     * @since 0.0.1
     */
    public String getEmailAddress() {
        return email;
    }

    /**
     * Set the title of the person
     *
     * @param title The new title of the person
     * @throws java.lang.IllegalArgumentException When an illegal title is
     * supplied
     * @since 0.0.1
     */
    public void setTitle(final String title) throws IllegalArgumentException {
        checkTitle(title);
        this.title = title.trim();
    }

    /**
     * Set the forenames for the person
     *
     * @param forenames The new forenames of the person
     * @throws java.lang.IllegalArgumentException When an illegal forename is
     * supplied
     * @since 0.0.1
     */
    public void setForenames(final String forenames)
            throws IllegalArgumentException
    {
        checkForenames(forenames);
        this.forenames = forenames.trim();
    }

    /**
     * Set a surname for the person
     *
     * @param surname The new surname of the person
     * @throws java.lang.IllegalArgumentException When an illegal forename is
     * supplied
     * @since 0.0.1
     */
    public void setSurname(final String surname)
            throws IllegalArgumentException
    {
        checkSurname(surname);
        this.surname = surname.trim();
    }

    /**
     * Set the gender for the person, True if they are female, False if they
     * are male
     *
     * @param isFemale The new gender of the person (in case of sex change)
     * @since 0.0.1
     */
    public void setIsFemale(final boolean isFemale) {
        this.isFemale = isFemale;
    }

    /**
     * Set the house name of where the person lives
     *
     * @param houseName The new name of the property where the person lives
     * @throws java.lang.IllegalArgumentException When an illegal house name
     * is supplied
     * @since 0.0.1
     */
    public void setHouseName(final String houseName)
            throws IllegalArgumentException
    {
        checkHouseName(houseName);
        this.houseName = houseName.trim();
    }

    /**
     * Set the street name of where the person lives
     *
     * @param streetName The new name of the street where the person lives
     * @throws java.lang.IllegalArgumentException When an illegal street name
     * is supplied
     * @since 0.0.1
     */
    public void setStreetName(final String streetName)
            throws IllegalArgumentException
    {
        checkStreetName(streetName);
        this.streetName = streetName.trim();
    }

    /**
     * Set the town name of where the person lives
     *
     * @param town The new town of where the person lives
     * @throws java.lang.IllegalArgumentException When an illegal town name is
     * supplied
     * @since 0.0.1
     */
    public void setTown(final String town) throws IllegalArgumentException {
        checkTown(town);
        this.town = town.trim();
    }

    /**
     * Set the country name of where the person lives
     *
     * @param country The new country of where the person lives
     * @throws java.lang.IllegalArgumentException When an illegal country name
     * is supplied
     * @since 0.0.1
     */
    public void setCountry(final String country)
            throws IllegalArgumentException
    {
        checkCountry(country);
        this.country = country.trim();
    }

    /**
     * Set the post code of where the person lives
     *
     * @param postCode The new post code of where the person lives
     * @throws java.lang.IllegalArgumentException When an illegal post code is
     * supplied
     * @since 0.0.1
     */
    public void setPostCode(final String postCode)
            throws IllegalArgumentException
    {
        checkPostCode(postCode);
        this.postCode = postCode.trim();
    }

    /**
     * Set the telephone contact number of the person
     *
     * @param telephone The new telephone number of the person
     * @throws java.lang.IllegalArgumentException When an illegal telephone
     * number is supplied
     * @since 0.0.1
     */
    public void setTelephone(final String telephone)
            throws IllegalArgumentException
    {
        checkTelephone(telephone);
        this.telephone = telephone.trim();
    }

    /**
     * Set the fax number of the person
     *
     * @param faxNumber The new fax number of the person
     * @throws java.lang.IllegalArgumentException When an illegal fax number is
     * supplied
     * @since 0.0.1
     */
    public void setFaxNumber(final String faxNumber)
            throws IllegalArgumentException
    {
        checkFaxNumber(faxNumber);
        if(faxNumber == null) {
            this.faxNumber = "";
        } else {
            this.faxNumber = faxNumber.trim();
        }
    }

    /**
     * Set the contact email of the person
     * @param email The new email address of the person
     * @throws java.lang.IllegalArgumentException When an illegal email
     * is supplied
     * @since 0.0.1
     */
    public void setEmail(final String email) throws IllegalArgumentException {
        checkEmail(email);
        if(email == null) {
            this.email = "";
        } else {
            this.email = email.trim();
        }
    }

    /**
     * This method calculates the age of a person. This method was taken
     * from <a href="http://www.rgagnon.com/javadetails/java-0547.html">
     * http://www.rgagnon.com/javadetails/java-0547.html</a>
     *
     * @param dob The instance of Calendar containing the date of birth
     * @return The length of time, in years, since the person was born
     * @since 0.0.1
     */
    public static int getYearsSinceBirth(final Calendar dob) {
        GregorianCalendar now = new GregorianCalendar();
        int res = now.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if((dob.get(Calendar.MONTH) > now.get(Calendar.MONTH))
            || (dob.get(Calendar.MONTH) == now.get(Calendar.MONTH)
            && dob.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH)))
        {
            res--;
        }
        return res;
    }

    /**
     * This is an abstract method signiture for getting the ID of a Person
     *
     * @return The ID of the person
     * @since 0.0.1
     */
    public abstract int getID();

    /**
     * Checks the nullity and length of the title
     *
     * @param title The title of the person
     * @since 0.0.1
     */
    private static void checkTitle(final String title) {
        if(title == null) throw new IllegalArgumentException("The title of " +
                "the person must not be null.");
        if(title.trim().length() == 0 || title.trim().length() > 5)
            throw new IllegalArgumentException("The title of the person must " +
                    "not be blank and must not exceed 5 characters.");
    }

    /**
     * Checks the nullity and length of the forenames
     *
     * @param forenames The forenames of the person
     * @since 0.0.1
     */
    private static void checkForenames(final String forenames) {
        if(forenames == null) throw new IllegalArgumentException("The " +
                "forenames of the person must not be null.");
        if(forenames.trim().length() < 2 || forenames.trim().length() > 30)
            throw new IllegalArgumentException("The forenames of the person " +
                    "must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");
    }

    /**
     * Checks the nullity and length of the surname
     *
     * @param surname The surname of the person
     * @since 0.0.1
     */
    private static void checkSurname(final String surname) {
        if(surname == null) throw new IllegalArgumentException("The surname " +
                "of the person must not be null.");
        if(surname.trim().length() < 2 || surname.trim().length() > 30)
            throw new IllegalArgumentException("The surname of the person " +
                    "must not be shorted than 2 characters and must not " +
                    "exceed 30 characters.");
    }

    /**
     * Checks the date of birth of the person is sane
     *
     * @param dateOfBirth The date of birth of the person, in GregorianCalendar
     * format
     * @since 0.0.1
     */
    private static void checkDateOfBirth(final GregorianCalendar dateOfBirth) {
        if(dateOfBirth == null) throw new IllegalArgumentException("The " +
                "date of birth of the person must not be null.");
        final int tempAge = getYearsSinceBirth(dateOfBirth);
        if(tempAge > MAXAGE || tempAge < MINAGE)
            throw new IllegalArgumentException("The age of the person must " +
                    "be in the range of 18 to 80.");
    }

    /**
     * Checks the nullity and length of the house name
     *
     * @param houseName The house name or number of where the person lives
     * @since 0.0.1
     */
    private static void checkHouseName(final String houseName) {
        if(houseName == null) throw new IllegalArgumentException("The house " +
                "name must not be null.");
        if(houseName.trim().length() < 1 || houseName.trim().length() > 30)
            throw new IllegalArgumentException("The length of the house name " +
                    "must not be shorter than 1 character and must not exceed" +
                    " 30 characters.");
    }

    /**
     * Checks the nullity and length of the street name
     *
     * @param streetName The name of the street where the person lives
     * @since 0.0.1
     */
    protected static void checkStreetName(final String streetName) {
        if(streetName == null) throw new IllegalArgumentException("The street" +
                " name must nbot be null.");
        if(streetName.trim().length() < 2 || streetName.trim().length() > 30)
            throw new IllegalArgumentException("The length of the street name" +
                    " must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");
    }

    /**
     * Checks the nullity and length of the town
     *
     * @param town The name of the town where the person lives
     * @since 0.0.1
     */
    protected static void checkTown(final String town) {
        if(town == null) throw new IllegalArgumentException("The town must " +
                "not be null.");
        if(town.trim().length() < 2 || town.trim().length() > 30)
            throw new IllegalArgumentException("The length of the town name " +
                    "must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");
    }

    /**
     * Checks the nullity and length of the country
     *
     * @param country The name of the country where the person lives
     * @since 0.0.1
     */
    protected static void checkCountry(final String country) {
        if(country == null) throw new IllegalArgumentException("The country " +
                "must not be null.");
        if(country.trim().length() < 2 || country.trim().length() > 30)
            throw new IllegalArgumentException("The length of the country " +
                    "name must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");
    }

    /**
     * Checks the nullity and length of the post code
     *
     * @param postCode The post code of where the person lives
     * @since 0.0.1
     */
    protected static void checkPostCode(final String postCode) {
        if(postCode == null) throw new IllegalArgumentException("The post " +
                "code must not be null.");
        if(postCode.trim().length() < 2 || postCode.trim().length() > 30)
            throw new IllegalArgumentException("The length of the post code " +
                    "must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");
    }

    /**
     * Checks the nullity and length of the telephone number
     *
     * @param telephone The telephone number of the person
     * @since 0.0.1
     */
    protected static void checkTelephone(final String telephone) {
        if(telephone == null) throw new IllegalArgumentException("The " +
                "telephone number must not be null.");
        if(telephone.trim().length() < 5 || telephone.trim().length() > 15)
            throw new IllegalArgumentException("The length of the telephone " +
                    "number must not be shorter than 5 characters and must " +
                    "not exceed 15 characters.");
    }

    /**
     * Checks the nullity and length of the telephone number
     *
     * @param faxNumber The fax number of the person
     * @since 0.0.1
     */
    protected static void checkFaxNumber(final String faxNumber) {
        if(faxNumber.trim().length() > 15)
            throw new IllegalArgumentException("The length of the fax number " +
                    "must not exceed 15 characters.");
    }

    /**
     * Checks the nullity and length of the email address
     *
     * @param email The email address of the person
     * @since 0.0.1
     */
    protected static void checkEmail(final String email) {
        if(email.trim().indexOf("@") == -1)
            throw new IllegalArgumentException("All email addresses should " +
                    "include the at (@) symbol.");
    }
}