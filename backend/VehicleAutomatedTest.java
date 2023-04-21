package backend;

import static org.junit.Assert.assertEquals;
import java.util.Date;

import org.junit.jupiter.api.Test;

class VehicleAutomatedTest {

	@Test
	void test() {
		
		
		Date date = new Date();
		
		Vehicle veh = new Vehicle("VIN", 1000.00, 2019, "Nissan" , "Sentra", "new", "new", "gray", 0, date);
		
		// price: 1000
		assertEquals(Double.valueOf(1000),veh.getPrice());
		
		
		// whole number tests
		
		
		// $200 off discount for $1000 vehicle
		veh.setDiscount(200.00);
		
		// new price should be 800
		assertEquals(Double.valueOf(800),veh.getPrice());
		
		// new discount value should be 200
		assertEquals(Double.valueOf(200),veh.getDiscount());
		
		// 30% discount for $1000 vehicle
		veh.setDiscount(.3f);

		// new price should be 700
		assertEquals(Double.valueOf(700),veh.getPrice());
		
		// new discount value should be 300
		assertEquals(Double.valueOf(300),veh.getDiscount());
		
		
		// simple decimal number tests
		
		
		// $342.63 off discount for $1000 vehicle
		veh.setDiscount(342.63);
		
		// new price should be 657.37
		assertEquals(Double.valueOf(657.37),veh.getPrice());
		
		// new discount value should be 342.63
		assertEquals(Double.valueOf(342.63),veh.getDiscount());
		
		// 2.5% discount for $1000 vehicle
		veh.setDiscount(.025f);

		// new price should be 975
		assertEquals(Double.valueOf(975),veh.getPrice());
		
		// new discount value should be 25
		assertEquals(Double.valueOf(25),veh.getDiscount());
		
		
		// long decimal tests
		// rounding up tests
		
		
		// $218.19326321 off discount for $1000 vehicle
		veh.setDiscount(218.19326321);
		
		// new price should be 781.8067368 rounded
		assertEquals(Double.valueOf(781.81),veh.getPrice());
		
		// new discount value should be 218.19
		assertEquals(Double.valueOf(218.19),veh.getDiscount());
		
		// 28.82154294% discount for $1000 vehicle
		veh.setDiscount(.2882144294f);

		// new price should be 711.7845706 rounded
		assertEquals(Double.valueOf(711.79),veh.getPrice());
		
		// new discount value should be 288.21
		assertEquals(Double.valueOf(288.21),veh.getDiscount());
		
		
		// rounding down tests
		
		
		// $ off discount for $1000 vehicle
		veh.setDiscount(54.756);
		
		// new price should be 945.244 rounded
		assertEquals(Double.valueOf(945.24),veh.getPrice());
		
		// new discount value should be 342.63
		assertEquals(Double.valueOf(54.76),veh.getDiscount());
		
		// 38.1608% discount for $1000 vehicle
		veh.setDiscount(.381608f);

		// new price should be 618.392 rounded
		assertEquals(Double.valueOf(618.39),veh.getPrice());
		
		// new discount value should be 288.21
		assertEquals(Double.valueOf(381.61),veh.getDiscount());
		
		
		// full price tests
		
		
		// 100% discount for $1000 vehicle
		veh.setDiscount(1f);

		// new price should be 0
		assertEquals(Double.valueOf(0),veh.getPrice());
		
		// new discount value should be 1000
		assertEquals(Double.valueOf(1000),veh.getDiscount());
		
		// $1000 off discount for $1000 vehicle
		veh.setDiscount(1000.00);
		
		// new price should be 0
		assertEquals(Double.valueOf(0),veh.getPrice());
		
		// new discount value should be 1000
		assertEquals(Double.valueOf(1000),veh.getDiscount());
		
		// 100% discount for $1000 vehicle
		veh.setDiscount(1f);

		assertEquals(Double.valueOf(0),veh.getPrice());
		
		assertEquals(Double.valueOf(1000),veh.getDiscount());
		
		
		// over full price test
		
		
		// $1001 off discount for $1000 vehicle
		veh.setDiscount(1001.00);
		
		assertEquals(Double.valueOf(-1),veh.getPrice());
		
		assertEquals(Double.valueOf(1001),veh.getDiscount());
		
		// 101% discount for $1000 vehicle
		veh.setDiscount(1.01f);

		assertEquals(Double.valueOf(-10),veh.getPrice());
		
		assertEquals(Double.valueOf(1010),veh.getDiscount());

		

	}

}
