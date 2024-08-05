package com.project.mathlib.exceptions;

@SuppressWarnings("serial")
public class DivisionToZeroArithmeticException extends RuntimeException{
	
	public DivisionToZeroArithmeticException() {}
	
	public DivisionToZeroArithmeticException(String message) {
		
		super(message);
	}
	

}
