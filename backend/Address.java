/* --------------------------------------------------- 
 *  Author: Team 3 Car Dealership
 *  
 *  Written: 1/30/23
 *  Last Updated: 4/17/2023
 *  
 *  Compilation: javac Address.java
 *  Execution: java Address
 *  
 *  Backend class to store customer addresses.
 ---------------------------------------------------*/

package backend;

public class Address {
    
    // Basic data fields
    private String street;
    private String city;
    private String state;
    private String zipCode;
    
    // Fields for special addresses
    private String unit;
    private String building;
    private String addressType;
    
    // The customer that the address belongs to.
    private String customerID;
    
    
    // default constructor
    public Address() {
        this.street = "No Street Specified";
        this.city = "No City Specified";
        this.state = "No State Specified";
        this.zipCode = "No Zip Code Specified";
        this.customerID = "No customerID specified";
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

    // Prints the address out. Useful for debugging
    public void printAddress() {
        System.out.println(this.street + " " + this.city + " " + this.state + " " + this.zipCode);
    }
}
