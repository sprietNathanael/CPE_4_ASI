package com.cpe.springboot.controller;


import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerMapping;

@RestController
public class FrontRestController {
	
	private RestTemplate restTemplate = new RestTemplate();
	private final String USER_SERVER = "http://localhost:8083";
	private final String GAME_SERVER = "http://localhost:8082";
	private final String CARD_SERVER = "http://localhost:8081";
	
	@RequestMapping(path = "/users/**", produces = "application/json")
	private String userRoute(@RequestBody(required = false) String body, @RequestParam(required = false) Map<String,String> parameters,  HttpServletRequest request)
	{
		return reverseProxy(body, parameters, request, USER_SERVER);
	}
	
	@RequestMapping(path = "/games/**", produces = "application/json")
	private String gameRoute(@RequestBody(required = false) String body, @RequestParam(required = false) Map<String,String> parameters,  HttpServletRequest request)
	{
		return reverseProxy(body, parameters, request, GAME_SERVER);
	}
	
	@RequestMapping(path = "/cards/**", produces = "application/json")
	private String cardRoute(@RequestBody(required = false) String body, @RequestParam(required = false) Map<String,String> parameters,  HttpServletRequest request)
	{
		return reverseProxy(body, parameters, request, CARD_SERVER);
	}
	
	private String reverseProxy(String body, Map<String,String> parameters,  HttpServletRequest request, String server) {
		String result = null;
		String url = (String)(request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE));
		RequestMethod type = RequestMethod.valueOf(request.getMethod());
		if(!url.equals("/users/login") && !url.equals("/users/tryToken"))
		{
			if(!tryToken(parameters.get("id"), parameters.get("token")))
			{
				throw new ExceptionNotAuthorized();				
			}
		}
		
		if(body == null)
		{
			body = "";
		}
		
		String requestParameters = "?";
		long i = 0;
		Iterator<Map.Entry<String, String>> it = parameters.entrySet().iterator();
		while (it.hasNext())
		{
			Map.Entry<String, String> parameter = it.next();
			requestParameters += parameter.getKey() + "=" + parameter.getValue();
		    if(it.hasNext())
		    {
		    	requestParameters += "&";
		    }
		}
		
		HttpHeaders headers = new HttpHeaders();

		headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		// Data attached to the request.
		HttpEntity<String> requestBody = new HttpEntity<>(body, headers);
		
		switch(type)
		{
			case GET:
				try
				{
					result = restTemplate.getForObject(server+url+requestParameters, String.class);
				}
				catch(RestClientException e)
				{
					throw new ExceptionNotFound(e);
				}
				break;
			case POST:
				restTemplate.postForObject(server+url+requestParameters, requestBody, String.class);
				result = ResponseEntity.ok().build().toString();
				break;
			case PUT:
				restTemplate.put(server+url+requestParameters, requestBody, String.class);
				result = ResponseEntity.ok().build().toString();
				break;
			case DELETE:
				restTemplate.delete(server+url+requestParameters, requestBody, String.class);
				result = ResponseEntity.ok().build().toString();
				break;
			default:
				throw new HTTPException(404);
		}
		return result;
		
	}
	
	private boolean tryToken(String id, String token)
	{
		String result = restTemplate.getForObject(USER_SERVER+"/users/tryToken?id="+id+"&token="+token, String.class);
		return Boolean.valueOf(result);
	}
	
}
