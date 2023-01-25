import java.util.Date;

public class RecordOfSale {
	
	
	// vehicle info
	private String soldVehicleMake; 
	private Vehicle soldVehicleModel;
	private Vehicle soldVehicleyear;
	private double soldVehiclePrice;	
	private Vehicle soldVehicleVIN;

	private Date salesDate;

	private String paymentMethod;
	
	// customer and salesperson info
	private String customerName;
	private double customerID;
	private double employeeID; 
	private double employeeName;	
	private double commissionValue;
	
	// default constructor
	public RecordOfSale() {
		
	}
	
	// constructor
	public RecordOfSale(String soldVehicleMake, Vehicle soldVehicleModel, Vehicle soldVehicleyear,
			double soldVehiclePrice, Vehicle soldVehicleVIN, Date salesDate, String paymentMethod, String customerName,
			double customerID, double employeeID, double employeeName, double commissionValue) {
		super();
		this.soldVehicleMake = soldVehicleMake;
		this.soldVehicleModel = soldVehicleModel;
		this.soldVehicleyear = soldVehicleyear;
		this.soldVehiclePrice = soldVehiclePrice;
		this.soldVehicleVIN = soldVehicleVIN;
		this.salesDate = salesDate;								// that days date
		this.paymentMethod = paymentMethod;
		this.customerName = customerName;
		this.customerID = customerID;
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.commissionValue = commissionValue;					// should be automatically calculated based off price of vehicle
	}
}
