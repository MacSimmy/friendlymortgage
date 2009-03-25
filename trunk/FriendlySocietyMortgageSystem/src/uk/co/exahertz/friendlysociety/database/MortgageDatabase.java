package uk.co.exahertz.friendlysociety.database;

import java.util.Collection;
import uk.co.exahertz.friendlysociety.core.*;

public interface MortgageDatabase {
    public int addAddress(final Address address);
    public int addCreditCheck(final CreditCheck creditCheck,
            final int customerID);
    public int addCustomer(final Customer customer);
    public int addEmployment(final Employment employment,
            final int customerID);
    public int addProperty(final Property property);
    public int addStaffMember(final StaffMember staff);
    public int addSurvey(final Survey survey, final int propertyID);
    public int addSurveyor(final Surveyor surveyor);
    public int addMortgage(final Mortgage mortgage);
    public Customer getCustomerByID(final int customerID);
    
    public StaffMember getStaffMemberByUsername(final String uname);
    public Collection<Customer> getCustomersByAddressID
            (final String addressIDSearched);
   
    public Collection<Customer> getCustomersByAddress(final String country,
            final String town, final String postCode, final String streetName,
            final String propertyName);
    public Collection<Customer> getCustomersByName(final String surnameSearched,
            final String forenamesSearched);
    
    public Collection<StaffMember> getStaffMembersByName(final String surnameSearched,
            final String forenamesSearched);
    public Collection<StaffMember> getStaffMembersByAddress(final String country,
            final String town, final String postCode, final String streetName,
            final String propertyName);
}