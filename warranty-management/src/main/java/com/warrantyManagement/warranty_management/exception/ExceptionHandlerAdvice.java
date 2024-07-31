package com.warrantyManagement.warranty_management.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.warrantyManagement.warranty_management.utility.CustomResponse;

@RestController
@ControllerAdvice
public class ExceptionHandlerAdvice {
	@ExceptionHandler(value = GeneralException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomResponse<String> handleGeneralException(RuntimeException exception){
		return new CustomResponse<String>
		(false, HttpStatus.BAD_REQUEST.value(), exception.getMessage(), null, LocalDateTime.now());
	}
	
	@ExceptionHandler(value = ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CustomResponse<String> handleNotFoundException(RuntimeException exception) {
		return new CustomResponse<String>
		(false, HttpStatus.NOT_FOUND.value(), exception.getMessage(), null, LocalDateTime.now());
	}
	
	@ExceptionHandler(value = EmptyValueException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomResponse<String> handleEmptyValueException(RuntimeException exception){
		return new CustomResponse<String>
		(false, HttpStatus.BAD_REQUEST.value(), exception.getMessage(), null, LocalDateTime.now());
	}
	
	@ExceptionHandler(value = DateTimeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomResponse<String> handleDateTimeException(RuntimeException exception){
		return new CustomResponse<String>
		(false, HttpStatus.BAD_REQUEST.value(), exception.getMessage(), null, LocalDateTime.now());
	}
	
	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public CustomResponse<String> handleMessageNotReadableException(RuntimeException exception){
		return new CustomResponse<String>
		(false, HttpStatus.BAD_REQUEST.value(), "Invalid request!", null, LocalDateTime.now());
	}
	
}
