package com.warrantyManagement.warranty_management.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.warrantyManagement.warranty_management.utility.ServiceResult;

@RestController
@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ServiceResult<String> handleNotFoundException(RuntimeException exception) {
		return new ServiceResult<String>
		(HttpStatus.NOT_FOUND.value(), false, exception.getMessage(), null, LocalDateTime.now());
	}
}
