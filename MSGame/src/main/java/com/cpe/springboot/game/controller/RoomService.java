package com.cpe.springboot.game.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.springboot.game.model.Game;

@Service
public class GameService {

	@Autowired
	private GameRepository userRepository;

	public List<Game> getAllUsers() {
		List<Game> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public Game getUser(String id) {
		return userRepository.findOne(Integer.valueOf(id));
	}

	public void addUser(Game user) {
		userRepository.save(user);
	}

	public void updateUser(Game user) {
		userRepository.save(user);

	}

	public void deleteUser(String id) {
		userRepository.delete(Integer.valueOf(id));
	}
	
	public Game findOneBySurnameAndPassword(String surname, String password){
		return userRepository.findOneBySurnameAndPassword(surname, password);
	}

}
