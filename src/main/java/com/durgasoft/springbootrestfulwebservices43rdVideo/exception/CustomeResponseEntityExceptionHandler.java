package com.durgasoft.springbootrestfulwebservices43rdVideo.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.durgasoft.springbootrestfulwebservices43rdVideo.controller.EmployeeNotFoundException;
import com.durgasoft.springbootrestfulwebservices43rdVideo.response.EmployeeResponse;

@ControllerAdvice // I want to apply this controller to all other controllers
@RestController //when ever we are getting exception we have to call this call,so that's why we are using @RestController
public class CustomeResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		EmployeeResponse employeeResponse = new EmployeeResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
	   return new ResponseEntity(employeeResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<Object> handleEmployeeNotFoundException(Exception ex, WebRequest request) throws Exception {
		
		EmployeeResponse employeeResponse = new EmployeeResponse(new Date(),ex.getMessage(),request.getDescription(false));
		
	   return new ResponseEntity(employeeResponse,HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		
		List<String> errors= new ArrayList<String>();
		List<FieldError>  fieldErrors = ex.getBindingResult().getFieldErrors();
		
		for(FieldError fieldError :fieldErrors) {
			errors.add(fieldError.getDefaultMessage());
		}
		
		Map<String,Object> body = new LinkedHashMap<String,Object>();
		body.put("timestamp", new Date());
		body.put("status", status.value());
		body.put("errors", errors);

		return new ResponseEntity<>(body,headers,status);
	}

	
	

}
