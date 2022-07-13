package com.victor.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class Errors {
	
	public Errors(List<ObjectError> erros) {
		
		error = new ArrayList<>();
		
		for (ObjectError object : erros) {
		    if(object instanceof FieldError) {
		        FieldError fieldError = (FieldError) object;

		        error.add(fieldError.getDefaultMessage()+" field "+fieldError.getField());
		    }

		}
	}
	
	private List<String> error;

	public List<String> getError() {
		return error;
	}

	public void setError(List<String> errors) {
		this.error = errors;
	}

}
