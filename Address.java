
public class Address {
	private String streetNum;
	private String street;
	private String city;
	private String country;
	private String zipCode;
	
	private String unit;
	private String building;
	private String addressType;
	
	private String customerID;

	
	
	
	
	// default constructor
	public Address() {
		
	}
	
	
	// constructor
	public Address(String streetNum, String street, String city, String country, String zipCode, String customerID) {
		super();
		this.streetNum = streetNum;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
		this.customerID = customerID;
	}
	
	
	
	// make diff constructor for if unit and etc is given
	
	
	
	
	
	

	// getters and setters
	
	public String getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	
	
	
	
	
	
	
	public void printAddress() {
	}
}
