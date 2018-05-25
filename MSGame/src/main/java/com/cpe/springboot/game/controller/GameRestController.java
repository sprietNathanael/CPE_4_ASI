package com.cpe.springboot.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.springboot.game.model.Room;

@RestController
public class GameRestController {
	
	@Autowired
	private RoomService roomService;

	@RequestMapping(path = "/rooms", produces = "application/json")
	private List<Room> getAllRooms() {
		return roomService.getAllRooms();
	}
	
	@RequestMapping(path = "/rooms/{id}", produces = "application/json")
	private Room getRoom(@PathVariable String id) {
		return roomService.getRoom(id);

	}
	
	/** Get the list of room that are waiting for players
	 * 
	 * @return List<Room> result
	 */
	@RequestMapping(path = "/rooms/pending", produces = "application/json")
	private List<Room> getRoomsNotStarted() {
		return roomService.findByState(0);
	}

	/**
	 * Add a player to a pending game
	 * 
	 * @param roomId
	 * @param playerId
	 * @return boolean result
	 */
	@RequestMapping(path = "/rooms/{roomId}/addPlayer/{playerId}")
	private boolean addPlayer(@PathVariable String roomId, @PathVariable int playerId) {
		Room room = roomService.getRoom(roomId);
		
		if (room.addPlayer(playerId)) {
			roomService.updateRoom(room);
			return true;
		} else {
			return false;
		}
		
	}
	
	@RequestMapping(path = "/rooms/{roomId}/removePlayer/{playerId}")
	private boolean removePlayer(@PathVariable String roomId, @PathVariable int playerId) {
		Room room = roomService.getRoom(roomId);
		
		if (room.removePlayer(playerId)) {
			roomService.updateRoom(room);
			return true;
		} else {
			return false;
		}
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/rooms", consumes = "application/json")
	public void addRoom(@RequestBody Room room) {
		roomService.addRoom(room);
		ResponseEntity.ok().build();
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/rooms/{id}", consumes = "application/json")
	public void updateUser(@RequestBody Room room,@PathVariable String id) {
		room.setId(Integer.valueOf(id));
		roomService.updateRoom(room);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/rooms/{id}")
	public void deleteUser(@PathVariable String id) {
		roomService.deleteRoom(id);
	}
}
