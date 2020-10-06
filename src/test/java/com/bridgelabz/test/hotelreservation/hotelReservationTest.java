package com.bridgelabz.test.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class hotelReservationTest {
	hotelReservation hotelReserve = new hotelReservation();
	
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
	List<Hotel> hotelList = new ArrayList<>();
	
	@Before
	public void initialize() {
		hotelList.add(new Hotel("Lakewood","Regular",220,"08Sep2020" , "14Sep2020" ));
		hotelList.add(new Hotel("Bridgewood","Regular",160, "11Jun2020" , "14Jun2020" ));
		hotelList.add(new Hotel("Ridgewood","Regular",320, "20Aug2020" , "30Aug2020" ));
		
	}
	@Test
	public void start() {
		hotelReserve.welcome();
	}
	
	@Test
	public void givenDates_whenInRange_shouldReturnTrue() throws ParseException {
		String result = hotelReserve.findCheapestHotel("10Sep2020" , "11Sep2020" , hotelList);
		System.out.println(result);
		Assert.assertEquals("Lakewood, Total Rates: 220", result );
	}
	@Test
	public void givenDates_whenNotInRange_shouldReturnFalse() throws ParseException {
		String result = hotelReserve.findCheapestHotel("10Sep2020" , "11Sep2020" , hotelList);
		Assert.assertNotEquals("Bridgewood, Total Rates: 320", result );
	}
}
