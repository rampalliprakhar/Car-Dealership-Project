/*---------------------------------------------------
 *  Author: Triny Nguyen
 *  Written: 4/22/2023
 *  Last Updated: 4/22/2023
 *  
 *  Compilation: javac EmployeeAutomatedTest.java
 *  Execution: java EmployeeAutomatedTest
 *  
 *  JUnit test for Employee.java
 *---------------------------------------------------*/

package backend;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeAutomatedTest {

	@Test
	void test() {
		
		Employee emp1 = new Employee("Triny", "Nguyen", true, "password");
		
		Employee emp2 = new Employee("John", "Henbirge", false, "HJohn123");

		
		// constructor and getters tests
		assertEquals("Triny",emp1.getFirstName());
		assertEquals("Nguyen",emp1.getLastName());
		assertEquals(true,emp1.hasManagerRights());
		assertEquals("password",emp1.getPassword());
		
		
		// setters and getters tests
		emp1.setFirstName("Trinity");
		assertEquals("Trinity",emp1.getFirstName());
		
		emp1.setLastName("Hunter");
		assertEquals("Hunter",emp1.getLastName());
		
		emp1.setHasManagerRights(false);
		assertEquals(false,emp1.hasManagerRights());
		
		emp1.setPassword("05Hn18s");
		assertEquals("05Hn18s",emp1.getPassword());
				
		emp1.setEmployeeID(7321879);
		assertEquals(7321879,emp1.getEmployeeID());

		
		// constructor and getters tests
		assertEquals("John",emp2.getFirstName());
		assertEquals("Henbirge",emp2.getLastName());
		assertEquals(false,emp2.hasManagerRights());
		assertEquals("HJohn123",emp2.getPassword());
		
		emp2.setEmployeeID(4328789);
		assertEquals(4328789,emp2.getEmployeeID());
		
		emp2.setHasManagerRights(true);
		assertEquals(true,emp2.hasManagerRights());
		
		
	    /* These constants are the ranges for sales commissions.
	     * From below $100,000, the commission is 5%
	     * From $100,000 - $200,000, the commission is 7%
	     * Above $200,000, the commission is %10
	     */

		// commission rate tests
		
		// 0 sales total has 5% commission rate
		assertEquals(.05,emp1.getComPercentage());
		
		// 99,999 sales total has 5% commission rate
		emp1.updateCommission(Double.valueOf(99999));
		assertEquals(.05,emp1.getComPercentage());

		// 100,000 sales total has 7% commission rate
		emp1.updateCommission(Double.valueOf(100000));
		assertEquals(.07,emp1.getComPercentage());

		// 200,000 sales total has 7% commission rate
		emp1.updateCommission(Double.valueOf(200000));
		assertEquals(.07,emp1.getComPercentage());
		
		// 200,001 sales total has 10% commission rate
		emp1.updateCommission(Double.valueOf(200001));
		assertEquals(.1,emp1.getComPercentage());
		
		
		// manual setter of commission percentage
		emp1.setComPercentage(Double.valueOf(.11));
		assertEquals(.11,emp1.getComPercentage());
	
	
	}

}
