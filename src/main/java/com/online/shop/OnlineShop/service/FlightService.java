package com.online.shop.OnlineShop.service;

import org.springframework.stereotype.Service;

import com.online.shop.OnlineShop.model.Flight;

import java.util.*;

@Service
public class FlightService {
	private final List<Flight> flights = new ArrayList<>();

	String[][] cityPairs = { { "New York", "London" }, { "Paris", "Tokyo" }, { "Sydney", "Dubai" },
			{ "San Francisco", "Singapore" }, { "Toronto", "Frankfurt" }, { "Los Angeles", "Hong Kong" },
			{ "Chicago", "Amsterdam" }, { "Delhi", "Bangkok" }, { "Johannesburg", "Istanbul" },
			{ "Madrid", "Rome" } };


	public FlightService() {
		// Initialize with 10 dummy flights using real cities
		for (int i = 0; i < cityPairs.length; i++) {
			flights.add(new Flight("FL" + (i + 1), cityPairs[i][0], cityPairs[i][1],
					"2024-07-" + String.format("%02d", i + 1) + "T08:00",
					"2024-07-" + String.format("%02d", i + 1) + "T16:00", 300 + i * 50));
		}
	}

	public List<Flight> getAllFlights() {
		return flights;
	}

	public Flight getFlightByNumber(String flightNumber) {
		return flights.stream().filter(f -> f.flightNumber.equals(flightNumber)).findFirst().orElse(null);
	}

	public Flight addFlight(Flight flight) {
		flights.add(flight);
		return flight;
	}

	public Flight updateFlight(String flightNumber, Flight updatedFlight) {
		for (int i = 0; i < flights.size(); i++) {
			if (flights.get(i).flightNumber.equals(flightNumber)) {
				flights.set(i, updatedFlight);
				return updatedFlight;
			}
		}
		return null;
	}

	public boolean deleteFlight(String flightNumber) {
		return flights.removeIf(f -> f.flightNumber.equals(flightNumber));
	}
}
