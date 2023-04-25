package dao;

import java.sql.*;
import backend.Employee;
/*-------------------------------------------------
 * Author:          Carlot Team
 * Written:         04/16/2023
 * Last Update:     04/25/2023
 * 
 * 
 * EmployessDao class. The Employee Data Access Object allows us to access and manipulate
 * the data within the database.
 * 
 * 
 * Constructor
 * A default constructor that obtains connection for database. 
 * 
 * .
 * 
 * Methods
 * saveEmployee - Passed Employee Object. Saves all information to database. 
 * retriveEmployee - Retrieves employee information from the database, returns employee object. 
 * updateEmployee - updates the given employees information.
 * deleteEmployee - deletes the given employees information. 
 * 
 * close - closes the connection. 
 * 
 * 
 *    
 *    
 */
public class EmployeeDao {
    //Used to hold reference of JDBC connection. Allows for execution of SQL statements. 
    public Connection conn;
    /**
    * EmployeeDAO -  Constructor sets up the connection for the database to be used during queries. 
    * Its possible for the connection to throw an exception catch exception and print to screen. 
    * 
    * 
    *
    *
    */
    public EmployeeDao() {
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
    * saveEmployee - passed Employee object. 
    * 
    * 
    * 
    * 
    *
    */
    public void saveEmployee(Employee employeeInformation)
    {
        //Statement is an interface in the JDBC API that represents a SQL statement that
        //is sent to the database and executed. 
        Statement stmt = null;
        //Possible exception can be thrown, failure to respond. 
        try 
        {
            //Creates a Statement object for sendingSQL statements to the database.
            stmt = conn.createStatement();
            
            //SQL Statement to insert Employee information. Defines the action. 
            String employeeInfo = "INSERT INTO Employee (FirstName, LastName, HasManagerRights, Password, CommissionPercentage) VALUES ('" 
            + employeeInformation.getFirstName() + "', '" + employeeInformation.getLastName() + "', " + employeeInformation.hasManagerRights() + ", '" + employeeInformation.getPassword() + "', " + employeeInformation.getComPercentage() + ")";
            
            //Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE 
            //statement or anSQL statement that returns nothing, such as an SQL DDL statement. 
            stmt.executeUpdate(employeeInfo);
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
    * retriveEmployee - Method returns a Employee object. 
    * 
    * 
    * 
    * 
    * 
    *
    */
    public Employee retriveEmployee(String employeeID)
    {
        //Create a employee object
        Employee retrivedInformation = new Employee();
        
        //Statement is an interface in the JDBC API that represents a SQL statement that
        //is sent to the database and executed. 
        Statement stmt = null;
        //ResultSet is a table of data that represents the results of a database query.
        ResultSet getEmployee = null;
        //Possible exception can be thrown, failure to respond.
        try
        {
            //Creates a Statement object for sendingSQL statements to the database.
            stmt = conn.createStatement();
            //Executes the given SQL statement, which returns a single ResultSet object.
            //The statement is to return ALL *.
            getEmployee = stmt.executeQuery("SELECT * FROM Employee WHERE EmployeeID = '" + employeeID + "'");
            //If has next then set values
            if (getEmployee.next())
            {
                //Set object variables
                retrivedInformation.setEmployeeID(getEmployee.getInt("employeeID"));
                retrivedInformation.setFirstName(getEmployee.getString("firstName"));
                retrivedInformation.setLastName(getEmployee.getString("lastName"));
                retrivedInformation.setHasManagerRights(getEmployee.getBoolean("hasManagerRights"));
                retrivedInformation.setPassword(getEmployee.getString("password"));
                retrivedInformation.setComPercentage(getEmployee.getDouble("CommissionPercentage"));
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
            if(getEmployee != null)
            {
                try
                {
                    //Releases this ResultSet object's database andJDBC resources immediately 
                    //instead of waiting for this to happen when it is automatically closed. 
                    getEmployee.close();
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
        //Return the object
        return retrivedInformation;
    }
    /**
    * updateEmployee - Updates existing Employee information in the database, passed Employee Object. 
    * 
    * 
    * 
    * 
    * 
    *
    */
    public void updateEmployee(Employee employeeInformation)
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
            String employeeInfo = "UPDATE Employee SET employeeID = '" + employeeInformation.getEmployeeID() 
            + "', FirstName = '" + employeeInformation.getFirstName() + "', LastName = '" + employeeInformation.getLastName() 
            + "', HasManagerRights = " + employeeInformation.hasManagerRights() + ", Password = '" + employeeInformation.getPassword()
            + "', CommissionPercentage = '" + employeeInformation.getComPercentage()  
            + "' WHERE employeeID = '" + employeeInformation.getEmployeeID() + "'";

            //Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE 
            //statement or anSQL statement that returns nothing, such as an SQL DDL statement. 
            stmt.executeUpdate(employeeInfo);
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
        //Exception does not occur in try-block, close out connection
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
    * deleteEmployee - Deletes the employees information.  
    * 
    * 
    * 
    * 
    * 
    *
    */
    public void deleteEmployee(Employee employeeInformation)
    {
        //Statement is an interface in the JDBC API that represents a SQL statement that
        //is sent to the database and executed. 
        Statement stmt = null;
        try
        {
            //Creates a Statement object for sendingSQL statements to the database.
            stmt = conn.createStatement();
            
            //Commands for deleting Employee Information from the database. 
            String deleteEmployee = ("DELETE FROM Employee WHERE EmployeeID = '" + employeeInformation.getEmployeeID() + "'");
            
            //Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE 
            //statement or anSQL statement that returns nothing, such as an SQL DDL statement.
            stmt.execute(deleteEmployee);
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
        //Exception does not occur in try-block, close out connection
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
