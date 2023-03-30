/*---------------------------------------------------
 *  Author: J. Alan Wallace, Triny Nguyen
 *  Written: 1/25/2023
 *  Last Updated: 3/17/2023
 *  
 *  Compilation: javac Vehicle.java
 *  Execution: java Vehicle
 *  
 *  The Vehicle class for the car dealership project.
 *  
 *  Sample Output:
 *---------------------------------------------------*/

package backend;
import java.util.Date;

public class Vehicle {
    
    // Data fields
    private String VIN;
    private Integer year;
    private String make;
    private String model;
    private Double value;
    private Double discount; // Price = value - discount
    private String bodyCondition;
    private String mechCondition; // Mechanical Condition
    private String color;
    private Double mileage;
    //private ArrayList<String> additionalFeatures;
    private Long datePutOnLot;
    
    // This is a list of all possible conditions for bodyCondition and mechCondition
    private final String[] listOfConditions = {"Very Bad/Broken", "Bad", "Average", "Good", "Like New"};
    
    private final long MILLISECONDS_IN_DAY = 86400000;
    
    public Vehicle() {
        this.VIN = "No VIN Specified";
        this.year = 1901;
        this.make = "No Make Specified";
        this.model = "No Model Specified";
        this.value = 0.0;
        this.discount = 0.0;
        this.bodyCondition = "No Body Condition Specified";
        this.mechCondition = "No Mechanical Condition Specified";
        this.color = "No Color Specified";
        this.mileage = 0.0;
        //this.additionalFeatures = new ArrayList<String>();
        this.datePutOnLot = System.currentTimeMillis();
    } // default constructor
    
    public Vehicle(String VIN, Double value, Integer year, String make, String model, String bodyCondition, String mechCondition, String color, Double mileage, Date DatePutOnLot) {
        this.setVIN(VIN);
        this.setValue(value);
        this.setYear(year);
        this.setMake(make);
        this.setModel(model);
        this.setBodyCondition(bodyCondition);
        this.setMechCondition(mechCondition);
        this.setColor(color);
        this.setMileage(mileage);
        this.setDatePutOnLot(DatePutOnLot);
    } // parameterized constructor
    
    public String getVIN() {
        return this.VIN;
    } // end getVIN
    
    public boolean setVIN(String vin) {
        this.VIN = vin;
        return true;
    } // end setVIN
    
    public Integer getYear() {
        return this.year;
    } // end getYear
    
    public boolean setYear(Integer year) {
        if (year < 2901 && year > 1901) {
            this.year = year;
            return true;
        }
        else return false;
    } // end setYear
    
    public String getMake() {
        return this.make;
    } // end getMake
    
    public boolean setMake (String make) {
        this.make = make;
        return true;
    } // end setMake
    
    public String getModel() {
        return this.model;
    } // end getModel
    
    public boolean setModel(String model) {
        this.model = model;
        return true;
    } // end setModel
    
    public Double getValue() {
        return this.value;
    } // end getValue
    
    public boolean setValue(Double value) {
        if (value > Double.MAX_VALUE || value < Double.MIN_VALUE) return false;
        if (value < 0) return false;
        
        this.value = value;
        return true;
    } // end setValue
    
    public Double getDiscount() {
        return this.discount;
    } // end getDiscount
    
    public void setDiscount(Double dollars) {
        /* This version of the setDiscout method adjusts the discount based on
         * a set dollar discount (e.g. $2000.00)*/
        this.discount = dollars;
    } // end setDiscount(dollar discount)
    
    public void setDiscount(Float percent) {
        /* This version of the setDiscount method adjusts the discount based on
         * a percentage discount (e.g. 33%)*/
        this.discount = this.value - (this.value * percent);
    } // end setDiscount(percent discount)
    
    public Double getPrice() {
        /* The price is the total value minus any discounts.
         * Price is a calculated value, not stored in any data fields.*/
        return this.value - this.discount;
    } // end getPrice
    
    public String getBodyCondition() {
        return this.bodyCondition;
    } // end getBodyCondition
    
    public void setBodyCondition(String bodyCon) {
        this.bodyCondition = bodyCon;
    } // end setBodyCondition
    
    public String getMechCondition() { 
        return this.mechCondition;
    } // end getMechCondition
    
    public void setMechCondition(String mechCon) {
        this.mechCondition = mechCon;
    } // end setMechCondition
    
    public String getColor() {
        return this.color;
    } // end getColor
    
    public boolean setColor(String color) {
        this.color = color;
        return true;
    } // end setColor
    
    public Double getMileage() {
        return this.mileage;
    } // end getMileage
    
    public boolean setMileage(Double mileage) {
        if (value > Double.MAX_VALUE || value < Double.MIN_VALUE) return false;
        if (value < 0) return false;
        
        this.mileage = mileage;
        return true;
    } // end setMileage
    
//    public ArrayList<String> getAdditionalFeatures() {
//        return this.additionalFeatures;
//    } // end getAdditionalFeatures
//    
//    public boolean addAdditionalFeatures(String feature) {
//        this.additionalFeatures.add(feature);
//        return true;
//    } // end addAdditionalFeatures
    
//    public boolean removeAdditionalFeatures(String feature) {
//        if (this.additionalFeatures.contains(feature)) {
//            this.additionalFeatures.remove(feature);
//            return true;
//        }
//        else return false;
//    } // end removeAdditionalFeatures
    
    public Date getDatePutOnLot() {
        return new Date(this.datePutOnLot);
    } // end getDatePutOnLot
    
    public boolean setDatePutOnLot(Date date) {
        this.datePutOnLot = date.getTime();
        return true;
        } // end setDatePutOnLot
    
    public Long getTimeOnLot() {
        /* TimeOnLot is a calculated value, not stored in any data fields.*/
        if (this.datePutOnLot >= System.currentTimeMillis()) throw new InvalidTimeOnLotException();
        
        long timeOnLotInms = System.currentTimeMillis() - this.datePutOnLot;
        long timeOnLotInDays = timeOnLotInms/this.MILLISECONDS_IN_DAY;
        return timeOnLotInDays;
        
//        Date timeOnLot = new Date(System.currentTimeMillis() - this.datePutOnLot );
//        return timeOnLot;
    } // end getTimeOnLot
    
    private class InvalidTimeOnLotException extends RuntimeException {
        /* This exception can be thrown in the getTimeOnLot method.
         * It is usually triggered if the datePutOnLot is either an invalid date
         * or is in the future.*/
        private static final long serialVersionUID = 1L;

        InvalidTimeOnLotException() {
            super("The datePutOnLot is invalid.");
        }
    } // end InvalidTimeOnLotException
} // end Vehicle class
