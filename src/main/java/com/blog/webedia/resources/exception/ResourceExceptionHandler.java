package com.blog.webedia.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.blog.webedia.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest quest) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
