package uk.co.exahertz.friendlysociety.core;

import java.util.ArrayList;

/**
 * Contain all the details of a particular property (e.g address, value etc...)
 * 
 * @author Guillaume Pasquet
 * @version 0.0.1
 * @since 0.0.1
 * @see PropertyType
 */
public class Property {
    private int propertyID;
    private Address address;
    private PropertyType type;
    private int numberOfBedrooms;
    private ArrayList<Survey> surveys;

    /**
     * Create a new instance of a property
     *
     * @param propertyID The unique ID of the property
     * @param address The address of the property
     * @param type The type of the property
     * @param numberOfBedrooms The number of bedrooms the property has
     * @throws java.lang.IllegalArgumentException When an illegal argument is
     * supplied
     * @since 0.0.1
     * @see PropertyType
     */
    public Property(int propertyID, Address address, PropertyType type,
            int numberOfBedrooms) throws IllegalArgumentException
    {
        checkPropertyID(propertyID);
        checkAddress(address);
        checkNumberOfBedrooms(numberOfBedrooms);

        this.propertyID = propertyID;
        this.address = address;
        this.type = type;
        this.numberOfBedrooms = numberOfBedrooms;
        surveys = new ArrayList<Survey>();
    }

    /**
     * Get the unique ID of the property
     * 
     * @return The unique ID of the property
     * @since 0.0.1
     */
    public int getPropertyID() {
        return propertyID;
    }

    /**
     * Get the address of the property
     *
     * @return The address of the property
     * @since 0.0.1
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Get a clone of the list of property surveys
     *
     * @return A clone of the property surveys list
     * @since 0.0.1
     */
    public ArrayList<Survey> getPropertySurveys() {
        return (ArrayList<Survey>)surveys.clone();
    }

    /**
     * Get the number of bedrooms in the property
     *
     * @return The number of bedrooms in the property
     * @since 0.0.1
     */
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * Get the property type
     *
     * @return The type of the property
     * @since 0.0.1
     */
    public PropertyType getType() {
        return type;
    }

    /**
     * Set the number of bedrooms contained in the property
     *
     * @param numberOfBedrooms The new number of bedrooms in the property
     * @throws java.lang.IllegalArgumentException When an invalid number of
     * bedrooms is supplied
     * @since 0.0.1
     */
    public void setNumberOfBedrooms(final int numberOfBedrooms)
            throws IllegalArgumentException
    {
        checkNumberOfBedrooms(numberOfBedrooms);
        this.numberOfBedrooms = numberOfBedrooms;
    }

    /**
     * Add a new survey for this property
     *
     * @param survey The survey to be added
     * @throws java.lang.IllegalArgumentException When a null survey is supplied
     * @since 0.0.1
     */
    public void addSurvey(final Survey survey) throws IllegalArgumentException {
        checkSurvey(survey);
        surveys.add(survey);
    }

    /**
     * Check the property ID is not less than 0
     *
     * @param propertyID The property ID to be checked
     * @since 0.0.1
     */
    private static void checkPropertyID(final int propertyID) {
        if(propertyID <0) throw new IllegalArgumentException("The property " +
                "ID must be 0 or greater.");
    }

    /**
     * Check the address is not null
     *
     * @param address The address to be checked
     * @since 0.0.1
     */
    private static void checkAddress(final Address address) {
        if(address == null) throw new IllegalArgumentException("The address " +
                "must not be null.");
    }

    /**
     * Check the number of bedrooms is 1 or greater
     *
     * @param numberOfBedrooms The number of bedrooms to be checked
     * @since 0.0.1
     */
    private static void checkNumberOfBedrooms(final int numberOfBedrooms) {
        if(numberOfBedrooms < 1) throw new IllegalArgumentException("The " +
                "number of bedrooms must not be less than 1.");
    }

    /**
     * Check the survey is not null
     *
     * @param survey The survey to be checked
     * @since 0.0.1
     */
    private static void checkSurvey(final Survey survey) {
        if(survey == null) throw new IllegalArgumentException("The survey " +
                "must not be null.");
    }
}
