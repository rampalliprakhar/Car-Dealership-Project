package dao;

import java.sql.*;
import backend.CustomerProfile;
import backend.Address;
/*-------------------------------------------------
 * Author:          Carlot Team
 * Written:         03/31/2023
 * Last Update:     03/04/2023
 * 
 * 
 * CustomerDAO class. The Customer Data Access Object allows us to access and manipulate
 * the data within the database. Customer information is in two database Customer and Customer Address.
 * 
 * 
 * Constructor
 * A default constructor that obtains connection for database. 
 * 
 * .
 * 
 * Methods
 * saveCustomer - Passed CustomerProfile Object. Saves all of the information to the database
 * 
 * retriveCustomer- retrieves all of one customers information from the database. 
 * 
 * updateCustomer - updates the given customer information.
 * 
 * deleteCustomer - deletes the given customers information from the database.
 * 
 * close - closes the connection. 
 * 
 * 
 *    
 *    
 */
public class CustomerDao {
    
    //Used to hold reference of JDBC connection. Allows for execution of SQL statements. 
    public Connection conn;
    
    /**
    * CustomerDao -  Constructor sets up the connection for the database to be used during queries. 
    * Its possible for the connection to throw an exception catch exception and print to screen. 
    * 
    * 
    *
    *
    */
    public CustomerDao() {
        //Url to the location of database, ip address, and actual database name.
        String url = "jdbc:mysql://34.133.59.182/carlot";
        //Username to login to the database.
        String user = "teamaccount";
        //Password to login to the database.
        String pass = "475843aoa!!";
        
        //Possible exception can be thrown such as bad url, username, or password. 
        try 
        {
         /**This fully implemented class connects an application to a data source, 
         *which is specified by a database URL. When this class first attempts to 
         *establish a connection, it automatically loads any JDBC drivers found within the class 
         *path
         * 
         */
        conn = DriverManager.getConnection(url,user,pass);
        }
        //If exception thrown catch and print error. You can google the error. 
        catch (SQLException login)
        {
            //Returns the detail message string of this throwable.
            System.out.println("SQLException: " + login.getMessage());
            //Retrieves the SQLState for this SQLException object.
            System.out.println("SQLState: " + login.getSQLState());
            //Retrieves the vendor-specific exception code for this SQLException object.
            System.out.println("VendorError: " + login.getErrorCode());
        }
    }
    /**
    * saveCustomer - Method passed customer profile object, utilized "getter" methods from the back end class
    * to set information. Utilized the Address object thats a part of customer profile object getter methods to set 
    * data. 
    * 
    * 
    * 
    *
    */
    public void saveCustomer(CustomerProfile customerInformation)
    {
        //Statement is an interface in the JDBC API that represents a SQL statement that
        //is sent to the database and executed. 
        Statement stmt = null;
        //Possible exception can be thrown, failure to respond. 
        try 
        {
            //Creates a Statement object for sendingSQL statements to the database.
            stmt = conn.createStatement();
            
            //SQL Statement to insert Customer information. Defines the action. 
            String customerInfo = "INSERT INTO Customer (CustomerID, FirstName, LastName, PhoneNumber) VALUES ('" 
            + customerInformation.getLicenseNum() + "', '" + customerInformation.getFirstName() + "', '" + customerInformation.getLastName() + "' , '" + customerInformation.getPhoneNum() + "')";
            
            //SQL Statement to insert Customer information. Defines the action.
            String customerAddress = "INSERT INTO CustomerAddress (CustomerID, Street, City, State, ZipCode) VALUES ('"
            + customerInformation.getLicenseNum() +  "', '" + customerInformation.getAddress().getStreet() + "', '" + customerInformation.getAddress().getCity() + "', '"
            + customerInformation.getAddress().getCountry() + "', '" + customerInformation.getAddress().getZipCode() + "')";
            //Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE 
            //statement or anSQL statement that returns nothing, such as an SQL DDL statement. 
            stmt.executeUpdate(customerInfo);
            stmt.executeUpdate(customerAddress);
        }
        //If exception thrown catch and print error. You can google the error.
        catch (SQLException insert)
        {
            //Returns the detail message string of this throwable.
            System.out.println("SQLException: " + insert.getMessage());
            //Retrieves the SQLState for this SQLException object.
            System.out.println("SQLState: " + insert.getSQLState());
            //Retrieves the vendor-specific exception code for this SQLException object.
            System.out.println("VendorError: " + insert.getErrorCode());
        }
        //Exception doesn�t occur in try-block, close out connection
        finally
        {
            //If stmt is not null then close connection
            if(stmt != null)
            {
                //Possible exception can be thrown catch it
                try
                {
                    //Releases this Statement object's database and JDBC resources immediately instead of 
                    //waiting for this to happen when it is automatically closed.
                    stmt.close();
                }
                //Catch error message print to screen. 
                catch (SQLException closeStmt)
                {
                     System.out.println("SQLException: " + closeStmt.getMessage());
                }
            }
        }
    }
    /**
    * retriveCustomer - Method returns a Customer Profile object. 
    * 
    * 
    * 
    * 
    * 
    *
    */
    public CustomerProfile retriveCustomer(String licenseNum)
    {
        //Create a customer Profile Object
        CustomerProfile retrivedInformation = new CustomerProfile();
        Address retriveAddress = new Address();
        //Statement is an interface in the JDBC API that represents a SQL statement that
        //is sent to the database and executed. 
        Statement stmt = null;
        //ResultSet is a table of data that represents the results of a database query.
        ResultSet getCustomer = null;
        ResultSet getAddress = null;
        //Possible exception can be thrown, failure to respond.
        try
        {
            //Creates a Statement object for sendingSQL statements to the database.
            stmt = conn.createStatement();
            //Executes the given SQL statement, which returns a single ResultSet object.
            //The statement is to return ALL *.
            getCustomer = stmt.executeQuery("SELECT * FROM Customer WHERE CustomerID = '" + licenseNum + "'");
            //If has next then set values
            if (getCustomer.next())
            {
                //Set object variables
                retrivedInformation.setLicenseNum(getCustomer.getString("CustomerID"));
                retrivedInformation.setFirstName(getCustomer.getString("firstName"));
                retrivedInformation.setLastName(getCustomer.getString("lastName"));
                retrivedInformation.setPhoneNum(getCustomer.getString("phoneNumber"));
            }
            
            //if has next set values
            getAddress = stmt.executeQuery("SELECT * FROM CustomerAddress WHERE CustomerID = '" + licenseNum + "'");
            if (getAddress.next())
            {
                //Set object variables
                retriveAddress.setStreet(getAddress.getString("Street"));
                retriveAddress.setCity(getAddress.getString("City"));
                retriveAddress.setCountry(getAddress.getString("State"));
                retriveAddress.setZipCode(getAddress.getString("Zipcode"));
                
            }
        
        }
        catch (SQLException retrieve)
        {
            //Returns the detail message string of this throwable.
            System.out.println("SQLException: " + retrieve.getMessage());
            //Retrieves the SQLState for this SQLException object.
            System.out.println("SQLState: " + retrieve.getSQLState());
            //Retrieves the vendor-specific exception code for this SQLException object.
            System.out.println("VendorError: " + retrieve.getErrorCode());
        }
        //Exception doesn�t occur in try-block, close out connection
        finally
        {
            //If not null then release resources. 
            if(getCustomer != null || getAddress != null)
            {
                try
                {
                    //Releases this ResultSet object's database andJDBC resources immediately 
                    //instead of waiting for this to happen when it is automatically closed. 
                    getCustomer.close();
                    getAddress.close();
                }
                //Catch error message print to screen. 
                catch (SQLException closeResults)
                {
                     System.out.println("SQLException: " + closeResults.getMessage());
                }
            }
            //If stmt is not null then close connection
            if(stmt != null)
            {
                //Possible exception can be thrown catch it
                try
                {
                    //Releases this Statement object's database and JDBC resources immediately instead of 
                    //waiting for this to happen when it is automatically closed.
                    stmt.close();
                }
                //Catch error message print to screen. 
                catch (SQLException closeStmt)
                {
                     System.out.println("SQLException: " + closeStmt.getMessage());
                }
            }
        }
        
        //Due to a null error we must recreate an object to return with all values set here. 
        CustomerProfile returnRetrivedInformation = new CustomerProfile(retrivedInformation.getLicenseNum(), retrivedInformation.getFirstName(), retrivedInformation.getLastName(), retrivedInformation.getPhoneNum(), retriveAddress);
        //Return the object
        return returnRetrivedInformation;
    }
    /**
    * updateCustomer - Updates existing customer information in the database, pass Customer Profile Object. 
    * 
    * 
    * 
    * 
    * 
    *
    */
    public void updateCustomer(CustomerProfile customerInformation)
    {
        //Statement is an interface in the JDBC API that represents a SQL statement that
        //is sent to the database and executed. 
        Statement stmt = null;
        //Possible exception can be thrown, failure to respond. 
        try 
        {
            //Creates a Statement object for sendingSQL statements to the database.
            stmt = conn.createStatement();
            
            //SQL Statement to Update Customer information. Defines the action. 
            String customerInfo = "UPDATE Customer SET FirstName = '" + customerInformation.getFirstName() 
            + "', LastName = '" + customerInformation.getLastName() + "', PhoneNumber = '" + customerInformation.getPhoneNum() 
            + "' WHERE CustomerID = '" + customerInformation.getLicenseNum() + "'";
            //SQL Statement to Update Customer information. Defines the action.
            String customerAddress = "UPDATE CustomerAddress SET Street = '" + customerInformation.getAddress().getStreet() 
            + "', City = '" + customerInformation.getAddress().getCity() + "', State = '" + customerInformation.getAddress().getCountry() 
            + "', ZipCode = '" + customerInformation.getAddress().getZipCode() + "' WHERE CustomerID = '" + customerInformation.getLicenseNum() + "'";
            //Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE 
            //statement or anSQL statement that returns nothing, such as an SQL DDL statement. 
            stmt.executeUpdate(customerInfo);
            stmt.executeUpdate(customerAddress);
        }
        //If exception thrown catch and print error. You can google the error.
        catch (SQLException insert)
        {
            //Returns the detail message string of this throwable.
            System.out.println("SQLException: " + insert.getMessage());
            //Retrieves the SQLState for this SQLException object.
            System.out.println("SQLState: " + insert.getSQLState());
            //Retrieves the vendor-specific exception code for this SQLException object.
            System.out.println("VendorError: " + insert.getErrorCode());
        }
        //Exception doesn�t occur in try-block, close out connection
        finally
        {
            //If stmt is not null then close connection
            if(stmt != null)
            {
                //Possible exception can be thrown catch it
                try
                {
                    //Releases this Statement object's database and JDBC resources immediately instead of 
                    //waiting for this to happen when it is automatically closed.
                    stmt.close();
                }
                //Catch error message print to screen. 
                catch (SQLException closeStmt)
                {
                     System.out.println("SQLException: " + closeStmt.getMessage());
                }
            }
        }
    }
    
