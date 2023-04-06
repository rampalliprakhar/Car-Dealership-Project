

package backend;

public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    
    private String unit;
    private String building;
    private String addressType;
    
    private String customerID;
    
    
    // default constructor
    public Address() {
        
    }
    
    
    // constructor
    public Address(String street, String city, String state, String zipCode, String customerID) {
        super();
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.customerID = customerID;
    }
    
    
    
    // make diff constructor for if unit and etc is given
    
    
    
    
    
    

    // getters and setters
    

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
        return state;
    }

    public void setCountry(String state) {
        this.state = state;
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
        System.out.println(this.street + " " + this.city + " " + this.state + " " + this.zipCode);
    }
}
