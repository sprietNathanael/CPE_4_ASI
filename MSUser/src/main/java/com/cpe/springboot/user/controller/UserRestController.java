package com.cpe.springboot.user.controller;

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

import com.cpe.springboot.user.model.User;

@RestController
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path = "/users", produces = "application/json")
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(path = "/users/{id}", produces = "application/json")
	private User getUser(@PathVariable String id) {
		return userService.getUser(id);

	}
	
	@RequestMapping(path = "/users/login", produces = "application/json")
	private User login(String surname, String password) {
		User user = userService.findOneBySurnameAndPassword(surname, password);
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
		List<User> listuser = userService.getAllUsers();
		boolean ret = false;
		for(User user : listuser)
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
	private User tryToken(String id, String token) {
		List<User> listuser = userService.getAllUsers();
		User ret = null;
		for(User user : listuser)
		{
			if(user.getId().toString().equals(id) && (user.getToken() != null && user.getToken().equals(token)))
			{
				ret = user;
			}
		}
		return ret;		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users", consumes = "application/json")
	public ResponseEntity<?>  addUser(@RequestBody User user) {
		userService.addUser(user);
		ResponseEntity<?> res = ResponseEntity.ok().build();
		return res;
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}", consumes = "application/json")
	public void updateUser(@RequestBody User user,@PathVariable String id) {
		user.setId(Integer.valueOf(id));
		userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}

}
