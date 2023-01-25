
public class Employee {

	// all employees should be able to log in, log out, view vehicle database, idk
	
	
	private String firstName;
	private String lastName;
	private double employeeID; // or int??
	private String position;

	
	private String userName;
	private String password;

	
	// default constructor
	public Employee() {
		
	}
	
	// constructor 
	public Employee(String firstName, String lastName, String position, String userName,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.userName = userName;
		this.password = password;
		
//		this.employeeID = // randomly generates UNIQUE number
	}




	public boolean logIn(String userName, String password) {
		
		if (userName == this.userName && password == this.password)
			return true;
		else return false;

	}

	
	
	
	
	
	
	
	// getters and setters
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getEmployeeID() {
		return employeeID;
	}

//	public void setEmployeeID(double employeeID) {                 uneeded bc id is already created randomly??
//		this.employeeID = employeeID;
//	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
