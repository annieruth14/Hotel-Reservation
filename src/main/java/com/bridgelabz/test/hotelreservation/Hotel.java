package com.bridgelabz.test.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hotel {
	
	public Date startDate ;	
	public Date endDate;
	
	public String hotelName;
	public int weekdayRate;
	public int weekendRate;
	public String customerType;
	public int rating;
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
	
	public Hotel(String hotelName, String customerType, int weekdayRate , int weekendRate , String startDate, String endDate, int rating) {
		this.hotelName=hotelName;
		this.weekendRate = weekendRate;
		this.weekdayRate = weekdayRate;
		this.customerType= customerType;
		this.rating=rating;
		try {
			this.startDate= sdf.parse(startDate);
			this.endDate=sdf.parse(endDate);
		} catch (ParseException e) {
			System.out.println("Exception found ");
		}
		
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getWeekdayRate() {
		return weekdayRate;
	}

	public void setWeekdayRate(int weekdayRate) {
		this.weekdayRate = weekdayRate;
	}

	public int getWeekendRate() {
		return weekendRate;
	}

	public void setWeekendRate(int weekendRate) {
		this.weekendRate = weekendRate;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
}
