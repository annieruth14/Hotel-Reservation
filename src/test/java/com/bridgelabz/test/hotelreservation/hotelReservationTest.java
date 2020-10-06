package com.bridgelabz.test.hotelreservation;

import java.text.SimpleDateFormat;
import java.util.Date;


import org.junit.Before;
import org.junit.Test;

public class hotelReservationTest {
	hotelReservation hotelReserve = null;
	Date date = null;
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
	
	Hotel hotel1 = new Hotel("Lakewood","Regular",110,"11Sep2020" , "11Sep2020" );
	Hotel hotel2 = new Hotel("Lakewood","Reward",80,  "11Sep2020" , "11Sep2020" );
	Hotel hotel3 = new Hotel("Bridgewood","Regular",160, "11Sep2020" , "11Sep2020" );
	Hotel hotel4 = new Hotel("Bridgewood","Reward",110, "11Sep2020" , "11Sep2020" );
	Hotel hotel5 = new Hotel("Ridgewood","Regular",220, "11Sep2020" , "11Sep2020" );
	Hotel hotel6 = new Hotel("Ridgewood","Reward",100, "11Sep2020" , "11Sep2020" );
	
	@Before
	public void initialize() {
		hotelReserve = new hotelReservation();
	}
	@Test
	public void start() {
		hotelReserve.welcome();
	}
}
