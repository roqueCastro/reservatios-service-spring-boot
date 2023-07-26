package com.example.reservations.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.reservations.model.Reservation;

public interface IReservationDao extends CrudRepository<Reservation, Long> {

}
