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
    
   public Collection<Customer> getCustomersBySurname
        (final String surnameSearched)
   {
       return dataSource.getCustomersBySurname(surnameSearched);
   }
   
   public Collection<Customer> getCustomersByAddressID
            (final String addressIDSearched){
       return dataSource.getCustomersByAddressID(addressIDSearched);
   }
   
   public Collection<Customer> getCustomersByForenames
            (final String forenamesSearched){
       return dataSource.getCustomersByForenames(forenamesSearched);
   }
}