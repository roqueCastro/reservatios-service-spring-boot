package com.example.reservations.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.reservations.config.ReservationServiceConfiguraction;
import com.example.reservations.model.Reservation;
import com.example.reservations.model.ReservationProperties;
import com.example.reservations.model.ReservationRoom;
import com.example.reservations.service.IReservationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class ReservationController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private IReservationService service;
	
	@Autowired
	private ReservationServiceConfiguraction confReservation;
	
	@GetMapping("reservations")
	public List<Reservation> search(){
		logger.info("Inicio del métdodo search");
		return (List<Reservation>) service.search();
	}
	
	@GetMapping("reservations-with-rooms/{id}")
	@Retry(name = "searchReservationWithRoomByIdSupportRetry", fallbackMethod = "searchReservationWithRoomByIdAlternative")
	public List<ReservationRoom> searchReservationWithRoomById(@PathVariable long id){
		logger.info("Inicio del métdodo searchReservationWithRoomById");
		return service.searchReservationWithRoomById(id);
	}
	
	public List<ReservationRoom> searchReservationWithRoomByIdAlternative(@PathVariable long id){
		logger.info("Inicio del métdodo searchReservationWithRoomByIdAlternative");
		return service.searchReservationWithOutRoomById(id);
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
