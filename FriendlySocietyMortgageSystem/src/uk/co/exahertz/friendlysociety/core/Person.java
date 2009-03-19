package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;
import java.util.Calendar;

/**
 * The Person abstract class contains all of the properties which are common to
 * both a Customer and a member of Staff.
 *
 * @author Niall Scott
 * @version 0.0.2
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
    private Address address;
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
     * @param address An Address object containing the address details of this
     * person
     * @param telephone The contact telephone number of the person
     * @param faxNumber The fax number of the person, if it exists
     * @param email The email address of the person, if it exists
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public Person(final String title, final String forenames,
            final String surname, final GregorianCalendar dateOfBirth,
            final boolean isFemale, final Address address, 
            final String telephone, final String faxNumber, final String email)
            throws IllegalArgumentException
    {
        checkTitle(title);
        checkForenames(forenames);
        checkSurname(surname);
        checkDateOfBirth(dateOfBirth);
        checkAddress(address);
        checkTelephone(telephone);
        checkFaxNumber(faxNumber);
        checkEmail(email);

        this.title = title.trim();
        this.forenames = forenames.trim();
        this.surname = surname.trim();
        this.dateOfBirth = dateOfBirth;
        this.isFemale = isFemale;
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
     * Get the address object for this person
     *
     * @return The address object for this person
     */
    public Address getAddressObject() {
        return address;
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
     * Set a new address object for this person
     *
     * @param address The new address object for this person
     * @since 0.0.1
     * @throws java.lang.IllegalArgumentException When an null address is
     * supplied
     */
    public void setAddressObject(final Address address)
            throws IllegalArgumentException
    {
        checkAddress(address);
        this.address = address;
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
     * Check that the address supplied is not null
     *
     * @param address The address to be checked
     * @since 0.0.1
     */
    private static void checkAddress(Address address) {
        if(address == null) throw new IllegalArgumentException("The address " +
                "should not be null.");
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
        if(faxNumber == null) return;
        if(faxNumber.equals("")) return;
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
        if(email == null) return;
        if(email.equals("")) return;

        if(email.trim().indexOf("@") == -1)
            throw new IllegalArgumentException("All email addresses should " +
                    "include the at (@) symbol.");
    }
}