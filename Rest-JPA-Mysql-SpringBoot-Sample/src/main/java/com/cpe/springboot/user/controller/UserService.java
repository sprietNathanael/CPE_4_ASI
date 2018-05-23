package com.cpe.springboot.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.springboot.user.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	public User getUser(String id) {
		return userRepository.findOne(Integer.valueOf(id));
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void updateUser(User user) {
		userRepository.save(user);

	}

	public void deleteUser(String id) {
		userRepository.delete(Integer.valueOf(id));
	}
	
	public User findOneBySurnameAndPassword(String surname, String password){
		return userRepository.findOneBySurnameAndPassword(surname, password);
	}
/*
	public List<User> getUserByColor(String color) {
		return userRepository.findByColor(color);
	}
*/
}
