package com.project.mathlib.main;

import com.project.mathlib.exceptions.DivisionToZeroArithmeticException;
import com.project.mathlib.exceptions.NullParameterException;

public class Base {
	
	public static final double E = 2.7182;	 //Doðal Logaritmik Taban
	public static final double PI= 3.141592653589793;
	
	public int addition(int a,int b){
		return a+b;
	}
	public int subtraction(int a,int b) {
		return a-b;
	}
	
	public int division(Integer pay,Integer payda){
	if((payda == null || pay == null)) {
		throw new NullParameterException("Parameter Values Cannot be Null");
		}
	if(payda ==0) {
		throw new DivisionToZeroArithmeticException("Division to Zero is Undefined.");
	}
	return pay/payda;
	}
	public int multiplication(int a,int b) {
		return a*b;
	}
}

