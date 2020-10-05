package com.bridgelabz.test.hotelreservation;

public class Hotel {
	public String hotelName;
	public int rate;
	public String customerType;
	
	public Hotel(String hotelName, int rate, String customerType) {
		this.hotelName=hotelName;
		this.rate=rate;
		this.customerType= customerType;
	}
	
	public String getCustomerType() {
		return customerType;
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
