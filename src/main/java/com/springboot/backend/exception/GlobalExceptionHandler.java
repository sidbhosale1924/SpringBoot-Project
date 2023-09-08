package com.springboot.backend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springboot.backend.payload.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> responseNotFound(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse response = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodsArgsNotValid(MethodArgumentNotValidException ex){
		Map<String,String> resMap = new HashMap<String, String>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String filedName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			resMap.put(filedName, message);
		});
		
		return new ResponseEntity<Map<String,String>>(resMap, HttpStatus.BAD_REQUEST);
	}
	
}
