package uk.co.exahertz.friendlysociety.core;

import uk.co.exahertz.friendlysociety.database.*;
import java.util.Collection;

/**
 * The Core class is the central hub of the application, bringing together all 
 * elements of the core and interfacing with the database management classes 
 * which implement MortgageDatabase
 * 
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 */
public class Core {
    private MortgageDatabase dataSource;
    private StaffMember loggedInAs;

    /**
     * Create a new instance of the Core class, providing the data source 
     * as the argument
     * 
     * @param dataSource The data source where the core will retrieve data from
     * @since 0.0.1
     */
    public Core(final MortgageDatabase dataSource) {
        if(dataSource == null) throw new IllegalArgumentException("The data " +
                "source must not be null.");
        this.dataSource = dataSource;
    }

    
    
    /**
     * Reset the core back to its inital state
     */
    public void reset() {
        loggedInAs = null;
    }

    /**
     * Log in a member of staff to use the system
     *
     * @param username The username of the member of staff
     * @param password The password of the member of staff
     * @return True if person is now logged in, false if not
     */
    public boolean logIn(final String username, final String password) {
        StaffMember staff = dataSource.getStaffMemberByUsername(username);
        if(staff == null) return false;
        if(staff.isPasswordCorrect(password) && staff.getIsStillWithCompany()) {
            loggedInAs = staff;
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Add a new address to the database
     * 
     * @param address The address to be added to the database
     * @return The ID of the address
     * @since 0.0.1
     */
    public int addAddress(final Address address) {
        if(address == null) throw new IllegalArgumentException("The address " +
                "instance must not be null.");
        return dataSource.addAddress(address);
    }
    
    /**
     * Add a new credit check to the database
     * 
     * @param creditCheck The credit check to be added to the database
     * @param customerID The customer ID for this credit check
     * @return The id of the credit check
     * @since 0.0.1
     */
    public int addCreditCheck(final CreditCheck creditCheck, int customerID) {
        if(creditCheck == null) throw new IllegalArgumentException("The " +
                "credit check instance must not be null.");
        return dataSource.addCreditCheck(creditCheck, customerID);
    }
    
    /**
     * Add a new customer to the database
     * 
     * @param customer The customer to be added to the database
     * @return The unique customer ID
     * @since 0.0.1
     */
    public int addCustomer(final Customer customer) {
        if(customer == null) throw new IllegalArgumentException("The " +
                "customer instance must not be null.");
        return dataSource.addCustomer(customer);
    }
    
    /**
     * Add new employment details for a customer
     * 
     * @param employment The employment instance for this customer
     * @param customerID The ID of the customer the employment is for
     * @return The ID of the employment
     * @since 0.0.1
     */
    public int addEmployment(final Employment employment, final int customerID)
    {
        if (employment == null) throw new IllegalArgumentException("The " +
                    "employment instance must not be null.");
        return dataSource.addEmployment(employment, customerID);
    }
    
    /**
     * Add a new mortgage payment for a mortgage
     * 
     * @param payment The mortgage payment instance
     * @param mortgageID The unique ID of the payment
     * @return The ID of the mortgage payment
     */
    public int addMortgagePayment(final MortgagePaymentDetails payment,
            final int mortgageID)
    {
        if(payment == null) throw new IllegalArgumentException("The mortgage " +
                "payment instance must not be null.");
        return dataSource.addMortgagePayment(payment, mortgageID);
    }

    /**
     * Add a new property to the database
     *
     * @param property The property to be added
     * @return The ID of the property
     * @since 0.0.1
     */
    public int addProperty(final Property property) {
        if(property == null) throw new IllegalArgumentException("The " +
                "property instance must not be null.");
        return dataSource.addProperty(property);
    }
    
    /**
     * Add a new member of staff to the database
     * 
     * @param staff The member of staff to be added to the database
     * @return The ID of the member of staff
     * @since 0.0.1
     */
    public int addStaffMember(final StaffMember staff) {
        if(staff == null) throw new IllegalArgumentException("The staff " +
                "member instance must not be null.");
        return dataSource.addStaffMember(staff);
    }

    /**
     * Add a new survey to the database
     *
     * @param survey The survey to be added to the database
     * @param propertyID The ID of the property that this survey is for
     * @return The ID of this survey
     * @since 0.0.1
     */
    public int addSurvey(final Survey survey, final int propertyID) {
        if(survey == null) throw new IllegalArgumentException("The survey " +
                "instance must not be null");
        return dataSource.addSurvey(survey, propertyID);
    }
    
    /**
     * Add a new surveyor to the database
     * 
     * @param surveyor The new surveyor to be added to the database
     * @return The id for the new surveyor
     * @since 0.0.1
     */
    public int addSurveyor(final Surveyor surveyor) {
        if(surveyor == null) throw new IllegalArgumentException("The " +
                "surveyor instance must not be null.");
        return dataSource.addSurveyor(surveyor);
    }
    
    /**
     * Change a staff member's password in the database
     * 
     * @param staffMember The staff member who is to have their password changed
     * @return True if successful, false if the operation failed
     * @since 0.0.1
     */
    public boolean changeStaffMemberPassword(final StaffMember staffMember) {
        if(staffMember == null) throw new IllegalArgumentException("The " +
                "staff member instance must not be null.");
        return dataSource.changeStaffMemberPassword(staffMember);
    }

    /**
     * Get the StaffMember object of who is logged in to the application
     *
     * @return The StaffMember object of who is logged in to the application,
     * null if nobody is logged in
     * @since 0.0.1
     */
    public StaffMember getLoggedInAs() {
        return loggedInAs;
    }
    
    /**
     * Get the customer by the customer ID
     * 
     * @param customerID The customer ID to look for
     * @return An instance of Customer which has the unique ID given
     */
    public Customer getCustomerByID(final int customerID) {
        return dataSource.getCustomerByID(customerID);
    }
    
   
   /**
    * Get customers by address ID
    * @param addressIDSearched
    * @return a collection of customers who lives at this address
    */
   public Collection<Customer> getCustomersByAddressID
            (final String addressIDSearched){
       return dataSource.getCustomersByAddressID(addressIDSearched);
   }
   
   
   /**
    * Search customers by address
    * @param country
    * @param town
    * @param postCode
    * @param streetName
    * @param propertyName
    * @return a collection of customers whose address matches
    */
   public Collection<Customer> getCustomersByAddress(final String country,
            final String town, final String postCode, final String streetName,
            final String propertyName){
       return dataSource.getCustomersByAddress(country, town, postCode, streetName, propertyName);
   }
   
   /**
    * Search customers by name
    * @param surnameSearched
    * @param forenamesSearched
    * @return a collection of customers
    */
   public Collection<Customer> getCustomersByName(final String surnameSearched,
            final String forenamesSearched){
       return dataSource.getCustomersByName(surnameSearched, forenamesSearched);
   }
   
   /**
    * Search staff members by address
    * @param country
    * @param town
    * @param postcode
    * @param streetName
    * @param propertyName
    * @return a collection of staff members
    */
   public Collection<StaffMember> getStaffMembersByAddress(String country, String town, String postcode, String streetName, String propertyName) {
        return dataSource.getStaffMembersByAddress(country, town, postcode, streetName, propertyName);
    }

   /**
    * Search staff members by name
    * @param surname
    * @param forenames
    * @return a collection of staff members
    */
    public Collection<StaffMember> getStaffMembersByName(String surname, String forenames) {
        return dataSource.getStaffMembersByName(surname, forenames);
    }
    
    public StaffMember getStaffMemberByUsername(final String username) {
        return dataSource.getStaffMemberByUsername(username);
    }
    
    /**
     * Modify an address in the database
     * 
     * @param address The address object to write to the database
     * @return True if the operation was successful, false if not
     * @since 0.0.1
     */
    public boolean modifyAddress(final Address address) {
        if(address == null) throw new IllegalArgumentException("The address " +
                "instance must not be null.");
        return dataSource.modifyAddress(address);
    }
    
    /**
     * Modify a customer in the database
     * 
     * @param customer The customer object to write to the database
     * @return True if the operation was successful, false if not
     * @since 0.0.1
     */
    public boolean modifyCustomer(final Customer customer) {
        if (customer == null) throw new IllegalArgumentException("The customer" +
                    "instance must not be null.");
        return dataSource.modifyCustomer(customer);
    }
    
    /**
     * Modify a staff member in the database
     * 
     * @param staff The member of staff to modify
     * @return True if the operation was successful, false if not
     */
    public boolean modifyStaffMember(final StaffMember staff) {
        if(staff == null) throw new IllegalArgumentException("The staff " +
                "member instance must not be null.");
        return dataSource.modifyStaffMember(staff);
    }
    
    public Collection<Surveyor> getSurveyorsByName(final String name){
        return dataSource.getSurveyorsByName(name);
    }
    
    public Surveyor getSurveyorByID(final int id){
        return dataSource.getSurveyorByID(id);
    }
}
