package com.example.reservations.model;

import lombok.Data;

@Data
public class Room {
	
	private long roomId;
	private long hotelId;
	private String roomName;
	private String roomAvailable;
	private Hotel hotel;

}