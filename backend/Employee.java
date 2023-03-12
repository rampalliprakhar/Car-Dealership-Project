/*---------------------------------------------------
 *  Author: J. Alan Wallace, Triny Nguyen
 *  Written: 3/3/2023
 *  Last Updated: 3/3/2023
 *  
 *  Compilation: javac Employee.java
 *  Execution: java Employee
 *  
 *  The Employee class for the car dealership project.
 *  
 *  Sample Output:
 *---------------------------------------------------*/

package backend;


public class Employee {
        
    private String firstName;
    private String lastName;
    private boolean hasManagerRights;
    
    private Integer employeeID; // This attribute can only be set by Google Database Authentication
    
    private String password;
    
    private Double comPercentage; 
    // Stands for commission percentage, I abbreviated it because it was tough to type, haha
        
    
    /* These constants are the ranges for sales commissions.
     * From $0 - $100,000, the commission is 5%
     * From $100,000 - $200,000, the commission is 3%
     * Above $100,000, the commission is %10
     */
    private static final Integer SALES_RANK_ONE = 100_000;
    private static final Integer SALES_RANK_TWO = 200_000;
    
    private static final Double COM_RANK_ONE = 0.05;
    private static final Double COM_RANK_TWO = 0.07;
    private static final Double COM_RANK_THREE = 0.10;
    
    // default constructor
    public Employee() {
        this.comPercentage = COM_RANK_ONE;
    }
    
    // constructor 
    public Employee(String firstName, String lastName, boolean hasManagerRights, String password) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.hasManagerRights = hasManagerRights;
        this.password = password;
        this.comPercentage = COM_RANK_ONE;

    }
    
    // need an updateCommission method
    
    // getters and setters
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public boolean hasManagerRights() {
        return hasManagerRights;
    }

    public String getPassword() {
        return password;
    }

    public Double getComPercentage() {
        return comPercentage;
    }

    public void setComPercentage(Double comPercentage) {
        this.comPercentage = comPercentage;
    }
    
    
}