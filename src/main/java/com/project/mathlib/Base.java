package com.project.mathlib;

import org.mockito.ArgumentMatchers;

public class Base {
	
	public static final double E = 2.7182;	 //Doðal Logaritmik Taban
	public static final double PI= 3.141592653589793;
	
	public int addition(int a,int b){
		return a+b;
	}
	public int subtraction(int a,int b) {
		return a-b;
	}
	
	public int division(Integer pay,Integer payda) throws Exception{
	if((payda == null || pay == null) || (pay==null && payda ==null)) {
		throw new NullPointerException();
		}
	if(payda ==0) {
		throw new ArithmeticException();
	}
	return pay/payda;
	}
	public int multiplication(int a,int b) {
		return a*b;
	}
}

