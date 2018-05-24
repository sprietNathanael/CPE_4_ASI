package com.cpe.springboot.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FrontRestController {
	
	RestTemplate restTemplate = new RestTemplate();
	String userServer = "http://localhost:8083/";
	
	@RequestMapping(path = "/users", produces = "application/json")
	private String getAllUsers() {
		String result = restTemplate.getForObject(userServer+"getall", String.class);
		return result;
	}
	
	@RequestMapping(path = "/users/{id}", produces = "application/json")
	private String getUser(@PathVariable String id) {
		String result = restTemplate.getForObject(userServer+"id/"+id, String.class);
		return result;
	}
	
	@RequestMapping(path = "/login", produces = "application/json")
	private String login(String surname, String password) {
		String result = restTemplate.getForObject(userServer+"login/?surname="+surname+"&password="+password, String.class);
		return result;
	}
	
	@RequestMapping(path = "/logout", produces = "application/json")
	private String logout(String id) {
		String result = restTemplate.getForObject(userServer+"logout/?id="+id, String.class);
		return result;
	}
	
	@RequestMapping(path = "/tryToken", produces = "application/json")
	private String tryToken(String id, String token) {
		String result = restTemplate.getForObject(userServer+"tryToken/?id="+id+"&token="+token, String.class);
		return result;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/users", consumes = "application/json")
	public ResponseEntity<?> addUser(@RequestBody String user) {
		HttpHeaders headers = new HttpHeaders();

		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		// Data attached to the request.
		HttpEntity<String> requestBody = new HttpEntity<>(user, headers);
		restTemplate.postForObject(userServer, requestBody, String.class);
		return ResponseEntity.ok().build();
	}
	
	
	@RequestMapping(method=RequestMethod.PUT,value="/users/{id}", consumes = "application/json")
	public void updateUser(@RequestBody String user,@PathVariable String id) {
		HttpHeaders headers = new HttpHeaders();

		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		// Data attached to the request.
		HttpEntity<String> requestBody = new HttpEntity<>(user, headers);
		restTemplate.put(userServer+"id/"+id, requestBody, String.class);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/users/{id}")
	public void deleteUser(@PathVariable String id) {
		restTemplate.delete(userServer+"id/"+id);
	}

}
