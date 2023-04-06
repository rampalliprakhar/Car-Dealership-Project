package backend;

public class CustomerProfile {
    
    private Long licenseNum;
    
    private String firstName;
    private String lastName;
    private String phoneNum;
    
    private Address address;
        
    
    // default constructor
    public CustomerProfile() {
        
    }

    // constructor
    public CustomerProfile(Long licenseNum, String firstName, String lastName, String phoneNum, Address address) {

        this.licenseNum = licenseNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.address = address;
        
    }
    
    // getters and setters
    
    public Long getLicenseNum() {
        return this.licenseNum;
    }
    
    public void setLicenseNum(Long licenseNum) {
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
    
    @Override
    public String toString() {
        return this.licenseNum + " " + this.firstName + " " + this.lastName + " " + this.phoneNum;
    }
}
