package com.bridgelabz.test.hotelreservation;

import org.junit.Before;
import org.junit.Test;

public class hotelReservationTest {
	hotelReservation hotel = null;
	
	Hotel hotel1 = new Hotel("Lakewood",90,"Regular");
	Hotel hotel2 = new Hotel("Bridgewood",60,"Regular");
	Hotel hotel3 = new Hotel("Ridgewood",150,"Regular");
	
	@Before
	public void initialize() {
		hotel = new hotelReservation();
	}
	@Test
	public void start() {
		hotel.welcome();
	}
}
