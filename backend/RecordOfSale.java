package backend;

public class RecordOfSale {
    
    private Vehicle soldVehicle;
    private Long dateOfSale;
    
    private Employee employee;
    private CustomerProfile customer;
    
    private Double total; // The total of the transaction
    private boolean isCouponIssued; // If a coupon for free car wash was issued
    
    /* These constants represent:
     * The flat dealership fee of $200
     * The going sales tax rate of 8%
     * The flat tag fee of $75
     */
    private static final Double DEALERSHIP_FEE = 200.00;
    private static final Double SALES_TAX_RATE = 0.08;
    private static final Double TAG_FEE = 75.00;
 
    
    // default constructor
    public RecordOfSale() {
        
    }
    
    // constructor
    public RecordOfSale(Vehicle soldVehicle, Employee employee, CustomerProfile customer) {
        
        this.soldVehicle = soldVehicle;
        this.employee = employee;
        this.customer = customer;
        this.dateOfSale = System.currentTimeMillis();
        this.total = calcTotal();
        this.isCouponIssued = isCouponIssued(this.total);
        
    } // end constructor
    
    public Double calcTotal() {
        
        Double total = 0.0;
        total = total + soldVehicle.getValue(); // Add the cost of the vehicle
        total = total + (soldVehicle.getValue() * SALES_TAX_RATE); // Add sales tax
        total = total + DEALERSHIP_FEE + TAG_FEE; // Add flat fees
        
        return total;
        
    } // end calcTotal
    
    public boolean isCouponIssued(Double total) {
        /* If the total of the purchase is over $50,000
         * returns true (the coupon is issued). Else returns
         * false (the coupon is not issued).*/
        
        if (total > 50_000.00) {
            return true;
        } else {
            return false;
        }
        
    } // end isCouponIssued
    

    public Vehicle getSoldVehicle() {
        return soldVehicle;
    }

    public void setSoldVehicle(Vehicle soldVehicle) {
        this.soldVehicle = soldVehicle;
    }

    public Long getDateOfSale() {
        return dateOfSale;
    }

    // No setter for dateOfSale
    
    public CustomerProfile getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    
}