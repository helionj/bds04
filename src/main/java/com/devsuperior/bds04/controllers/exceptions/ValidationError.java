package com.devsuperior.bds04.controllers.exceptions;

import java.util.List;
import java.util.ArrayList;

public class ValidationError extends StandardError{


	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	public void addErrors(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}

}
