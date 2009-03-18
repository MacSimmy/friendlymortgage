package uk.co.exahertz.friendlysociety.core;

/**
 * Contain information concerning one particular address
 *
 * @author Guillaume Pasquet
 * @version 0.0.2
 * @since 0.0.1
 */
public class Address {
    private int addressID;
    private String propertyName;
    private String streetName;
    private String town;
    private String country;
    private String postCode;

    /**
     * Create a new instance of address
     *
     * @param addressID The unique ID of the address
     * @param propertyName The property name of where the customer lives
     * @param streetName The street name of where the customer lives
     * @param town The town where the customer lives
     * @param country The country where the customer lives
     * @param postCode The post code of where the customer lives
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     */
    public Address(final int addressID, final String propertyName,
            final String streetName, final String town, final String country,
            final String postCode)
            throws IllegalArgumentException
    {
        checkAddressID(addressID);
        checkCountry(country);
        checkHouseName(propertyName);
        checkPostCode(postCode);
        checkStreetName(streetName);
        checkTown(town);

        this.addressID = addressID;
        this.propertyName = propertyName.trim();
        this.streetName = streetName.trim();
        this.town = town.trim();
        this.country = country.trim();
        this.postCode = postCode.trim();
    }

    /**
     * Get the unique ID of this address
     *
     * @return The unique ID of the address
     * @since 0.0.2
     */
    public int getAddressID() {
        return addressID;
    }

    /**
     * Get the name of the property of this address
     *
     * @return The name of the property for this address
     * @since 0.0.1
     */
    public String getPropertyName() {
        return propertyName;
    }

    /**
     * Get the street name of this address
     *
     * @return The street name of this address
     * @since 0.0.1
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Get the town name of this address
     *
     * @return The street name of this address
     * @since 0.0.1
     */
    public String getTown() {
        return town;
    }

    /**
     * Get the country name of this address
     *
     * @return The country The country name of this address
     * @since 0.0.1
     */
    public String getCountry() {
        return country;
    }

    /**
     * Get the post code of this address
     *
     * @return The post code of this address
     */
    public String getPostCode() {
        return postCode;
    }
    
    /**
     * Return a String representation of this object, in format<br>
     * propertyName, streetName, town, country, postCode
     * 
     * @return Return a String representation of this object
     */
    @Override
    public String toString() {
        return propertyName + ", " + streetName + ", " + town + ", " + country +
                ", " + postCode;
    }

    /**
     * Set the property name of this address
     *
     * @param propertyName The new name of the property for this address
     * @throws java.lang.IllegalArgumentException When an illegal house name
     * is supplied
     * @since 0.0.1
     */
    public void setPropertyName(final String propertyName)
            throws IllegalArgumentException
    {
        checkHouseName(propertyName);
        this.propertyName = propertyName.trim();
    }

    /**
     * Set the street name of this address
     *
     * @param streetName The new name of the street of this address
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
     * Set the town name of this address
     *
     * @param town The new town of this address
     * @throws java.lang.IllegalArgumentException When an illegal town name is
     * supplied
     * @since 0.0.1
     */
    public void setTown(final String town) throws IllegalArgumentException {
        checkTown(town);
        this.town = town.trim();
    }

    /**
     * Set the country name of this address
     *
     * @param country The new country of this address
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
     * Set the post code of this address
     *
     * @param postCode The new post code of this address
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
     * Check the addressID is 0 or greater
     *
     * @param addressID The address ID to be checked
     * @since 0.0.2
     */
    private static void checkAddressID(final int addressID) {
        if(addressID < 0) throw new IllegalArgumentException("The ID of the " +
                "address must be 0 or greater.");
    }
  
    /**
     * Checks the nullity and length of the house name
     *
     * @param propertyName The house name or number of where the person lives
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
    private static void checkStreetName(final String streetName) {
        if(streetName == null) throw new IllegalArgumentException("The street" +
                " name must not be null.");
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
    private static void checkTown(final String town) {
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
    private static void checkCountry(final String country) {
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
    private static void checkPostCode(final String postCode) {
        if(postCode == null) throw new IllegalArgumentException("The post " +
                "code must not be null.");
        if(postCode.trim().length() < 2 || postCode.trim().length() > 30)
            throw new IllegalArgumentException("The length of the post code " +
                    "must not be shorter than 2 characters and must not " +
                    "exceed 30 characters.");
    }   
}