import java.util.Date;

public class Salesperson extends Employee{
	
	/* unique view: 
	 * can create and change customer profiles
	 * can create records of sales
	 * can request approval of records of sales
	 */
	
	
	private double commissionsYTD;
	private double salesYTD;
	
	// default constructor
	public Salesperson() {
		System.out.println("error, please fill out the form");
	}
	
	// constructor
	public Salesperson(String firstName, String lastName, String password) {
		
		super(firstName, lastName, "Salesperson", userName, password);
	}
}
