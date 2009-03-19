package uk.co.exahertz.friendlysociety.database;

import java.util.Collection;
import java.util.HashMap;
import uk.co.exahertz.friendlysociety.core.*;

public interface MortgageDatabase {
    public void getAllAddresses(final Collection<Address> addresses);
    public void getAllCreditChecks(final Collection<CreditCheck> creditChecks);
    public void getAllCustomers(final Collection<Customer> customers,
            final HashMap<Integer, Address> addresses);
    public void getAllSurveyors(final Collection<Surveyor> surveyors,
            final HashMap<Integer, Address> addresses);
    public Customer getCustomerByID(final int customerID);
    public Collection<Customer> getCustomersBySurname
        (final String surnameSearched);
    public StaffMember getStaffMemberByUsername(final String uname);
    public Collection<Customer> getCustomersByAddressID
            (final String addressIDSearched);
    public Collection<Customer> getCustomersByForenames
            (final String forenamesSearched);
    public Collection<Customer> getCustomersByAddress(final String country,
            final String town, final String postCode, final String streetName,
            final String propertyName);
    
}