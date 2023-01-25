import java.util.Date;

public class Salesperson extends Employee{
	
	/* unique responsibilities: 
	 * can create and change customer profiles
	 * can create records of sales
	 */
	
	
	private double commissionsYTD;
	private double salesYTD;
	
	// default constructor
	public Salesperson() {
		super();
	}
	
	// constructor
	public Salesperson(String firstName, String lastName, String position, String userName,
			String password) {
		
		super(firstName, lastName, "Salesperson", userName, password);
	}


	public void createCustomerProfile(String firstName, String lastName, String phoneNum, Date birthDate,
			Addresses address) {
		CustomerProfile newProfile = new CustomerProfile(firstName, lastName, phoneNum, birthDate, address);

	}
	
	
	
	
//	private void createRecordOfSale(Vehicle VIN, CustomerProfile customerID, String paymentMethod) { // salesperson will give vehicle id, customer id, and payment method???
//		
//		
//		
//		RecordOfSale newRecord = new RecordOfSale(/* get todays date*/, vehicleSold /* get vehicle make model etc from vin*/, vehiclePrice, /* get price and calculate commission*/,
//			paymentMethod, manufacturer, customerName /* get name from id*/, customerID, employeeID,
//				employeeName/* get name from id*/);
//		
//	}
}
