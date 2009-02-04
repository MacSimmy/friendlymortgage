package uk.co.exahertz.friendlysociety.core;

/**
 * Contain all the details concerning a property (e.g address, value etc...)
 * 
 * @author Guillaume Pasquet
 * @see Survey
 * @since 0.0.1
 */
public class Property {

    
    private int propertyID;
    private Address address;
    private int type;//flat? house?
    private int numberOfBedrooms;
    private float value;

    /**
     * 
     * @param propertyID The ID of the proprty
     * @param address The address of the property
     * @param type The type of the property
     * @param numberOfBedrooms The number of bedrooms in the property
     * @param value The value of the property
     */
    public Property(int propertyID, Address address, int type,
            int numberOfBedrooms, float value) {
        
        //check ID:
        if (propertyID < 0) throw new IllegalArgumentException("The property " +
                "ID must be positive");
        
        //check adress:
        if ( address == null) throw  new IllegalArgumentException("An" +
                " adress (uk.co.exahertz.friendlysociety.core.Adress) must" +
                "be provided.");
        
        //check type
        //for now, just check if not negative
        // TODO: create default values or new class PropertyType
        if ( type < 0 ) throw new IllegalArgumentException(" the type can not" +
                " be negative");
        
        // check numberOfBedroom
        if ( numberOfBedrooms < 0) throw new IllegalArgumentException(" The" +
                " number of bedrooms must be positive");
        
        //check value
        if ( value < 0) throw new IllegalArgumentException(" The value of" +
                " the property must be positive");
        
        this.propertyID = propertyID;
        this.address = address;
        this.type = type;
        this.numberOfBedrooms = numberOfBedrooms;
        this.value = value;
    }

    /**
     * 
     * @return The address of the Property.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 
     * @return The number of bedrooms in the property
     */
    public int getNumberOfBedrooms() {
        return numberOfBedrooms;
    }

    /**
     * 
     * @return The ID of the property
     */
    public int getPropertyID() {
        return propertyID;
    }

    /**
     * 
     * @return The type of the property
     */
    public int getType() {
        return type;
    }

    /**
     * 
     * @return The value of the property
     */
    public float getValue() {
        return value;
    }

    /**
     * 
     * @param numberOfBedrooms The new number of bedrooms in the property
     */
    public void setNumberOfBedrooms(int numberOfBedrooms) {
        this.numberOfBedrooms = numberOfBedrooms;
    }

    /**
     * 
     * @param value The new value of the property
     */
    public void setValue(float value) {
        this.value = value;
    }
    
    
    
    
    
    
    
    
    
}
