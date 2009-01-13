package uk.co.exahertz.friendlysociety.core;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * The Person abstract class contains all of the properties which are common to
 * both a Customer and a member of Staff.
 *
 *
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 */
public abstract class Person {
    private String title;
    private String forenames;
    private String surname;
    private Calendar dateOfBirth;
    private boolean isFemale;
    private String houseName;
    private String streetName;
    private String town;
    private String country;
    private String postCode;
    private String telephone;
    private String faxNumber;
    private String email;

    public static final int MINAGE = 18;
    public static final int MAXAGE = 80;

    /**
     * 
     * @param title
     * @param forenames
     * @param surname
     * @param dateOfBirth
     * @param isFemale
     * @param houseName
     * @param streetName
     * @param town
     * @param country
     * @param postCode
     * @param telephone
     * @param faxNumber
     * @param email
     */
    public Person(String title, String forenames, String surname,
            Calendar dateOfBirth, boolean isFemale, String houseName,
            String streetName, String town, String country, String postCode,
            String telephone, String faxNumber, String email)
    {
        if(title == null) throw new IllegalArgumentException("The title of " +
                "the person must not be null.");
        if(title.trim().length() == 0 || title.trim().length() > 5)
            throw new IllegalArgumentException("The title of the person must " +
                    "not be blank and must not exceed 5 characters.");

        if(forenames == null) throw new IllegalArgumentException("The " +
                "forenames of the person must not be null.");
        if(forenames.trim().length() < 2 || forenames.trim().length() > 30)
            throw new IllegalArgumentException("The forenames of the person " +
                    "must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");

        if(surname == null) throw new IllegalArgumentException("The surname " +
                "of the person must not be null.");
        if(surname.trim().length() < 2 || surname.trim().length() > 30)
            throw new IllegalArgumentException("The surname of the person " +
                    "must not be shorted than 2 characters and must not " +
                    "exceed 30 characters.");

        if(dateOfBirth == null) throw new IllegalArgumentException("The " +
                "date of birth of the person must not be null.");
        int tempAge = getAge(dateOfBirth);
        if(tempAge > MAXAGE || tempAge < MINAGE)
            throw new IllegalArgumentException("The age of the person must " +
                    "be in the range of 18 to 80.");

        if(streetName == null) throw new IllegalArgumentException("The street" +
                " name must nbot be null.");
        if(streetName.trim().length() < 2 || streetName.trim().length() > 30)
            throw new IllegalArgumentException("The length of the street name" +
                    " must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");

        if(town == null) throw new IllegalArgumentException("The town must " +
                "not be null.");
        if(town.trim().length() < 2 || town.trim().length() > 30)
            throw new IllegalArgumentException("The length of the town name " +
                    "must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");

        if(country == null) throw new IllegalArgumentException("The country " +
                "must not be null.");
        if(country.trim().length() < 2 || country.trim().length() > 30)
            throw new IllegalArgumentException("The length of the country " +
                    "name must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");
        
        if(postCode == null) throw new IllegalArgumentException("The post " +
                "code must not be null.");
        if(postCode.trim().length() < 2 || postCode.trim().length() > 30)
            throw new IllegalArgumentException("The length of the post code " +
                    "must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");
    }

    /**
     * This function calculates the age of a person. This function was taken
     * from <a href="http://www.rgagnon.com/javadetails/java-0547.html">
     * http://www.rgagnon.com/javadetails/java-0547.html</a>
     *
     * @param dob The instance of Calendar containing the date of birth
     * @return The length of time, in years, since the person was born
     */
    public static int getAge(Calendar dob) {
        Calendar now = new GregorianCalendar();
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
     */
    public abstract int getID();
}