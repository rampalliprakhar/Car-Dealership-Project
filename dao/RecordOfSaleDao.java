import java.sql.*;
/*-------------------------------------------------
 * Author:          Carlot Team
 * Written:         04/20/2023
 * Last Update:     04/23/2023
 * 
 * 
 * Record of Sale Dao class. The Record of Sale DAO allows us to access and manipulate
 * the data within the database. Sold Vehicle information is one table that has two foreign keys Customer and Employee. 
 * 
 * 
 * Constructor
 * A default constructor that obtains connection for database. 
 * 
 * Methods
 * saveSoldVehicle - Passed Vehicle Object, Employee Object, and Customer Object. Saves all information to Sold Vehicle Table. 
 * deleteSoldVehicle - This deletes the sold vehicle from the !VEHICLE TABLE! not from Sold Vehicle Table!
 * 
 * close - closes the connection. 
 * 
 * 
 *    
 *    
 */
public class RecordOfSaleDao {
	//Used to hold reference of JDBC connection. Allows for execution of SQL statements. 
	public Connection conn;
	
	/**
	* RecordOfSaleDao -  Constructor sets up the connection for the database to be used during queries. 
	* Its possible for the connection to throw an exception catch exception and print to screen. 
	* 
	* 
	*
	*
	*/
	public RecordOfSaleDao() {
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
	* saveSoldVehicle - Method passed vehicle object, utilized "getter" methods from the back end classes
	* to set information.  
	* 
	* 
	* 
	* 
	*
	*/
	public void saveSoldVehicle(Vehicle vehicleInformation, CustomerProfile buyer, Employee seller, RecordOfSale sale)
	{
		//Statement is an interface in the JDBC API that represents a SQL statement that
		//is sent to the database and executed. 
		Statement stmt = null;
		//Possible exception can be thrown, failure to respond. 
		try 
		{
			//Creates a Statement object for sendingSQL statements to the database.
			stmt = conn.createStatement();
			this.deleteSoldVehicle(vehicleInformation);
			//SQL Statement to insert Customer information. Defines the action. 
			String vehicleSoldInfo = "INSERT INTO Sold_Vehicle (Vin, Year, Make, Model, Total_Price, Date_of_Sale, Customer_CustomerID, Employee_EmployeeID) VALUES ('" 
			+ vehicleInformation.getVIN() + "', '" + vehicleInformation.getYear() + "', '" + vehicleInformation.getMake() + "' , '" + vehicleInformation.getModel() 
			+ "', '" + sale.calcTotal() + "', '" + sale.getDateOfSale() + "', '" + buyer.getLicenseNum() + "', '" + seller.getEmployeeID()
			+ "')";
			
			//Executes the given SQL statement, which may be an INSERT, UPDATE, or DELETE 
			//statement or anSQL statement that returns nothing, such as an SQL DDL statement. 
			stmt.executeUpdate(vehicleSoldInfo);
			
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
	* deleteSoldVehicle - Deletes the vehicles information.  
	* 
	* 
	* 
	* 
	* 
	*
	*/
	public void deleteSoldVehicle(Vehicle vehicleInformation)
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
}
