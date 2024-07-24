package com.project.mathlib.exceptions;

@SuppressWarnings("serial")
public class DivisionToZeroArithmeticException extends ArithmeticException{
	
	public DivisionToZeroArithmeticException() {}
	
	public DivisionToZeroArithmeticException(String message) {
		
		super(message);
	}
	

}
