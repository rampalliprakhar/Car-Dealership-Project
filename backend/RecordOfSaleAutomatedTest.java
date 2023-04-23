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
		Date date = new Date();
		Address address = new Address("502 Manchester Dr.", "Manning", "SC", "29102", "745298640");
		Employee emp = new Employee("Triny", "Nguyen", true, "password");
		Vehicle veh = new Vehicle("VIN", 10000.00, 2019, "Nissan" , "Sentra", "new", "average", "gray", 89, date);
		CustomerProfile cus = new CustomerProfile("123456789", "John", "Doe", "8039876543", address);
		RecordOfSale record = new RecordOfSale(veh, emp, cus);
		
		// $10,000 vehicle price + 8% sales tax + dealership fee($200) + tag fee($75)
		assertEquals(Double.valueOf(11075),record.calcTotal());
		
		// total price has to be greater than 50,000 to get coupon
		assertEquals(false,record.isCouponIssued(record.calcTotal()));
		
//		assertEquals(false,record.getCustomer());
//
//		assertEquals(false,record.getSoldVehicle());
		
		
		// set
		
		// get
		
		
		// new with coupon

		


	}

}
