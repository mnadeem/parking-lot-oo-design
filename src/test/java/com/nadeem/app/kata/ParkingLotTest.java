package com.nadeem.app.kata;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ParkingLotTest {

	@Test(expected= IllegalStateException.class)
	public void testCarParkingFull() {
		ParkingLot  lot = new DefaultParkingLot(2, 2, 2);
		lot.park(new Car("1"));
		lot.park(new Car("2"));
		lot.park(new Car("3"));
	
	}

	@Test(expected= IllegalArgumentException.class)
	public void testCarNotParked() {
		ParkingLot  lot = new DefaultParkingLot(2, 2, 2);				
		lot.leave("1");	
	}
	
	@Test
	public void testCarLeave() {
		ParkingLot  lot = new DefaultParkingLot(2, 2, 2);	
		lot.park(new Car("1"));
		Vehicle vehicle = lot.leave("1");
		assertThat(vehicle.getId(), equalTo("1"));
		assertThat(vehicle, is(instanceOf(Car.class)));
	}
	
	
	@Test(expected= IllegalStateException.class)
	public void testTwoWheeleerParkingFull() {
		ParkingLot  lot = new DefaultParkingLot(2, 2, 2);
		lot.park(new TwoWheeler("1"));
		lot.park(new TwoWheeler("2"));
		lot.park(new TwoWheeler("3"));
	
	}

	
	@Test
	public void testTwoWheelerLeave() {
		ParkingLot  lot = new DefaultParkingLot(2, 2, 2);	
		lot.park(new TwoWheeler("1"));
		Vehicle vehicle = lot.leave("1");
		assertThat(vehicle.getId(), equalTo("1"));
		assertThat(vehicle, is(instanceOf(TwoWheeler.class)));
	}
	
	
	@Test(expected= IllegalStateException.class)
	public void testLargeVehicleParkingFull() {
		ParkingLot  lot = new DefaultParkingLot(2, 2, 2);
		lot.park(new Bus("1"));
		lot.park(new Bus("2"));
		lot.park(new Bus("3"));
	
	}

	@Test(expected= IllegalArgumentException.class)
	public void testLargeVehicleNotParked() {
		ParkingLot  lot = new DefaultParkingLot(2, 2, 2);				
		lot.leave("1");	
	}
	
	@Test
	public void testLargeVehicleLeave() {
		ParkingLot  lot = new DefaultParkingLot(2, 2, 2);	
		lot.park(new Bus("1"));
		Vehicle vehicle = lot.leave("1");
		assertThat(vehicle.getId(), equalTo("1"));
		assertThat(vehicle, is(instanceOf(Bus.class)));
	}
}
