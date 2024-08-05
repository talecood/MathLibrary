package com.project.mathlib.exceptions;

@SuppressWarnings("serial")
public class NullParameterException extends RuntimeException{
	
	public NullParameterException() {}
	
	public NullParameterException(String message) {
		super(message);
	}
}
