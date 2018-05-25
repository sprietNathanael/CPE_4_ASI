package com.cpe.springboot.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.springboot.game.model.Room;

@RestController
public class GameRestController {
	
	@Autowired
	private RoomService roomService;

	
	@RequestMapping(method=RequestMethod.POST,value="/rooms", consumes = "application/json")
	public ResponseEntity<?>  addRoom(@RequestBody Room room) {
		roomService.addRoom(room);
		ResponseEntity<?> res = ResponseEntity.ok().build();
		return res;
	}
	/*
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}", consumes = "application/json")
	public void updateUser(@RequestBody User user,@PathVariable String id) {
		user.setId(Integer.valueOf(id));
		userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}*/
}
