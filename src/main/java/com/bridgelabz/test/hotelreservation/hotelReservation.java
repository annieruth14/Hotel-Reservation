package com.bridgelabz.test.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class hotelReservation {
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");

	public void welcome() {
		System.out.println("Welcome to Hotel Reservation Program");
	}

	public Hotel findCheapestHotel(String startDate, String endDate , List<Hotel> hotels) throws ParseException {
		
		Date start = sdf.parse(startDate);
		Date end = sdf.parse(endDate);
		
		Hotel h = hotels.stream()
				.filter(n -> start.after(n.getStartDate()) && end.before(n.getEndDate()) )
				.findAny()
				.get()
				;				
		 
		 return h;
	}

	public Hotel findCheapestHotelInWeekday(String startDate, String endDate, List<Hotel> hotels)  throws ParseException{
		Date start = sdf.parse(startDate);
		Date end = sdf.parse(endDate);
		Hotel h1 = hotels.stream()
				.filter(n -> start.after(n.getStartDate()) && end.before(n.getEndDate()) )
				.min(Comparator.comparingInt(Hotel::getWeekdayRate))
				.get()
				;
		return h1;
	}
	public Hotel findCheapestHotelInWeekend(String startDate, String endDate, List<Hotel> hotels)  throws ParseException{
		Date start = sdf.parse(startDate);
		Date end = sdf.parse(endDate);
		Hotel h1 = hotels.stream()
				.filter(n -> start.after(n.getStartDate()) && end.before(n.getEndDate()) )
				.min(Comparator.comparingInt(Hotel::getWeekendRate))
				.get()
				;
		return h1;
	}

	public Hotel findCheapestBestRatedHotel(String startDate, String endDate, List<Hotel> hotels)   throws ParseException{
		Hotel h1 = findCheapestHotelInWeekday(startDate,endDate,hotels);
		Hotel h2 = findCheapestHotelInWeekend(startDate,endDate,hotels);
		int min = h1.getWeekdayRate();
		
		if(h2.getWeekdayRate() > min  && h2.getWeekendRate() > min ) 
			return h1;
		else 
			return h2;
		
	}

	
}
