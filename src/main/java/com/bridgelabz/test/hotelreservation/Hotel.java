package com.bridgelabz.test.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hotel {
	
	public Date startDate ;	
	public Date endDate;
	
	public String hotelName;
	public int rate;
	public String customerType;
	public String date1;
	SimpleDateFormat sdf = new SimpleDateFormat("ddMMMyyyy");
	
	public Hotel(String hotelName, String customerType, int rate, String startDate, String endDate) {
		this.hotelName=hotelName;
		this.rate=rate;
		this.customerType= customerType;
		try {
			this.startDate= sdf.parse(startDate);
			this.endDate=sdf.parse(endDate);
		} catch (ParseException e) {
			System.out.println("Exception found ");
		}
		
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
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	
}
