
public class LotManager extends Employee{

	/* unique view: 
	 * can create and change vehicles in vehicle database
	 */
	
	// default constructor
	public LotManager() {
		System.out.println("error, please fill out the form");
	}

	// constructor
	public LotManager(String firstName, String lastName, String password) {
		super(firstName, lastName, "Lot Manager", password);
	}
}
