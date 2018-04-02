package com.toDo.toDoApp.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.toDo.toDoApp.ToDoNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler  {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request){
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getLocalizedMessage(),
		        request.getDescription(true));
		    return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);		  		
	}
	
	@ExceptionHandler(ToDoNotFoundException.class)
	  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ToDoNotFoundException ex, WebRequest request) {
	    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	        request.getDescription(false));
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }

}
