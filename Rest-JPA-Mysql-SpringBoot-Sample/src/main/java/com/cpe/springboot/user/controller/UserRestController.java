package com.cpe.springboot.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping("/users")
	private List<User> getAllCourses() {
		return userService.getAllUsers();
	}
	
	@RequestMapping("/users/{id}")
	private User getUser(@PathVariable String id) {
		return userService.getUser(id);

	}
	
	@RequestMapping("/login")
	private boolean login(String surname, String password) {
		List<User> listuser = userService.getAllUsers();
		boolean ret = false;
		for(User user : listuser)
		{
			if(user.getSurname().equals(surname) && user.getPassword().equals(password))
			{
				ret = true;
			}
		}
		return ret;		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}")
	public void updateUser(@RequestBody User user,@PathVariable String id) {
		user.setId(Integer.valueOf(id));
		userService.updateUser(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}
/*	
	@RequestMapping("/users/color/{color}")
	private List<User> getAllCourses(@PathVariable String color) {
		return userService.getUserByColor(color);

	}
	*/

}
