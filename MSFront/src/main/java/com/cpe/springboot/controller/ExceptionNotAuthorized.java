package com.cpe.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.FORBIDDEN)
public class ExceptionNotAuthorized extends RuntimeException {

}
