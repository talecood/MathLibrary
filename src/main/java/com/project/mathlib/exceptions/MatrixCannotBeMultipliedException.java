package com.project.mathlib.exceptions;

public class MatrixCannotBeMultipliedException extends IllegalArgumentException{

	public MatrixCannotBeMultipliedException() {}
	
	public MatrixCannotBeMultipliedException(String message) {
		super(message);
	}
	
}
