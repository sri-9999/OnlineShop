package com.online.shop.OnlineShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.online.shop.OnlineShop.model.Flight;
import com.online.shop.OnlineShop.service.FlightService;

import java.util.List;

@RestController
@RequestMapping("/flights")
@CrossOrigin(origins = "*")
public class FlightSearchController {

	@Autowired
	private FlightService flightService;

	// GET all flights
	@GetMapping
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}

	// GET flight by number
	@GetMapping("/{flightNumber}")
	public Flight getFlight(@PathVariable String flightNumber) {
		return flightService.getFlightByNumber(flightNumber);
	}

	// POST add new flight
	@PostMapping
	public Flight addFlight(@RequestBody Flight flight) {
		return flightService.addFlight(flight);
	}

	// PUT update flight
	@PutMapping("/{flightNumber}")
	public Flight updateFlight(@PathVariable String flightNumber, @RequestBody Flight flight) {
		return flightService.updateFlight(flightNumber, flight);
	}

	// DELETE flight
	@DeleteMapping("/{flightNumber}")
	public String deleteFlight(@PathVariable String flightNumber) {
		boolean removed = flightService.deleteFlight(flightNumber);
		return removed ? "Deleted" : "Not Found";
	}

}