    public void deleteCustomer(CustomerProfile customerInformation)
    {
        //Statement is an interface in the JDBC API that represents a SQL statement that
        //is sent to the database and executed. 
        Statement stmt = null;
        try
        {
            //Creates a Statement object for sendingSQL statements to the database.
            stmt = conn.createStatement();
            
            //Commands for deleting the CustomerAddress and Cusmter Information from the database. 
            String deleteAddress = ("DELETE FROM CustomerAddress WHERE CustomerID = '" + customerInformation.getLicenseNum() + "'");
            String deleteCustomer = ("DELETE FROM Customer WHERE CustomerID = '" + customerInformation.getLicenseNum() + "'");
            
            //Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE 
            //statement or anSQL statement that returns nothing, such as an SQL DDL statement.
            stmt.executeUpdate(deleteAddress);
            stmt.execute(deleteCustomer);
        }
        catch (SQLException delete)
        {
            //Returns the detail message string of this throwable.
            System.out.println("SQLException: " + delete.getMessage());
            //Retrieves the SQLState for this SQLException object.
            System.out.println("SQLState: " + delete.getSQLState());
            //Retrieves the vendor-specific exception code for this SQLException object.
            System.out.println("VendorError: " + delete.getErrorCode());
        }
        //Exception doesn�t occur in try-block, close out connection
        finally
        {
            //If stmt is not null then close connection
            if(stmt != null)
            {
                //Possible exception can be thrown catch it
                try
                {
                    //Releases this Statement object's database and JDBC resources immediately instead of 
                    //waiting for this to happen when it is automatically closed.
                    stmt.close();
                }
                //Catch error message print to screen. 
                catch (SQLException closeStmt)
                {
                     System.out.println("SQLException: " + closeStmt.getMessage());
                }
            }
        }
    }
    /**
    * close - closes the connection object. 
    * 
    * 
    * 
    *
    */
    public void close()
    {
        //If conn does not equal null.
        if (conn != null)
        {
            //Try to close connection.
            try
            {
                //Releases this Connection object's database and JDBC resources 
                //immediately instead of waiting for them to be automatically released. 
                conn.close();
            }
            //If exception thrown print to screen. 
            catch(SQLException closeConn)
            {
                System.out.println("SQLException: " + closeConn.getMessage());
                
            }
        }
    }
}



