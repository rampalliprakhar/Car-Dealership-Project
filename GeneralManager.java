
public class GeneralManager extends Employee {
	
	/* unique responsibilities: 
	 * can create new employee??
	 * can access and approve records of sales
	 * can access a report 
	 */
	
	
	// default constructor
	public GeneralManager() {
		super();
	}

	// constructor
	public GeneralManager(String firstName, String lastName, String position, String userName, String password) {
		super(firstName, lastName, "General Manager", userName, password);
	}

	
}
