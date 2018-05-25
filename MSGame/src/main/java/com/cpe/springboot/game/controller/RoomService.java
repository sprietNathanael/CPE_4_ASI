package com.cpe.springboot.game.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.springboot.game.model.Room;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	public List<Room> getAllRooms() {
		List<Room> rooms = new ArrayList<>();
		roomRepository.findAll().forEach(rooms::add);
		return rooms;
	}

	public Room getRoom(String id) {
		return roomRepository.findOne(Integer.valueOf(id));
	}

	public void addRoom(Room room) {
		roomRepository.save(room);
	}

	public void updateRoom(Room room) {
		roomRepository.save(room);

	}

	public void deleteRoom(String id) {
		roomRepository.delete(Integer.valueOf(id));
	}

}
