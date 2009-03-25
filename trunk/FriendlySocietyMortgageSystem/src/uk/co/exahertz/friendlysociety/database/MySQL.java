package uk.co.exahertz.friendlysociety.database;

import java.sql.*;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import uk.co.exahertz.friendlysociety.core.*;

/**
 *
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 */
public class MySQL implements MortgageDatabase {

    private static final String ADDRESS = "mysql-server-1";
    private static final int PORT = 3306;
    private static final String DATABASE = "friendly_society";
    private static final String USERNAME = "friend";
    private static final String PASSWORD = "friend";
    private static final String ERRORFILE = "sql_errors";
    private Connection connection;

    /**
     * Create a new MySQL connection
     *
     * @throws java.sql.SQLException When a SQLException occurrs
     * @throws java.lang.ClassNotFoundException When the MySQL classes are not
     * found
     * @since 0.0.1
     */
    public MySQL() throws SQLException, ClassNotFoundException {
        connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://" + ADDRESS +
                ":" + PORT + "/" + DATABASE, USERNAME, PASSWORD);
    }

    /**
     * Close the connection to the database to release the database resources
     *
     * @since 0.0.1
     */
    public void close() {
        try {
            connection.close();
            connection = null;
        } catch (SQLException e) {
            // We're closing anyway, no need to do anything with the error
        }
    }

    @Override
    public int addAddress(final Address address) {
        if(address == null) throw new IllegalArgumentException("The address " +
                "instance must not be null.");
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Address (propertyName, " +
                    "streetName, town, country, postCode) VALUES ('" +
                    address.getPropertyName() + "', '" +
                    address.getStreetName() + "', '" + address.getTown() +
                    "', '" + address.getCountry() + "', '" +
                    address.getPostCode() + "')",
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(!keys.next()) return -1;
            int key = keys.getInt(1);
            statement.close();
            return key;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return -1;
        }
    }
    
    @Override
    public int addCreditCheck(final CreditCheck creditCheck,
            final int customerID)
    {
        if(creditCheck == null) throw new IllegalArgumentException("The " +
                "credit check instance must not be null.");
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO CreditCheck (" +
                    "creditCheckDate, creditCheckScore, " +
                    "creditCheckRiskStatus, customerID) VALUES ('" +
                    creditCheck.getCreditCheckDate().get(
                    GregorianCalendar.YEAR) + "-" +
                    creditCheck.getCreditCheckDate().get(
                    GregorianCalendar.MONTH) + "-" +
                    creditCheck.getCreditCheckDate().get(
                    GregorianCalendar.DAY_OF_MONTH) + "', " +
                    creditCheck.getCreditCheckScore() + ", '" +
                    creditCheck.getCreditCheckRiskStatus() + "', " +
                    customerID + ")", Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(!keys.next()) return -1;
            int key = keys.getInt(1);
            statement.close();
            return key;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return -1;
        }
    }
    
    @Override
    public int addCustomer(final Customer customer) {
        if(customer == null) throw new IllegalArgumentException("The customer" +
                "instance must not be null.");
        try {
            int addressID = addAddress(customer.getAddressObject());
            if(addressID < 0) return -1;
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Customer (title, forenames, surname, " +
                    "dateOfBirth, isFemale, addressID, telephone, faxNumber, " +
                    "email, nationalInsuranceNumber, savingsAccountNumber) " +
                    "VALUES ('" + customer.getTitle() + "', '" +
                    customer.getForenames() + "', '" + customer.getSurname() +
                    "', '" +
                    customer.getDateOfBirth().get(GregorianCalendar.YEAR) +
                    "-" +
                    customer.getDateOfBirth().get(GregorianCalendar.MONTH) +
                    "-" +
                    customer.getDateOfBirth().get(
                    GregorianCalendar.DAY_OF_MONTH) + "', ";
            if(customer.getIsFemale()) {
                query = query + "1";
            } else {
                query = query + "0";
            }
            query = query + ", " + addressID + ", '" +
                    customer.getTelephoneNumber() + "', '" +
                    customer.getFaxNumber() + "', '" +
                    customer.getEmailAddress() + "', '" +
                    customer.getNationalInsuranceNumber() + "', '" +
                    customer.getSavingsAccountNumber() + "')";
            statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(!keys.next()) return -1;
            int key = keys.getInt(1);
            statement.close();
            return key;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return -1;
        }
    }
    
    @Override
    public int addEmployment(final Employment employment,
            final int customerID)
    {
        if(employment == null) throw new IllegalArgumentException("The " +
                "employment instance must not be null.");
        try {
            int addressID = addAddress(employment.getEmployerAddressObject());
            if(addressID < 0) return -1;
            Statement statement = connection.createStatement();
            String query = "INSERT INTO Employment (employerName, " +
                    "employerAddress, employerTelephone, employerFax, " +
                    "dateStarted, dateEnded, hoursPerWeek, " +
                    "currentAnnualSalery, permenant, selfEmployed, customer) " +
                    "VALUES ('" + employment.getEmployerName() + "', " + 
                    addressID + ", '" + employment.getEmployerTelephone() +
                    "', '" + employment.getEmployerFax() + "', '" +
                    employment.getDateStarted().get(GregorianCalendar.YEAR) +
                    "-" +
                    employment.getDateStarted().get(GregorianCalendar.MONTH) +
                    "-" +
                    employment.getDateStarted().get(
                    GregorianCalendar.DAY_OF_MONTH) + "', ";
            if(employment.getDateEnded() == null) {
                query = query + "NULL";
            } else {
                query = query + "'" +
                        employment.getDateEnded().get(GregorianCalendar.YEAR) +
                        "-" +
                        employment.getDateEnded().get(GregorianCalendar.MONTH) +
                        "-" +
                        employment.getDateEnded().get(
                        GregorianCalendar.DAY_OF_MONTH) + "'";
            }
            query = query + ", " + employment.getHoursPerWeek() + ", " +
                    employment.getCurrentAnnualSalery() + ", ";
            if(employment.isEmploymentPermenant()) {
                query = query + "1";
            } else {
                query = query + "0";
            }
            query = query + ", ";
            if(employment.isSelfEmployed()) {
                query = query + "1";
            } else {
                query = query + "0";
            }
            query = query + ", " + customerID + ")";
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(!keys.next()) return -1;
            int key = keys.getInt(1);
            statement.close();
            return key;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return -1;
        }
    }
    
    @Override
    public int addMortgage(final Mortgage mortgage) {
        return 0;
    }

    public int addProperty(final Property property) {
        if(property == null) throw new IllegalArgumentException("The " +
                "property instance must not be null.");
        try {
            int addressID = addAddress(property.getAddress());
            if(addressID < 0) return -1;
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Property (addressID, " +
                    "propertyType, numberOfBedrooms) VALUES (" +
                    addressID + ", " + property.getType().ordinal() + ", " +
                    property.getNumberOfBedrooms() + ")",
                    Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(!keys.next()) return -1;
            int key = keys.getInt(1);
            statement.close();
            return key;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return -1;
        }
    }

    @Override
    public int addStaffMember(final StaffMember staff) {
        if(staff == null) throw new IllegalArgumentException("The staff " +
                "member instance must not be null.");
        try {
            int addressID = addAddress(staff.getAddressObject());
            if(addressID < 0) return -1;
            Statement statement = connection.createStatement();
            String query = "INSERT INTO StaffMember (title, forenames, " +
                    "surname, dateOfBirth, isFemale, addressID, telephone, " +
                    "faxNumber, email, isManager, username, password, " +
                    "stillWithCompany) VALUES ('" + staff.getTitle() + "', '" +
                    staff.getForenames() + "', '" + staff.getSurname() +"', '" +
                    staff.getDateOfBirth().get(GregorianCalendar.YEAR) + "-" +
                    staff.getDateOfBirth().get(GregorianCalendar.MONTH)+ "-" +
                    staff.getDateOfBirth().get(GregorianCalendar.DAY_OF_MONTH) +
                    "', ";
            if(staff.getIsFemale()) {
                query = query + "1";
            } else {
                query = query + "0";
            }
            query = query + ", " + addressID + ", '" +
                    staff.getTelephoneNumber() + "', ";
            if(staff.getFaxNumber() == null) {
                query = query + "NULL";
            } else {
                query = query + "'" + staff.getFaxNumber() + "'";
            }
            query = query + ", ";
            if(staff.getEmailAddress() == null) {
                query = query + "NULL";
            } else {
                query = query + "'" + staff.getEmailAddress() + "'";
            }
            query = query + ", ";
            if(staff.getIsManager()) {
                query = query + "1";
            } else {
                query = query + "0";
            }
            query = query + ", '" + staff.getUsername() + "', '" +
                    staff.getEncryptedPassword() + "', ";
            if(staff.getIsStillWithCompany()) {
                query = query + "1";
            } else {
                query = query + "0";
            }
            query = query + ")";
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(!keys.next()) return -1;
            int staffID = keys.getInt(1);
            statement.close();
            return staffID;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return -1;
        }
    }

    @Override
    public int addSurvey(final Survey survey, final int propertyID) {
        if(survey == null) throw new IllegalArgumentException("The survey " +
                "instance must not be null");
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Survey (surveyor, " +
                    "surveyDate, propertyValue, propertyID) VALUES (" +
                    survey.getSurveyor().getSurveyorID() + ", '" +
                    survey.getSurveyDate().get(GregorianCalendar.YEAR) + "-" +
                    survey.getSurveyDate().get(GregorianCalendar.MONTH) + "-" +
                    survey.getSurveyDate().get(GregorianCalendar.DAY_OF_MONTH) +
                    "', " + survey.getPropertyValue() + ", " + propertyID +
                    ")", Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(!keys.next()) return -1;
            int key = keys.getInt(1);
            statement.close();
            return key;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return -1;
        }
    }
    
    @Override
    public int addSurveyor(final Surveyor surveyor) {
        if(surveyor == null) throw new IllegalArgumentException("The " +
                "surveyor instance must not be null.");
        try {
            int addressID = addAddress(surveyor.getSurveyorAddressObject());
            if(addressID < 0) return -1;
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO Surveyors (surveyorName, " +
                    "addressID, telephone, faxNumber, email) VALUES ('" +
                    surveyor.getSurveyorName() + "', " + addressID + ", '" +
                    surveyor.getTelephoneNumber() + "', '" +
                    surveyor.getFaxNumber() + "', '" +
                    surveyor.getEmailAddress() + "')");
            ResultSet keys = statement.getGeneratedKeys();
            if(!keys.next()) return -1;
            int key = keys.getInt(1);
            statement.close();
            return key;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return -1;
        }
    }

    @Override
    public Customer getCustomerByID(final int customerID) {
        String title, forenames, surname, telephone, faxNumber, email,
                nationalInsuranceNumber, savingsAccountNumber, propertyName,
                streetName, town, country, postCode;
        int addressID;
        boolean isFemale;
        GregorianCalendar dateOfBirth;
        Customer customer;
        Address address;

        try {
            customer = null;
            Statement statementCustomer = connection.createStatement();
            ResultSet resultCustomer = statementCustomer.executeQuery(
                    "SELECT * FROM Customer WHERE customerID = " + customerID);
            if (resultCustomer.absolute(1)) {
                title = resultCustomer.getString("title");
                forenames = resultCustomer.getString("forenames");
                surname = resultCustomer.getString("surname");
                dateOfBirth = new GregorianCalendar();
                dateOfBirth.setTime(resultCustomer.getDate("dateOfBirth"));
                isFemale = resultCustomer.getBoolean("isFemale");
                addressID = resultCustomer.getInt("addressID");
                telephone = resultCustomer.getString("telephone");
                faxNumber = resultCustomer.getString("faxNumber");
                email = resultCustomer.getString("email");
                nationalInsuranceNumber = resultCustomer.getString(
                        "nationalInsuranceNumber");
                savingsAccountNumber = resultCustomer.getString(
                        "savingsAccountNumber");

                Statement statementAddress = connection.createStatement();
                ResultSet resultAddress = statementAddress.executeQuery(
                        "SELECT * FROM Address WHERE `addressID` = " +
                        addressID);
                if (resultAddress.absolute(1)) {
                    propertyName = resultAddress.getString("propertyName");
                    streetName = resultAddress.getString("streetName");
                    town = resultAddress.getString("town");
                    country = resultAddress.getString("country");
                    postCode = resultAddress.getString("postCode");
                    address = new Address(addressID, propertyName, streetName,
                            town, country, postCode);
                } else {
                    return null;
                }
                resultAddress.close();
                statementAddress.close();

                customer = new Customer(customerID, title, forenames, surname,
                        dateOfBirth, isFemale, address, telephone, faxNumber,
                        email, nationalInsuranceNumber, savingsAccountNumber);
            }
            resultCustomer.close();
            statementCustomer.close();
            return customer;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return null;
        } catch (IllegalArgumentException e) {
            writeSQLError("IllegalArgumentException: SQL returned invalid " +
                    "data in getCustomerByID()");
            return null;
        }
    }

    @Override
    public Collection<Customer> getCustomersByName(final String surnameSearched,
            final String forenamesSearched){
        
        if (surnameSearched == null || forenamesSearched == null ) return null;
        
        int customerID, addressID;
        String title, forenames, telephone, faxNumber, email,
                nationalInsuranceNumber, savingsAccountNumber, surname;
        GregorianCalendar dateOfBirth;
        boolean isFemale;
        Address address;
        ArrayList<Customer> customers = new ArrayList<Customer>();
        String propertyName, streetName, town, country, postCode;

        try {
            Statement statementCustomer = connection.createStatement();
            ResultSet resultCustomer = statementCustomer.executeQuery(
                    "SELECT * FROM Customer WHERE forenames LIKE '%" +
                    forenamesSearched + "%' AND surname LIKE '%" + 
                    surnameSearched + "%';");

            while (resultCustomer.next()) {
                customerID = resultCustomer.getInt("customerID");
                title = resultCustomer.getString("title");
                forenames = resultCustomer.getString("forenames");
                surname = resultCustomer.getString("surname");
                dateOfBirth = new GregorianCalendar();
                dateOfBirth.setTime(resultCustomer.getDate("dateOfBirth"));
                isFemale = resultCustomer.getBoolean("isFemale");
                addressID = resultCustomer.getInt("addressID");
                telephone = resultCustomer.getString("telephone");
                faxNumber = resultCustomer.getString("faxNumber");
                email = resultCustomer.getString("email");
                nationalInsuranceNumber = resultCustomer.getString(
                        "nationalInsuranceNumber");
                savingsAccountNumber = resultCustomer.getString(
                        "savingsAccountNumber");

                Statement statementAddress = connection.createStatement();
                ResultSet resultAddress = statementAddress.executeQuery(
                        "SELECT * FROM Address WHERE `addressID` = " +
                        addressID);
                if (resultAddress.absolute(1)) {
                    propertyName = resultAddress.getString("propertyName");
                    streetName = resultAddress.getString("streetName");
                    town = resultAddress.getString("town");
                    country = resultAddress.getString("country");
                    postCode = resultAddress.getString("postCode");
                    address = new Address(addressID, propertyName, streetName,
                            town, country, postCode);
                } else {
                    continue;
                }
                customers.add(new Customer(customerID, title, forenames,
                        surname, dateOfBirth, isFemale, address, telephone,
                        faxNumber, email, nationalInsuranceNumber,
                        savingsAccountNumber));
                resultAddress.close();
                statementAddress.close();
            }
            resultCustomer.close();
            statementCustomer.close();
            return customers;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return null;
        } catch (IllegalArgumentException e) {
            writeSQLError("IllegalArgumentException: SQL returned invalid " +
                    "data in searchCustomerByForenames()");
            return null;
        }
    }
    
    @Override
    public Collection<Customer> getCustomersByAddressID(final String addressIDSearched) {
        int customerID;
        String title, forenames, telephone, faxNumber, email,
                nationalInsuranceNumber, savingsAccountNumber, surname;
        GregorianCalendar dateOfBirth;
        boolean isFemale;
        Address address;
        ArrayList<Customer> customers = new ArrayList<Customer>();
        String propertyName, streetName, town, country, postCode;
        int addressID;

        try {
            Statement statementCustomer = connection.createStatement();
            ResultSet resultCustomer = statementCustomer.executeQuery(
                    "SELECT * FROM Customer WHERE `addressID` = " + addressIDSearched);

            while (resultCustomer.next()) {
                customerID = resultCustomer.getInt("customerID");
                title = resultCustomer.getString("title");
                forenames = resultCustomer.getString("forenames");
                surname = resultCustomer.getString("surname");
                dateOfBirth = new GregorianCalendar();
                dateOfBirth.setTime(resultCustomer.getDate("dateOfBirth"));
                isFemale = resultCustomer.getBoolean("isFemale");
                addressID = resultCustomer.getInt("addressID");
                telephone = resultCustomer.getString("telephone");
                faxNumber = resultCustomer.getString("faxNumber");
                email = resultCustomer.getString("email");
                nationalInsuranceNumber = resultCustomer.getString(
                        "nationalInsuranceNumber");
                savingsAccountNumber = resultCustomer.getString(
                        "savingsAccountNumber");

                Statement statementAddress = connection.createStatement();
                ResultSet resultAddress = statementAddress.executeQuery(
                        "SELECT * FROM Address WHERE `addressID` = " +
                        addressID);
                if (resultAddress.absolute(1)) {
                    propertyName = resultAddress.getString("propertyName");
                    streetName = resultAddress.getString("streetName");
                    town = resultAddress.getString("town");
                    country = resultAddress.getString("country");
                    postCode = resultAddress.getString("postCode");
                    address = new Address(addressID, propertyName, streetName,
                            town, country, postCode);
                } else {
                    continue;
                }
                customers.add(new Customer(customerID, title, forenames,
                        surname, dateOfBirth, isFemale, address, telephone,
                        faxNumber, email, nationalInsuranceNumber,
                        savingsAccountNumber));
                resultAddress.close();
                statementAddress.close();
            }
            resultCustomer.close();
            statementCustomer.close();
            return customers;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return null;
        } catch (IllegalArgumentException e) {
            writeSQLError("IllegalArgumentException: SQL returned invalid " +
                    "data in searchCustomerByAddressID()");
            return null;
        }
    }
    
    @Override
    public Collection<Customer> getCustomersByAddress(final String country,
            final String town, final String postCode, final String streetName,
            final String propertyName){
        
        // local variables declaration
        int customerID;
        String title;
        String forenames;
        String surname;
        GregorianCalendar dateOfBirth;
        boolean isFemale;
        String telephone,faxNumber,email,nationalInsuranceNumber,
                savingsAccountNumber,propertyName2,streetName2,town2,country2,
                postCode2;
        Address address;
        ArrayList<Customer> customers = new ArrayList<Customer>();
        
        
        
        //check if arguments are not null
        if (country == null || town == null || postCode == null || 
                streetName == null || propertyName == null){
            return null;
        }
        
        
        //processing work:
        try{
            Statement statementAddress = connection.createStatement();
            String query = "SELECT * FROM Address WHERE";
            query += " country LIKE '%" + country + "%'";
            query += " AND town LIKE '%" + town + "%'";
            query += " AND postCode LIKE '%" + postCode + "%'";
            query += " AND streetName LIKE '%" + streetName + "%'";
            query += " AND propertyName LIKE '%" + propertyName + "%';";
            ResultSet resultAddress = statementAddress.executeQuery(query);
            
            while (resultAddress.next()){
                
                int addressID = resultAddress.getInt("addressID");
                Statement statementCustomer = connection.createStatement();
                ResultSet resultCustomer = statementCustomer.executeQuery("SELECT * " +
                        "FROM Customer WHERE `addressID` = " + addressID + ";");
                
                while (resultCustomer.next()) {
                    //customer's info:
                    customerID = resultCustomer.getInt("customerID");
                    title = resultCustomer.getString("title");
                    forenames = resultCustomer.getString("forenames");
                    surname = resultCustomer.getString("surname");
                    dateOfBirth = new GregorianCalendar();
                    dateOfBirth.setTime(resultCustomer.getDate("dateOfBirth"));
                    isFemale = resultCustomer.getBoolean("isFemale");
                    //addressID = resultCustomer.getInt("addressID");
                    telephone = resultCustomer.getString("telephone");
                    faxNumber = resultCustomer.getString("faxNumber");
                    email = resultCustomer.getString("email");
                    nationalInsuranceNumber = resultCustomer.getString(
                            "nationalInsuranceNumber");
                    savingsAccountNumber = resultCustomer.getString(
                            "savingsAccountNumber");
                    
                    //address of the customer:
                    propertyName2 = resultAddress.getString("propertyName");
                    streetName2 = resultAddress.getString("streetName");
                    town2 = resultAddress.getString("town");
                    country2 = resultAddress.getString("country");
                    postCode2 = resultAddress.getString("postCode");
                    address = new Address(addressID, propertyName2, streetName2,
                            town2, country2, postCode2);
                    
                    //adding the customer
                    customers.add(new Customer(customerID, title, forenames,
                            surname, dateOfBirth, isFemale, address, telephone,
                            faxNumber, email, nationalInsuranceNumber,
                            savingsAccountNumber));  
                }
                statementCustomer.close();
                resultCustomer.close();
            }
            resultAddress.close();
            statementAddress.close();
            return customers;
        }catch (SQLException e){
            writeSQLError("SQLException:" + e.toString());
            return null;
        }catch (IllegalArgumentException e){
            writeSQLError("IllegalArgumentException: SQL returned invalid " +
                    "data in searchCustomerByAddress()\n" + e.toString());
            return null;
        } 
    }

    @Override
    public StaffMember getStaffMemberByUsername(final String uname) {
        int staffID, addressID;
        String title,forenames ,surname ,telephone ,faxNumber ,email ,username ,password ,propertyName , streetName, town, country, postCode;
        boolean isFemale,  isManager, stillWithCompany;
        GregorianCalendar dateOfBirth;
        Address address;
        StaffMember staff;

        try {
            staff = null;
            Statement statementStaff = connection.createStatement();
            ResultSet resultStaff = statementStaff.executeQuery(
                    "SELECT * FROM StaffMember WHERE username = '" + uname +
                    "'");
            if (resultStaff.absolute(1)) {
                staffID = resultStaff.getInt("staffID");
                title = resultStaff.getString("title");
                forenames = resultStaff.getString("forenames");
                surname = resultStaff.getString("surname");
                dateOfBirth = new GregorianCalendar();
                dateOfBirth.setTime(resultStaff.getDate("dateOfBirth"));
                isFemale = resultStaff.getBoolean("isFemale");
                addressID = resultStaff.getInt("addressID");
                telephone = resultStaff.getString("telephone");
                faxNumber = resultStaff.getString("faxNumber");
                email = resultStaff.getString("email");
                isManager = resultStaff.getBoolean("isManager");
                username = resultStaff.getString("username");
                password = resultStaff.getString("password");
                stillWithCompany = resultStaff.getBoolean("stillWithCompany");

                Statement statementAddress = connection.createStatement();
                ResultSet resultAddress = statementAddress.executeQuery(
                        "SELECT * FROM Address WHERE `addressID` = " +
                        addressID);
                if (resultAddress.absolute(1)) {
                    propertyName = resultAddress.getString("propertyName");
                    streetName = resultAddress.getString("streetName");
                    town = resultAddress.getString("town");
                    country = resultAddress.getString("country");
                    postCode = resultAddress.getString("postCode");
                    address = new Address(addressID, propertyName, streetName,
                            town, country, postCode);
                } else {
                    return null;
                }
                resultAddress.close();
                statementAddress.close();

                staff = new StaffMember(staffID, title, forenames, surname,
                        dateOfBirth, isFemale, address, telephone, faxNumber,
                        email, isManager, username, password, stillWithCompany);
            }
            resultStaff.close();
            statementStaff.close();
            return staff;
        } catch (SQLException e) {
            writeSQLError("SQLException: " + e.toString());
            return null;
        } catch (IllegalArgumentException e) {
            writeSQLError("IllegalArgumentException: SQL returned invalid " +
                    "data in getStaffMemberByUsername()");
            return null;
        }
    }

    /**
     * Output an SQL error to file when an SQL error occurrs. The format will be
     * written as (current times used): dd/mm/yyyy hh:mm:ss:msmsms error
     * @param error
     */
    private static void writeSQLError(final String error) {
        try {
            BufferedWriter output = new BufferedWriter(
                    new FileWriter(ERRORFILE, true));
            GregorianCalendar now = new GregorianCalendar();
            output.write(now.get(GregorianCalendar.DAY_OF_MONTH) + "/" +
                    now.get(GregorianCalendar.MONTH) + "/" +
                    now.get(GregorianCalendar.YEAR) + " " +
                    now.get(GregorianCalendar.HOUR_OF_DAY) + ":" +
                    now.get(GregorianCalendar.MINUTE) + ":" +
                    now.get(GregorianCalendar.SECOND) + ":" +
                    now.get(GregorianCalendar.MILLISECOND) + " " + error +
                    "\n");
            output.close();
        } catch (IOException e) {
            // We're already tried to report an error and failed, why try to
            // recover?
        }
    }
}