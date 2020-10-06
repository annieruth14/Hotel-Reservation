package com.bridgelabz.test.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class hotelReservation {
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");

	public void welcome() {
		System.out.println("Welcome to Hotel Reservation Program");
	}

	public String findCheapestHotel(String startDate, String endDate , List<Hotel> hotels) throws ParseException {
		
		Date start = sdf.parse(startDate);
		Date end = sdf.parse(endDate);
		
		String h = hotels.stream()
				.filter(n -> start.after(n.getStartDate()) && end.before(n.getEndDate()) )
				.map(x -> x.getHotelName() + ", Total Rates: " + x.getRate())
				.findFirst()
				.orElse(null)
				;				
		 
		 return h;
	}
	
}
