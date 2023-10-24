package com.example.reservations.service;

import java.util.List;

import com.example.reservations.model.Reservation;
import com.example.reservations.model.ReservationRoom;

public interface IReservationService  {
	List<Reservation> search();
	List<ReservationRoom> searchReservationWithRoomById(long roomId);
	List<ReservationRoom> searchReservationWithOutRoomById(long roomId);
}
