package com.cpe.springboot.game.controller;

import java.util.List;

import static org.mockito.Matchers.booleanThat;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.springboot.game.model.Game;

@RestController
public class GameRestController {
	
	@Autowired
	private GameService userService;
	
	@RequestMapping(path = "/users", produces = "application/json")
	private List<Game> getAllCourses() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(path = "/users/{id}", produces = "application/json")
	private Game getUser(@PathVariable String id) {
		return userService.getUser(id);

	}
	
	@RequestMapping(path = "/users/login", produces = "application/json")
	private Game login(String surname, String password) {
		Game user = userService.findOneBySurnameAndPassword(surname, password);
		String token = null;
		
		if(user != null) {
			SecureRandom random = new SecureRandom();
			long longToken = Math.abs( random.nextLong() );
			token = Long.toString( longToken, 16 );
			user.setToken(token);
			userService.updateUser(user);
		}
		
		return user;		
	}
	
	@RequestMapping(path = "/users/logout", produces = "application/json")
	private boolean logout(String id) {
		List<Game> listuser = userService.getAllUsers();
		boolean ret = false;
		for(Game user : listuser)
		{
			if(user.getId().toString().equals(id))
			{
				user.setToken(null);
				userService.updateUser(user);
				ret = true;
			}
		}
		return ret;		
	}
	
	@RequestMapping(path = "/users/tryToken", produces = "application/json")
	private boolean tryToken(String id, String token) {
		List<Game> listuser = userService.getAllUsers();
		boolean ret = false;
		for(Game user : listuser)
		{
			if(user.getId().toString().equals(id) && (user.getToken() != null && user.getToken().equals(token)))
			{
				System.out.println("TEST");
				ret = true;
			}
		}
		return ret;		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users", consumes = "application/json")
	public ResponseEntity<?>  addUser(@RequestBody Game user) {
		userService.addUser(user);
		ResponseEntity<?> res = ResponseEntity.ok().build();
		return res;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}", consumes = "application/json")
	public void updateUser(@RequestBody Game user,@PathVariable String id) {
		user.setId(Integer.valueOf(id));
		userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}

}
