
public class GeneralManager extends Employee {
	
	/* unique responsibilities: 
	 * can create new employee??
	 * can access and approve records of sales
	 * can access a report 
	 * can apply discounts
	 */
	
	
	// default constructor
	public GeneralManager() {
		super();
	}

	// constructor
	public GeneralManager(String firstName, String lastName, String position, String userName, String password) {
		super(firstName, lastName, "General Manager", userName, password);
	}
	
	public double setPercentageDiscount(double percentageDiscount, double originalPrice) {    	  // ex: 25% off 
		return (100 - percentageDiscount) * originalPrice;
	}
	
	public void setPriceDiscount(double priceDiscount, double originalPrice) {			  // ex: $2,500 off or set new price to 10,000??? 
	
	
	}

	
}
