package com.project.mathlib.exceptions;

public class MatrixsCannotBeSubtractedException extends IllegalArgumentException{

	public MatrixsCannotBeSubtractedException() {}
	
	public MatrixsCannotBeSubtractedException(String message) {
		
		super(message);
	}
}
