/*---------------------------------------------------
 *  Author: J. Alan Wallace, Triny Nguyen
 *  Written: 1/25/2023
 *  Last Updated: 1/25/2023
 *  
 *  Compilation: javac Vehicle.java
 *  Execution: java Vehicle
 *  
 *  The Vehicle class for the car dealership project.
 *  
 *  Sample Output:
 *---------------------------------------------------*/

package classes;
import java.util.Date;
import java.util.ArrayList;

public class Vehicle {
    
    // Data fields
    private Double VIN;
    private Integer year;
    private String make;
    private String model;
    private Integer value;
    private String bodyCondition;
    private String mechCondition; // Mechanical Condition
    private String color;
    private Integer mileage;
    private ArrayList<String> additionalFeatures;
    private Long datePutOnLot;
    
    // This is a list of all possible conditions for bodyCondition and mechCondition
    private final String[] listOfConditions = {"Very Bad/Broken", "Bad", "Average", "Good", "Like New"}; 
    
    public Vehicle() {
        this.year = 1901;
        this.make = "No Make Specified";
        this.model = "No Model Specified";
        this.value = 0;
        this.bodyCondition = "No Body Condition Specified";
        this.mechCondition = "No Mechanical Condition Specified";
        this.color = "No Color Specified";
        this.mileage = 0;
        this.additionalFeatures = new ArrayList<String>();
        this.datePutOnLot = System.currentTimeMillis();
        
        
    } // default constructor
    
    public Vehicle(int value, int year, String make, String model, String bodyCondition, String mechCondition, String color, int mileage, Date DatePutOnLot) {
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
    
    public Double getVIN() {
        return this.VIN;
    }
    
    public boolean setVIN(double vin) {
        this.VIN = vin;
        return true;
    }
    
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
    
    public Integer getValue() {
        return this.value;
    } // end getValue
    
    public boolean setValue(Integer value) {
        if (value > Integer.MAX_VALUE) return false;
        if (value < 0) return false;
        
        this.value = value;
        return true;
    } // end setValue
    
    public String getBodyCondition() {
        return this.bodyCondition;
    } // return getBodyCondition
    
    public boolean setBodyCondition(String bodyCon) {
        for (int count = 0; count < this.listOfConditions.length - 1; count++) {
            if (this.listOfConditions[count].equalsIgnoreCase(bodyCon)) {
                this.bodyCondition = bodyCon;
                return true;
            }
        }
        return false;
    } // end setBodyCondition
    
    public String getMechCondition() { 
        return this.mechCondition;
    } // end getMechCondition
    
    public boolean setMechCondition(String mechCon) {
        for (int count = 0; count < this.listOfConditions.length - 1; count++) {
            if (this.listOfConditions[count].equalsIgnoreCase(mechCon)) {
                this.bodyCondition = mechCon;
                return true;
            }
        }
        return false;
    } // end setMechCondition
    
    public String getColor() {
        return this.color;
    } // end getColor
    
    public boolean setColor(String color) {
        this.color = color;
        return true;
    } // end setColor
    
    public Integer getMileage() {
        return this.mileage;
    } // end getMileage
    
    public boolean setMileage(Integer mileage) {
        if (value > Integer.MAX_VALUE) return false;
        if (value < 0) return false;
        
        this.mileage = mileage;
        return true;
    } // end setMileage
    
    public ArrayList<String> getAdditionalFeatures() {
        return this.additionalFeatures;
    } // end getAdditionalFeatures
    
    public boolean addAdditionalFeatures(String feature) {
        this.additionalFeatures.add(feature);
        return true;
    } // end addAdditionalFeatures
    
    public boolean removeAdditionalFeatures(String feature) {
        if (this.additionalFeatures.contains(feature)) {
            this.additionalFeatures.remove(feature);
            return true;
        }
        else return false;
    } // end removeAdditionalFeatures
    
    public Date getDatePutOnLot() {
        return new Date(this.datePutOnLot);
    } // end getDatePutOnLot
    
    public boolean setDatePutOnLot(Date date) {
        this.datePutOnLot = date.getTime();
        return true;
        } // end setDatePutOnLot
    
    public Date getTimeOnLot() {
        if (this.datePutOnLot >= System.currentTimeMillis()) throw new InvalidTimeOnLotException();
        
        Date timeOnLot = new Date(System.currentTimeMillis() - this.datePutOnLot );
        return timeOnLot;
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
