package com.cpe.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class ExceptionNotFound extends RuntimeException{
	
	public ExceptionNotFound(Exception e) {
		super(e);
	}
	
}
