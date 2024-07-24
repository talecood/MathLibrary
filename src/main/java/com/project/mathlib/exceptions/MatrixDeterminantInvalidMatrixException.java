package com.project.mathlib.exceptions;

public class MatrixDeterminantInvalidMatrixException extends IllegalArgumentException{

public MatrixDeterminantInvalidMatrixException() {} 
	
	public MatrixDeterminantInvalidMatrixException(String message) {
		super(message);
	}
}
