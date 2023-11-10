package com.example.reservations.model;

import java.sql.Date;

import lombok.Data;


@Data
public class ReservationRoom {
	
	private long reservationId;
	private long rommId;
	private Date startDt;
	private Date finishDt;
	private Room room;

}
