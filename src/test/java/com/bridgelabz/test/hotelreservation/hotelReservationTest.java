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
		hotelList.add(new Hotel("Lakewood","Regular",220,400,"08Sep2020" , "14Sep2020",3 ));
		hotelList.add(new Hotel("Lakewood","Regular",200,300,"08Sep2020" , "14Sep2020" ,3));
		hotelList.add(new Hotel("Lakewood","Regular",310,290,"20Aug2020" , "30Aug2020" ,3));
		hotelList.add(new Hotel("Bridgewood","Regular",350,50, "09Sep2020" , "14Sep2020" ,4));
		hotelList.add(new Hotel("Bridgewood","Regular",350,200, "11Jun2020" , "14Jun2020" ,4));
		hotelList.add(new Hotel("Ridgewood","Regular",190,260, "06Sep2020" , "12Sep2020" ,5));
		hotelList.add(new Hotel("Ridgewood","Regular",400,200, "06Dec2020" , "12Dec2020" ,5));
		hotelList.add(new Hotel("Ridgewood","Regular",400,300, "08Dec2020" , "10Dec2020" ,5));
		hotelList.add(new Hotel("Bridgewood","Regular",150,300, "06Dec2020" , "10Dec2020" ,4));
		hotelList.add(new Hotel("Lakewood","Regular",300,500,"08Dec2020" , "14Dec2020" ,3));
		hotelList.add(new Hotel("Ridgewood","Reward",200,150, "05Dec2020" , "10Dec2020" ,5));
		hotelList.add(new Hotel("Ridgewood","Reward",90,100, "04Dec2020" , "10Dec2020" ,5));
		hotelList.add(new Hotel("Bridgewood","Reward",250,500, "06Dec2020" , "10Dec2020" ,4));
		hotelList.add(new Hotel("Lakewood","Reward",110,400,"02Dec2020" , "14Dec2020" ,3));
		
	}
	@Test
	public void start() {
		hotelReserve.welcome();
	}
	
	@Test
	public void givenDates_whenInRange_shouldReturnTrue() throws ParseException {
		Hotel h = hotelReserve.findCheapestHotel("10Sep2020" , "11Sep2020" , hotelList);
		//System.out.println(h.getHotelName() + ", Total Rates: "+ h.getWeekdayRate());
		Assert.assertEquals("Lakewood, Total Rates: 220", h.getHotelName() + ", Total Rates: "+ h.getWeekdayRate() );
	}
	@Test
	public void givenDates_whenNotInRange_shouldReturnFalse() throws ParseException {
		Hotel h = hotelReserve.findCheapestHotel("10Sep2020" , "11Sep2020" , hotelList);
		//System.out.println(h.getHotelName() + ", Total Rates: "+ h.getWeekdayRate() );
		Assert.assertNotEquals("Bridgewood, Total Rates: 320", h.getHotelName() + ", Total Rates: "+ h.getWeekdayRate() );
	}
	
	
	
	@Test
	public void givenDates_whenCheapestInWeekdayAndWeekend_shouldReturnTrue() throws ParseException {
		Hotel h1 = hotelReserve.findCheapestHotelInWeekday("11Sep2020" , "12Sep2020" , hotelList);
		Hotel h2 = hotelReserve.findCheapestHotelInWeekend("11Sep2020" , "12Sep2020" , hotelList);
		Assert.assertEquals("Lakewood : 200", h1.getHotelName() + " : "+ h1.getWeekdayRate() );
		Assert.assertEquals("Bridgewood : 50", h2.getHotelName() + " : "+ h2.getWeekendRate() );
	}
	@Test
	public void givenDates_whenNotCheapestInWeekdayandWeekend_shouldReturnFalse() throws ParseException {
		Hotel h1 = hotelReserve.findCheapestHotelInWeekday("11Sep2020" , "12Sep2020" , hotelList);
		Hotel h2 = hotelReserve.findCheapestHotelInWeekend("11Sep2020" , "12Sep2020" , hotelList);
		Assert.assertNotEquals("Ridgewood, Total Rate: 200", h1.getHotelName() + ", Total Rate: "+ h1.getWeekdayRate() );
		Assert.assertNotEquals("Bridgewood, Total Rate: 200", h2.getHotelName() + ", Total Rate: "+ h2.getWeekendRate() );
	}
	
	
	
	@Test
	public void givenDates_whenCheapestAndBestRated_shouldReturnTrue() throws ParseException {
		Hotel h = hotelReserve.findCheapestBestRatedHotel("08Dec2020" , "09Dec2020" , hotelList);
		Assert.assertEquals("Bridgewood, Rating: 4", h.getHotelName() + ", Rating: "+ h.getRating() );
	}
	@Test
	public void givenDates_whenNotCheapestAndBestRated_shouldReturnFalse() throws ParseException {
		Hotel h = hotelReserve.findCheapestBestRatedHotel("08Dec2020" , "09Dec2020" , hotelList);
		//System.out.println( h.getHotelName() + ", Rating: "+ h.getRating());
		Assert.assertNotEquals("Bridgewood, Rating: 3", h.getHotelName() + ", Rating: "+ h.getRating() );
	}
	
	
	@Test
	public void givenDates_whenBestRated_shouldReturnTrue() throws ParseException {
		Hotel h = hotelReserve.findBestRatedHotel("08Dec2020" , "09Dec2020" , hotelList);
		Assert.assertEquals("Ridgewood, Rating: 5", h.getHotelName() + ", Rating: "+ h.getRating() );
	}
	@Test
	public void givenDates_whenNotBestRated_shouldReturnFalse() throws ParseException {
		Hotel h = hotelReserve.findBestRatedHotel("08Dec2020" , "09Dec2020" , hotelList);
		Assert.assertNotEquals("Bridgewood, Rating: 4", h.getHotelName() + ", Rating: "+ h.getRating() );
	}
	
	@Test
	public void givenDates_whenRewardAndCheapestBestRated_shouldReturnTrue() throws ParseException {
		Hotel h = hotelReserve.findRewardCheapestBestRatedHotel("08Dec2020" , "09Dec2020" , hotelList);
		Assert.assertEquals("Ridgewood, Rating: 5, Rate: 90", h.getHotelName() + ", Rating: "+ h.getRating()+", Rate: "+h.getWeekdayRate() );
	}
	
	@Test
	public void givenDates_whenNotRewardAndCheapestBestRated_shouldReturnFalse() throws ParseException {
		Hotel h = hotelReserve.findRewardCheapestBestRatedHotel("08Dec2020" , "09Dec2020" , hotelList);
		Assert.assertNotEquals("Ridgewood, Rating: 5, Rate: 100", h.getHotelName() + ", Rating: "+ h.getRating()+", Rate: "+h.getWeekdayRate() );
		
	}
	
}
