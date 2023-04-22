package dao;

import java.sql.*;
import backend.Vehicle;
/*-------------------------------------------------
 * Author:          Carlot Team
 * Written:         04/07/2023
 * Last Update:     04/19/2023
 * 
 * 
 * VehicleDao class. The Vehicle Data Access Object allows us to access and manipulate
 * the data within the database. Vehicle information is one table.
 * 
 * 
 * Constructor
 * A default constructor that obtains connection for database. 
 * 
 * .
 * 
 * Methods
 * saveVehicle - Passed Vehicle Object. Saves all of the information to the database
 * 
 * retriveVehicle- retrieves all one vehicles information from the database. 
 * 
 * updateVehicle - updates the given vehicles information.
 * 
 * deleteVehicle - deletes the given vehicles information from the database.
 * 
 * close - closes the connection. 
 * 
 * 
 *    
 *    
 */
public class VehicleDao {
    //Used to hold reference of JDBC connection. Allows for execution of SQL statements. 
    public Connection conn;
    
    /**
    * VehicleDao -  Constructor sets up the connection for the database to be used during queries. 
    * Its possible for the connection to throw an exception catch exception and print to screen. 
    * 
    * 
    *
    *
    */
    public VehicleDao() {
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
    * saveVehicle - Method passed vehicle object, utilized "getter" methods from the back end class
    * to set information.  
    * 
    * 
    * 
    * 
    *
    */
    public void saveVehicle(Vehicle vehicleInformation)
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
            String vehicleInfo = "INSERT INTO Vehicle (Vin, Year, Make, Model, Value, Discount, BodyCondition, MechanicalCondition, Color, Mileage, DateOnLot) VALUES ('" 
            + vehicleInformation.getVIN() + "', '" + vehicleInformation.getYear() + "', '" + vehicleInformation.getMake() + "' , '" + vehicleInformation.getModel() 
            + "', '" + vehicleInformation.getValue() + "', '" + vehicleInformation.getDiscount() + "', '" + vehicleInformation.getBodyCondition() + "', '" + vehicleInformation.getMechCondition() 
            + "', '" + vehicleInformation.getColor() + "', '" + vehicleInformation.getMileage() + "', '" + vehicleInformation.getDateUpdate() + "')";
            
            //Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE 
            //statement or anSQL statement that returns nothing, such as an SQL DDL statement. 
            stmt.executeUpdate(vehicleInfo);
            
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
    * retriveVehicle - Method returns a Vehicle Profile object. 
    * 
    * 
    * 
    * 
    * 
    *
    */
    public Vehicle retriveVehicle(String vinNumber)
    {
        //Create a vehicle Profile Object
        Vehicle retrivedInformation = new Vehicle();
        //Statement is an interface in the JDBC API that represents a SQL statement that
        //is sent to the database and executed. 
        Statement stmt = null;
        //ResultSet is a table of data that represents the results of a database query.
        ResultSet getVehicle = null;
        //Possible exception can be thrown, failure to respond.
        try
        {
            //Creates a Statement object for sendingSQL statements to the database.
            stmt = conn.createStatement();
            //Executes the given SQL statement, which returns a single ResultSet object.
            //The statement is to return ALL *.
            getVehicle = stmt.executeQuery("SELECT * FROM Vehicle WHERE Vin = '" + vinNumber + "'");
            //If has next then set values
            if (getVehicle.next())
            {
                //Set object variables
                retrivedInformation.setVIN(getVehicle.getString("Vin"));
                retrivedInformation.setYear(getVehicle.getInt("Year"));
                retrivedInformation.setMake(getVehicle.getString("Make"));
                retrivedInformation.setModel(getVehicle.getString("Model"));
                retrivedInformation.setValue(getVehicle.getDouble("Value"));
                retrivedInformation.setDiscount(getVehicle.getDouble("Discount"));
                retrivedInformation.setBodyCondition(getVehicle.getString("BodyCondition"));
                retrivedInformation.setMechCondition(getVehicle.getString("MechanicalCondition"));
                retrivedInformation.setColor(getVehicle.getString("Color"));
                retrivedInformation.setMileage(getVehicle.getInt("Mileage"));
                retrivedInformation.setDateFromDatabase(getVehicle.getLong("DateOnLot"));
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
            if(getVehicle != null)
            {
                try
                {
                    //Releases this ResultSet object's database andJDBC resources immediately 
                    //instead of waiting for this to happen when it is automatically closed. 
                    getVehicle.close();
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
    
    /* This method was written by Alan for the SetDiscounts screen
     * It returns the 7 vehicles with the longest time on lot
     * It stores these 7 cars in an array
     */
    public Vehicle[] retrieveSevenVehicles () {
        
        // Array to store all 7 vehicles
        Vehicle[] vehicleList = new Vehicle[7];
        
        // Initialize the Vehicles so they aren't null
        vehicleList[0] = new Vehicle();
        vehicleList[1] = new Vehicle();
        vehicleList[2] = new Vehicle();
        vehicleList[3] = new Vehicle();
        vehicleList[4] = new Vehicle();
        vehicleList[5] = new Vehicle();
        vehicleList[6] = new Vehicle();
        
        //Statement is an interface in the JDBC API that represents a SQL statement that
        //is sent to the database and executed. 
        Statement stmt = null;
        //ResultSet is a table of data that represents the results of a database query.
        ResultSet getVehicle = null;
        //Possible exception can be thrown, failure to respond.
        
        //Possible exception can be thrown, failure to respond.
        try
        {
            //Creates a Statement object for sendingSQL statements to the database.
            stmt = conn.createStatement();
            //Executes the given SQL statement, which returns a single ResultSet object.
            //The statement is to return ALL *.
            getVehicle = stmt.executeQuery("SELECT * FROM Vehicle ORDER BY datePutOnLot");
            //If has next then set values for 7 vehicles
            for (int i = 0; i < vehicleList.length; i++) {
                if (getVehicle.next()) {
                    vehicleList[i].setVIN(getVehicle.getString("Vin"));
                    vehicleList[i].setYear(getVehicle.getInt("Year"));
                    vehicleList[i].setMake(getVehicle.getString("Make"));
                    vehicleList[i].setModel(getVehicle.getString("Model"));
                    vehicleList[i].setValue(getVehicle.getDouble("Value"));
                    vehicleList[i].setDiscount(getVehicle.getDouble("Discount"));
                    vehicleList[i].setBodyCondition(getVehicle.getString("BodyCondition"));
                    vehicleList[i].setMechCondition(getVehicle.getString("MechanicalCondition"));
                    vehicleList[i].setColor(getVehicle.getString("Color"));
                    vehicleList[i].setMileage(getVehicle.getInt("Mileage"));
                    vehicleList[i].setDateFromDatabase(getVehicle.getLong("DateOnLot"));
                }
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
            if(getVehicle != null)
            {
                try
                {
                    //Releases this ResultSet object's database andJDBC resources immediately 
                    //instead of waiting for this to happen when it is automatically closed. 
                    getVehicle.close();
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
        return vehicleList;
        
    } // end retrieveSevenVehicles
    
    
    /**
    * updateVehicle - Updates existing vehicle information in the database, pass Vehicle Object. 
    * 
    * 
    * 
    * 
    * 
    *
    */
    public void updateVehicle(Vehicle vehicleInformation)
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
            String vehicleInfo = "UPDATE Vehicle SET Vin = '" + vehicleInformation.getVIN() 
            + "', Year = '" + vehicleInformation.getYear() + "', Make = '" + vehicleInformation.getMake() + "', Model = '" + vehicleInformation.getModel()
            + "', Value = '" + vehicleInformation.getValue() + "', Discount = '" + vehicleInformation.getDiscount() + "', BodyCondition = '" + vehicleInformation.getBodyCondition()
            + "', MechanicalCondition = '" + vehicleInformation.getMechCondition() + "', Color = '" + vehicleInformation.getColor() + "', Mileage = '" + vehicleInformation.getMileage()
            + "', DateOnLot = '" + vehicleInformation.getDateUpdate() 
            + "' WHERE VIN = '" + vehicleInformation.getVIN() + "'";
            //Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE 
            //statement or anSQL statement that returns nothing, such as an SQL DDL statement. 
            stmt.executeUpdate(vehicleInfo);
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
    * deleteVehicle - Deletes the vehicles information.  
    * 
    * 
    * 
    * 
    * 
    *
    */
    void deleteVehicle(Vehicle vehicleInformation)
    {
        //Statement is an interface in the JDBC API that represents a SQL statement that
        //is sent to the database and executed. 
        Statement stmt = null;
        try
        {
            //Creates a Statement object for sendingSQL statements to the database.
            stmt = conn.createStatement();
            
            //Commands for deleting the Vehicle Information from database. 
            String deleteVehicle = ("DELETE FROM Vehicle WHERE Vin = '" + vehicleInformation.getVIN() + "'");
            
            //Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE 
            //statement or anSQL statement that returns nothing, such as an SQL DDL statement.
            stmt.executeUpdate(deleteVehicle);
            
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
    void close()
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
