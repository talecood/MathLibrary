package com.project.mathlib;

public class Base {
	
	public static final double E = 2.7182;	 //Doðal Logaritmik Taban
	public static final double PI= 3.141592653589793;
	
	public int addition(int a,int b){
		return a+b;
	}
	public int subtraction(int a,int b) {
		return a-b;
	}
	public int division(int pay,int payda) {
		if(payda == 0) {
			System.out.println("Ýþlem Gerçekleþtirilemez.");
			return -1;
		}
		return (pay/payda);
	}
	public int multiplication(int a,int b) {
		return a*b;
	}
}

