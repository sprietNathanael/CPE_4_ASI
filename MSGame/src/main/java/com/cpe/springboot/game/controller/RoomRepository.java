package com.cpe.springboot.game.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpe.springboot.game.model.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	
	public List<Room> findByState(Integer state);
}
