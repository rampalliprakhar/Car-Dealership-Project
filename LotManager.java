
public class LotManager extends Employee{

	/* unique responsibilities: 
	 * can create and change vehicles in vehicle database
	 */
	
	// default constructor
	public LotManager() {
		super();
	}

	// constructor
	public LotManager(String firstName, String lastName, String position, String userName, String password) {
		super(firstName, lastName, "Lot Manager", userName, password);
	}
}
