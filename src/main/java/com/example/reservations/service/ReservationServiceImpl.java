package com.example.reservations.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.reservations.dao.IReservationDao;
import com.example.reservations.model.Reservation;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao reservationDao;
	
	@Override
	public List<Reservation> search() {
		// TODO Auto-generated method stub
		return (List<Reservation>) reservationDao.findAll();
	}

}
