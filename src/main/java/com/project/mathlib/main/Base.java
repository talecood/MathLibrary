package com.project.mathlib.main;

import com.project.mathlib.exceptions.DivisionToZeroArithmeticException;
import com.project.mathlib.exceptions.NullParameterException;

public class Base {
	
	public static final double E = 2.7182;  // Doðal Logaritmik Taban
	public static final double PI = 3.141592653589793;
	
	private static final String INVALID_PARAMETERS = "Parameter Values Cannot be Invalid.";
	
	public int addition(Integer a, Integer b) {
		if (a == null || b == null) {
            throw new NullParameterException(INVALID_PARAMETERS);
        }
		if (isInvalid(a.doubleValue()) || isInvalid(b.doubleValue())) {
            throw new NullParameterException(INVALID_PARAMETERS);
		}
		return a + b;
	}
	
	public int subtraction(Integer a, Integer b) {
		if (a == null || b == null) {
            throw new NullParameterException(INVALID_PARAMETERS);
        }
		if (isInvalid(a.doubleValue()) || isInvalid(b.doubleValue())) {
            throw new NullParameterException(INVALID_PARAMETERS);
		}
		return a - b;
	}
	
	public int division(Integer pay, Integer payda) {
		if (pay == null || payda == null) {
            throw new NullParameterException(INVALID_PARAMETERS);
        }
        if (isInvalid(pay.doubleValue()) || isInvalid(payda.doubleValue())) {
            throw new NullParameterException(INVALID_PARAMETERS);
        }
		if (payda == 0) {
			throw new DivisionToZeroArithmeticException("Division to Zero is Undefined.");
		}
		return pay / payda;
	}
	
	public int multiplication(Integer a, Integer b) {
		if (a == null || b == null) {
            throw new NullParameterException(INVALID_PARAMETERS);
        }
		if (isInvalid(a.doubleValue()) || isInvalid(b.doubleValue())) {
            throw new NullParameterException(INVALID_PARAMETERS);
		}
		return a * b;
	}
	
	private boolean isInvalid(Double value) {
		return value == null ||
			   value == Double.NaN;
	}
}
