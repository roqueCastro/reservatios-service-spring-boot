package com.example.reservations.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.reservations.model.Room;

@FeignClient("rooms")
public interface RoomFeingClient {
	
	@RequestMapping(method = RequestMethod.GET, value = "rooms-one/{id}", consumes = "application/json")
	public Room searchRoomRelatedRoom(@PathVariable long id);

}
