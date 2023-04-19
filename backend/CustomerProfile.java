/* --------------------------------------------------- 
 *  Author: Team 3 Car Dealership
 *  Written: 2/15/23
 *  Last Updated: 4/17/2023
 *  
 *  Compilation: javac CustomerProfile.java
 *  Execution: java CustomerProfile
 *  
 *  Backed class to store customers
 ---------------------------------------------------*/

package backend;

public class CustomerProfile {
    
    // Identifying info
    private String licenseNum;
    
    private String firstName;
    private String lastName;
    private String phoneNum;
    
    private Address address;
        
    
    // default constructor
    public CustomerProfile() {
        
    }

    // constructor
    public CustomerProfile(String licenseNum, String firstName, String lastName, String phoneNum, Address address) {

        this.licenseNum = licenseNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;
        
    }
    
    // getters and setters
    
    public String getLicenseNum() {
        return this.licenseNum;
    }
    
    public void setLicenseNum(String licenseNum) {
        this.licenseNum = licenseNum;
    }
    
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

    public String getPhoneNum() {
        return phoneNum;
    }


    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }   
    
    
    // Overrides toString, useful for debugging
    @Override
    public String toString() {
        return this.licenseNum + " " + this.firstName + " " + this.lastName + " " + this.phoneNum;
    }
}
