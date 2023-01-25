import java.util.Date;

public class Vehicle {

	private double VIN;
	private String make;
	private String model;
	private int year;
	private double value;
	private String condition;
	private String color;
	private double mileage; // or int?
	
	private String lotTime;
	private Date lotDate;
	
	private String addFeatures;
	
	
	// default constructor
	public Vehicle() {
		super();
	}

	// constructor
	
	
	public Vehicle(double vIN, String make, String model, int year, double value, String condition, String color,
			double mileage, String lotTime, Date lotDate, String addFeatures) {
		super();
		VIN = vIN;
		this.make = make;
		this.model = model;
		this.year = year;
		this.value = value;
		this.condition = condition;
		this.color = color;
		this.mileage = mileage;
		this.lotTime = lotTime;
		this.lotDate = lotDate;
		this.addFeatures = addFeatures;
	}

	
	
	
	
	
	
	
	
	
	
	// getters and setters
	public double getVIN() {
		return VIN;
	}

	public void setVIN(double VIN) {
		this.VIN = VIN;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getLotTime() {
		return lotTime;
	}

	public void setLotTime(String lotTime) {
		this.lotTime = lotTime;
	}

	public Date getLotDate() {
		return lotDate;
	}

	public void setLotDate(Date lotDate) {
		this.lotDate = lotDate;
	}

	public String getAddFeatures() {
		return addFeatures;
	}

	public void setAddFeatures(String addFeatures) {
		this.addFeatures = addFeatures;
	}
	
	
}
