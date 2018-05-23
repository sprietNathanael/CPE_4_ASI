package com.cpe.springboot.user.controller;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cpe.springboot.user.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
//	public List<User> findByColor(String color);
	public User findOneBySurnameAndPassword(String surname, String password);
}
