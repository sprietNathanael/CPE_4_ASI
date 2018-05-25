package com.cpe.springboot.game.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpe.springboot.game.model.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	
//	public List<User> findByColor(String color);
//  public Game findOneBySurnameAndPassword(String surname, String password);
}
