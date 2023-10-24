package com.example.reservations.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservations.dao.IReservationDao;
import com.example.reservations.model.Reservation;
import com.example.reservations.model.ReservationRoom;
import com.example.reservations.model.Room;
import com.example.reservations.service.client.RoomFeingClient;
import com.google.common.base.Optional;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao reservationDao;
	
	@Autowired
	private RoomFeingClient roomFeingClient;
	
	@Override
	public List<Reservation> search() {
		// TODO Auto-generated method stub
		return (List<Reservation>) reservationDao.findAll();
	}

	@Override
	public List<ReservationRoom> searchReservationWithRoomById(long roomId) {
		
		List<ReservationRoom> reservationsRooms = new ArrayList<>();
		
		List<Reservation> reservations = reservationDao.findByRommId(roomId);
		
		
		Room room = roomFeingClient.searchRoomRelatedRoom(roomId);
		
		reservations.stream().forEach((r) -> {
			ReservationRoom reservationRoom = new ReservationRoom();
			reservationRoom.setReservationId(r.getReservationId());
			reservationRoom.setRommId(r.getRommId());
			reservationRoom.setStartDt(r.getStartDt());
			reservationRoom.setFinishDt(r.getFinishDt());
			
			reservationRoom.setRoom(room);
			reservationsRooms.add(reservationRoom);
		});
		
		
		return reservationsRooms;
	}

	@Override
	public List<ReservationRoom> searchReservationWithOutRoomById(long roomId) {
		List<ReservationRoom> reservationsRooms = new ArrayList<>();
		
		List<Reservation> reservations = reservationDao.findByRommId(roomId);
		
	
		
		reservations.stream().forEach((r) -> {
			ReservationRoom reservationRoom = new ReservationRoom();
			reservationRoom.setReservationId(r.getReservationId());
			reservationRoom.setRommId(r.getRommId());
			reservationRoom.setStartDt(r.getStartDt());
			reservationRoom.setFinishDt(r.getFinishDt());
			
//			reservationRoom.setRoom(null);
			reservationsRooms.add(reservationRoom);
		});
		
		
		return reservationsRooms;
	}

}
