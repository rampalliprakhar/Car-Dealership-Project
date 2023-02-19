package application;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.time.LocalDate;

public class CustomerProfile {
    private String firstName;
    private String lastName;
    private int customerID;
    private String phoneNum;
    private LocalDate birthDate;
    
    private Address address; // customer can have multiple
        
    private static Set<Integer> set = new HashSet<Integer>();           

    
    // default constructor
    public CustomerProfile() {
        
    }


    // constructor
    public CustomerProfile(String firstName, String lastName, String phoneNum, LocalDate birthDate,
            Address address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.birthDate = birthDate;
        this.address = address;
        
        this.customerID = id(); 
    }
    public int id() {
        Random rand = new Random();         
        
        int num = rand.nextInt(10000);
        
        while (set.contains(num)) {
            num = rand.nextInt(10000);
        }
        
            set.add(num);
            return num;
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


    public int getCustomerID() {
        return customerID;
    }
    
    /* Note there is not a setter method for CustomerID
     * because the user would never be able to set it manually.*/

    public String getPhoneNum() {
        return phoneNum;
    }


    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }


    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public Address getAddress() {
        return address;
    }


    public void setAddress(Address address) {
        this.address = address;
    }   
}
