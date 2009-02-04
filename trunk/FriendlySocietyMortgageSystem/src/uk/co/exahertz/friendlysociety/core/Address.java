package uk.co.exahertz.friendlysociety.core;

/**
 * Contain informations concerning one particular adresss
 * @see Person
 * @see Property
 * @author Guillaume Pasquet
 */
public class Address {

    
    private String houseName;
    private String streetName;
    private String town;
    private String country;
    private String postCode;

    /**
     * 
     * @param houseName The house name of where the customer lives
     * @param streetName The street name of where the customer lives
     * @param town The town where the customer lives
     * @param country The country where the customer lives
     * @param postCode The post code of where the customer lives
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public Address(String houseName, String streetName,
            String town, String country, String postCode) {
        
        
        checkCountry(country);
        checkHouseName(houseName);
        checkPostCode(postCode);
        checkStreetName(streetName);
        checkTown(town);
        
        this.houseName = houseName;
        this.streetName = streetName;
        this.town = town;
        this.country = country;
        this.postCode = postCode;
    }

    /**
     * 
     * @return The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @return The house name
     */
    public String getHouseName() {
        return houseName;
    }

    /**
     * 
     * @return The postcode
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 
     * @return The street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * 
     * @return The town
     */
    public String getTown() {
        return town;
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
    
    
}
