package com.online.shop.OnlineShop.model;

public class Flight {
	
	public String flightNumber;
	public String from;
	public String to;
	public String departure;
	public String arrival;
	public int price;

	public Flight() {
	}

	public Flight(String flightNumber, String from, String to, String departure, String arrival, int price) {
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.departure = departure;
		this.arrival = arrival;
		this.price = price;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", from=" + from + ", to=" + to + ", departure=" + departure
				+ ", arrival=" + arrival + ", price=" + price + "]";
	}

}
