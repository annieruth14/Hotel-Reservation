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
		hotelList.add(new Hotel("Lakewood","Regular",110,90,"20Aug2020" , "30Aug2020" ));
		hotelList.add(new Hotel("Bridgewood","Regular",150,50, "11Jun2020" , "14Jun2020" ));
		hotelList.add(new Hotel("Ridgewood","Regular",220,150, "08Sep2020" , "14Sep2020" ));
		
	}
	@Test
	public void start() {
		hotelReserve.welcome();
	}
	
	@Test
	public void givenDates_whenInRange_shouldReturnTrue() throws ParseException {
		Hotel h = hotelReserve.findCheapestHotel("10Sep2020" , "11Sep2020" , hotelList);
		System.out.println(h.getHotelName() + ", Total Rates: "+ h.getWeekdayRate());
		Assert.assertEquals("Ridgewood, Total Rates: 220", h.getHotelName() + ", Total Rates: "+ h.getWeekdayRate() );
	}
	@Test
	public void givenDates_whenNotInRange_shouldReturnFalse() throws ParseException {
		Hotel h = hotelReserve.findCheapestHotel("10Sep2020" , "11Sep2020" , hotelList);
		System.out.println(h.getHotelName() + ", Total Rates: "+ h.getWeekdayRate() );
		Assert.assertNotEquals("Bridgewood, Total Rates: 320", h.getHotelName() + ", Total Rates: "+ h.getWeekdayRate() );
	}
}
