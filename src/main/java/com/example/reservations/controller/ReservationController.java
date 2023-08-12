package com.example.reservations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservations.config.ReservationServiceConfiguraction;
import com.example.reservations.model.Reservation;
import com.example.reservations.model.ReservationProperties;
import com.example.reservations.service.IReservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class ReservationController {

	@Autowired
	private IReservationService service;
	
	@Autowired
	private ReservationServiceConfiguraction confReservation;
	
	@GetMapping("reservations")
	public List<Reservation> search(){
		return (List<Reservation>) service.search();
	}
	
	@GetMapping("reservations/read/properties")
	private String getPropertiesReservations() throws JsonProcessingException {
		
		ObjectWriter obj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		ReservationProperties reservationProperties = new ReservationProperties(confReservation.getMsg(), confReservation.getBuildVersion(),
														confReservation.getMailDetails());
		String jsonResponse = obj.writeValueAsString(reservationProperties);
		return jsonResponse;

	}
}
