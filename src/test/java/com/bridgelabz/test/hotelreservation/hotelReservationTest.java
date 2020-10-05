package com.bridgelabz.test.hotelreservation;

import org.junit.Before;
import org.junit.Test;

public class hotelReservationTest {
	hotelReservation hotel = null;
	
	@Before
	public void initialize() {
		hotel = new hotelReservation();
	}
	@Test
	public void start() {
		hotel.welcome();
	}
}
