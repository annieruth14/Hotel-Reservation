package com.bridgelabz.test.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class hotelReservation {
	// Initializing date format
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
	Calendar calStart = Calendar.getInstance();
	Calendar calEnd = Calendar.getInstance();

	// Printing welcome message
	public void welcome() {
		System.out.println("Welcome to Hotel Reservation Program");
	}

	// Find cheapest Hotel in Weekday
	public Hotel findCheapestHotelInWeekday(String startDate, String endDate, List<Hotel> hotels)
			throws ParseException {
		Date start = sdf.parse(startDate);
		calStart.setTime(start);
		Date end = sdf.parse(endDate);
		calStart.setTime(end);
		List<Hotel> list = hotels.stream().filter(n -> start.after(n.getStartDate()) && end.before(n.getEndDate()))
				.collect(Collectors.toList());
		Hotel h1 = list.stream()
				.filter(m -> calStart.get(Calendar.DAY_OF_WEEK) != 1 && calStart.get(Calendar.DAY_OF_WEEK) != 7)
				.min(Comparator.comparingInt(Hotel::getWeekdayRate)).get();
		return h1;
	}

	// Find cheapest Hotel in Weekend
	public Hotel findCheapestHotelInWeekend(String startDate, String endDate, List<Hotel> hotels)
			throws ParseException {
		Date start = sdf.parse(startDate);
		Date end = sdf.parse(endDate);
		Hotel h1 = hotels.stream().filter(n -> start.after(n.getStartDate()) && end.before(n.getEndDate()))
				.min(Comparator.comparingInt(Hotel::getWeekendRate)).get();
		return h1;
	}

	// Find cheapest best rated Hotel
	public Hotel findCheapestBestRatedHotel(String startDate, String endDate, List<Hotel> hotels)
			throws ParseException {
		Hotel h1 = findCheapestHotelInWeekday(startDate, endDate, hotels);
		Hotel h2 = findCheapestHotelInWeekend(startDate, endDate, hotels);
		if (h1.getWeekdayRate() > h2.getWeekendRate())
			return h2;
		else
			return h1;

	}

	// Find best rated hotel
	public Hotel findBestRatedHotel(String startDate, String endDate, List<Hotel> hotels) throws ParseException {
		Date start = sdf.parse(startDate);
		Date end = sdf.parse(endDate);
		Hotel h1 = hotels.stream().filter(n -> start.after(n.getStartDate()) && end.before(n.getEndDate()))
				.max(Comparator.comparingInt(Hotel::getRating)).get();
		return h1;
	}

	// Find Reward cheapest best rated hotel
	public Hotel findRewardCheapestBestRatedHotel(String startDate, String endDate, List<Hotel> hotels)
			throws ParseException {
		List<Hotel> list = hotels.stream().filter(n -> n.getCustomerType().equals("Reward"))
				.collect(Collectors.toList());
		Hotel h1 = findCheapestBestRatedHotel(startDate, endDate, list);
		return h1;
	}

}
