package com.example.reservations.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.reservations.model.Reservation;

public interface IReservationDao extends CrudRepository<Reservation, Long> {
	public List<Reservation> findByRommId(long roomId);
}
