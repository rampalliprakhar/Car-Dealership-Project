/*---------------------------------------------------
 *  Author: Triny Nguyen
 *  Written: 4/22/2023
 *  Last Updated: 4/22/2023
 *  
 *  Compilation: javac RecordOfSaleAutomatedTest.java
 *  Execution: java RecordOfSaleAutomatedTest
 *  
 *  JUnit test for RecordOfSale.java
 *---------------------------------------------------*/

package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

class RecordOfSaleAutomatedTest {
	
	@Test
	void test() {
		// create date object
		Date date = new Date();
		
		// create address object
		Address address = new Address("502 Manchester Dr.", "Manning", "SC", "29102", "745298640");
		
		// create employee, vehicle, and customer object
		Employee emp = new Employee("Triny", "Nguyen", true, "password");
		Vehicle veh = new Vehicle("VIN", 10000.00, 2019, "Nissan" , "Sentra", "New", "Average", "gray", 89, date);
		CustomerProfile cus = new CustomerProfile("123456789", "John", "Doe", "8039876543", address);
		
		// create record of sale object including the vehicle, employee, and customer
		RecordOfSale record = new RecordOfSale(veh, emp, cus);

		// getters and setters tests
		// current time and date (very precise)
		long millis = System.currentTimeMillis();
		assertEquals(millis,record.getDateOfSale());
		
		// Total Price Tests: whole numbers
		// $10,000 vehicle price + 8% sales tax + dealership fee($200) + tag fee($75)
		assertEquals(Double.valueOf(11075),record.calcTotal());
		
		// total price has to be greater than 50,000 to get coupon
		assertEquals(false,record.isCouponIssued(record.calcTotal()));

		// getters and setters tests
		assertEquals(cus,record.getCustomer());

		assertEquals(veh,record.getSoldVehicle());
		
		assertEquals(emp,record.getEmployee());
		
		// create new employee, vehicle, and customer objects
		Employee emp2 = new Employee("Hunter", "Reverend", false, "hEnd892");
		Vehicle veh2 = new Vehicle("8DN168029H2F4569O", 83517.89, 2012, "Nissan" , "Sentra", "Fair", "Poor", "Purple", 84023, date);
		CustomerProfile cus2 = new CustomerProfile("973427185", "Hill", "Billy", "8039987053", address);
		
		// set record of sales to new employee, vehicle, and customer 
		record.setCustomer(cus2);
		assertEquals(cus2,record.getCustomer());

		record.setSoldVehicle(veh2);
		assertEquals(veh2,record.getSoldVehicle());

		record.setEmployee(emp2);
		assertEquals(emp2,record.getEmployee());
		
		// Total Price Tests: decimal numbers round down
		// $83,517.89 vehicle price + 8% sales tax + dealership fee($200) + tag fee($75) = 90,474.3212 rounded down
		assertEquals(Double.valueOf(90474.32),record.calcTotal());
		
		// total price has to be greater than 50,000 to get coupon
		assertEquals(true,record.isCouponIssued(record.calcTotal()));		
		
		Employee emp3 = new Employee("Alan", "Wallace", false, "JeremyAWal7227");
		Vehicle veh3 = new Vehicle("VIN", 230963.58, 2019, "Nissan" , "Sentra", "New", "Average", "gray", 89, date);
		CustomerProfile cus3 = new CustomerProfile("987654321", "Rich", "Bank", "8037769532", address);
		RecordOfSale record2 = new RecordOfSale(veh3, emp3, cus3);

		// $230,963.58 vehicle price + 8% sales tax + dealership fee($200) + tag fee($75) = 24,9715.666 rounded up
		assertEquals(Double.valueOf(249715.67),record2.calcTotal());
		
		// total price has to be greater than 50,000 to get coupon
		assertEquals(true,record.isCouponIssued(record2.calcTotal()));

		// getters tests
		assertEquals(cus3,record2.getCustomer());

		assertEquals(veh3,record2.getSoldVehicle());
		
		assertEquals(emp3,record2.getEmployee());
		
		// create new vehicle object 
		Vehicle veh4 = new Vehicle("VIN", 46041.6796, 2019, "Nissan" , "Sentra", "New", "Average", "gray", 89, date);

		// set record of sale to new vehicle
		record2.setSoldVehicle(veh4);
		
		// $46,041.6796 vehicle price + 8% sales tax + dealership fee($200) + tag fee($75) = 50,000.014 rounded down
		assertEquals(Double.valueOf(50000.01),record2.calcTotal());
		
		// total price has to be greater than 50,000 to get coupon
		assertEquals(true,record.isCouponIssued(record2.calcTotal()));
	}

}
