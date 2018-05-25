package com.cpe.springboot.game.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpe.springboot.game.model.Game;

public interface GameRepository extends CrudRepository<Game, Integer> {
	
//	public List<User> findByColor(String color);
	public Game findOneBySurnameAndPassword(String surname, String password);
}
