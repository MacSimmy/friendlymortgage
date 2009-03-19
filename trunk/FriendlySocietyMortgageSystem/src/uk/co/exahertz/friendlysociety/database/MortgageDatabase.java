package uk.co.exahertz.friendlysociety.database;

import java.util.Collection;
import uk.co.exahertz.friendlysociety.core.*;

public interface MortgageDatabase {
    public void addAddress(final Address address);
    public boolean addStaffMember(final StaffMember staff);
    public int getAddressID(final Address address);
    public Customer getCustomerByID(final int customerID);
    
    public StaffMember getStaffMemberByUsername(final String uname);
    public Collection<Customer> getCustomersByAddressID
            (final String addressIDSearched);
   
    public Collection<Customer> getCustomersByAddress(final String country,
            final String town, final String postCode, final String streetName,
            final String propertyName);
    public Collection<Customer> getCustomersByName(final String surnameSearched,
            final String forenamesSearched);
}