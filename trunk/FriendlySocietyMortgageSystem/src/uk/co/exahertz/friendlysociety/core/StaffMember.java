package uk.co.exahertz.friendlysociety.core;

import java.util.GregorianCalendar;

/**
 * The StaffMember class contains all of the properties which belong to one
 * member of staff. It is extended from the Person class. Each member of staff
 * can either be a manager or not be a manager. Each member of staff also has an
 * username and password to access the system. A member of staff has an ID which
 * allows them to be easily addressed internally in this program as well as the
 * database.
 *
 * @author Niall Scott
 * @version 0.0.2
 * @since 0.0.1
 * @see Person
 */
public class StaffMember extends Person {
    private int staffID;
    private boolean isManager;
    private String username;
    private String password;
    private boolean stillWithCompany;

    /**
     * Initiate a new instance of a member of staff.
     *
     * @param staffID The unique ID for this member of staff
     * @param title The title of the member of staff
     * @param forenames The forenames of the member of staff
     * @param surname The surname of the member of staff
     * @param dateOfBirth The dateOfBirth of the member of staff, in
     * GregorianCalendar format
     * @param isFemale The gender of the member of staff
     * @param address The address details of this person
     * @param telephone The telephone number of this member of staff
     * @param faxNumber The fax number of this member of staff
     * @param email The email address of this member of staff
     * @param isManager The manager status of this member of staff
     * @param username The username for this member of staff
     * @param password The password for this member of staff. Should be
     * supplied as an encrypted string
     * @param stillWithCompany Is the employee still with the company?
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public StaffMember(final int staffID, final String title,
            final String forenames, final String surname,
            final GregorianCalendar dateOfBirth, final boolean isFemale,
            final Address address, final String telephone,
            final String faxNumber, final String email, final boolean isManager,
            final String username, final String password,
            final boolean stillWithCompany)
            throws IllegalArgumentException
    {
        // Call the constructor in the super class.
        super(title, forenames, surname, dateOfBirth, isFemale, address,
                telephone, faxNumber, email);

        checkStaffID(staffID);
        checkUsername(username);
        checkPassword(password);

        this.staffID = staffID;
        this.isManager = isManager;
        this.username = username.trim();
        this.password = password.trim();
        this.stillWithCompany = stillWithCompany;
    }

    /**
     * Get the ID for the member of staff
     *
     * @return The ID for the member of staff
     * @since 0.0.1
     */
    @Override
    public int getID() {
        return staffID;
    }

    /**
     * Get the manager status of this member of staff
     *
     * @return The manager status of this member of staff
     * @since 0.0.1
     */
    public boolean getIsManager() {
        return isManager;
    }

    /**
     * Get the username of this member of staff
     *
     * @return The username of this member of staff
     * @since 0.0.1
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the encrypted version of the member of staff's password
     *
     * @return An encrypted version of the password belonging to this member
     * of staff
     * @since 0.0.1
     */
    public String getEncryptedPassword() {
        return password;
    }

    /**
     * Get the employee's status of still being with the Friendly Society
     *
     * @return The employee's employment status
     * @since 0.0.1
     */
    public boolean getIsStillWithCompany() {
        return stillWithCompany;
    }

    /**
     * Set the manager status for this member of staff
     *
     * @param isManager The new manager status for this member of staff
     * @since 0.0.1
     */
    public void setIsManager(final boolean isManager) {
        this.isManager = isManager;
    }

    /**
     * Set the username for this member of staff
     *
     * @param username The new username for this member of staff
     * @throws java.lang.IllegalArgumentException When an illegal username
     * is supplied
     * @since 0.0.1
     */
    public void setUsername(final String username)
            throws IllegalArgumentException
    {
        checkUsername(username);
        this.username = username.trim();
    }

    /**
     * Set the password for this member of staff
     *
     * @param password A new password for this member of staff. The password
     * should be provided as a pre-encrypted String
     * @throws java.lang.IllegalArgumentException When an illegal password is
     * supplied
     * @since 0.0.1
     */
    public void setPassword(final String password)
            throws IllegalArgumentException
    {
        checkPassword(password);
        this.password = password.trim();
    }

    /**
     * Set the employee's employment status
     *
     * @param stillWithCompany The employee's employment status
     * @since 0.0.1
     */
    public void setStillWithCompany(final boolean stillWithCompany) {
        this.stillWithCompany = stillWithCompany;
    }

    /**
     * Checks to see if the password supplied is exactly equal to the password
     * held in the instance of this class, mainly used for logging in
     *
     * @param password The password to be checked for correctness
     * @return True if the password is correct, else return false
     * @throws java.lang.IllegalArgumentException When an illegal password is
     * supplied to be compared with
     */
    public boolean isPasswordCorrect(final String password)
            throws IllegalArgumentException
    {
        checkPassword(password);
        if(this.password.equals(password.trim())) return true;
        return false;
    }

    /**
     * Checks to make sure the staffID is not less than 0
     *
     * @param staffID The staff ID to be checked
     * @since 0.0.1
     */
    private static void checkStaffID(final int staffID) {
        if(staffID < 0) throw new IllegalArgumentException("The staffID must " +
                "not be less than 0.");
    }

    /**
     * Checks to ensure the username is not null and is of sane length, which is
     * between 3 and 15 characters
     *
     * @param username The username to be checked
     * @since 0.0.1
     */
    private static void checkUsername(final String username) {
        if(username == null) throw new IllegalArgumentException("The " +
                "username must not be null.");
        if(username.trim().length() < 3 || username.trim().length() > 15)
            throw new IllegalArgumentException("The length of the username " +
                    "must not be less than 3 characters and must not exceed " +
                    "15 characters.");
    }

    /**
     * Checks to ensure the password is not null and is not blank. This method
     * assumes it is given a pre-encrypted password hence why no more checking
     * is done here
     *
     * @param password A pre-encrypted password to be checked
     * @since 0.0.1
     */
    private static void checkPassword(final String password) {
        if(password == null) throw new IllegalArgumentException("The " +
                "password must not be null.");
        if(password.trim().length() == 0)
            throw new IllegalArgumentException("The password must not be " +
                    "blank.");
    }
}