import java.util.Date;

public class CustomerProfile {
	private String firstName;
	private String lastName;
	private double customerID; // or int?
	private String phoneNum; // is it string or double
	private Date birthDate;
	
	private Addresses address; // customer can have multiple

	
	// default constructor
	public CustomerProfile() {
		
	}


	// constructor
	public CustomerProfile(String firstName, String lastName, String phoneNum, Date birthDate,
			Addresses address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.birthDate = birthDate;
		this.address = address;
		
		//this.customerID = randomly generate a unique ID
		
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


	public double getCustomerID() {
		return customerID;
	}


//	public void setCustomerID(double customerID) {           // would you ever have to manually set customer ID?
//		this.customerID = customerID;
//	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public Date getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public Addresses getAddress() {
		return address;
	}


	public void setAddresses(Addresses address) {
		this.address = address;
	}	
}
