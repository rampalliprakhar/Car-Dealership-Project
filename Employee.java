import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class Employee {
	

	// all employees should be able to log in, log out, view vehicle database, idk
	
	private String firstName;
	private String lastName;
	private int employeeID;
	private String position;

	
	private String password;
	
	private static Set<Integer> set = new HashSet<Integer>();			

	// default constructor
	public Employee() {
		
	}
	
	// constructor 
	public Employee(String firstName, String lastName, String position, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.password = password;

		this.employeeID = id();

	}
	
	public int id() {
		Random rand = new Random(); 		
		
		int num = rand.nextInt(10000);
		
		while (set.contains(num)) {
			num = rand.nextInt(10000);
		}
		
			set.add(num);
			return num;
	}

	public boolean logIn(int employeeID, String password) {
		
		if (employeeID == this.employeeID && password == this.password)
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

	public int getEmployeeID() {
		return employeeID;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
