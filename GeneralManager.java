
public class GeneralManager extends Employee {
	
	/* unique view: 
	 * can create new employee??
	 * can access and approve records of sales
	 * can access a report 
	 * can apply discounts
	 */
	
	// default constructor
	public GeneralManager() {
		System.out.println("error, please fill out the form");    // should change to pop up error or remind the user to fill out the rest of the form
	}

	// constructor
	public GeneralManager(String firstName, String lastName, String password) {
		super(firstName, lastName, "General Manager", password);
	}
	
}
