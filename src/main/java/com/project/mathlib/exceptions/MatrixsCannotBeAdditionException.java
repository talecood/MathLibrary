package com.project.mathlib.exceptions;

public class MatrixsCannotBeAdditionException extends IllegalArgumentException{

	public MatrixsCannotBeAdditionException() {}
	
	public MatrixsCannotBeAdditionException(String message) {
		super(message);
	}
}
