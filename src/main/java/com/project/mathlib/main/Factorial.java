package com.project.mathlib.main;

public class Factorial {
	public int factorial(int a) {
		
		if(a<0) {
			throw new ArithmeticException("Factorial of Negative Numbers Cannot be Calculated");
		}
		
		int i;
		int factorial=1;
		
		if(a==0||a==1)return 1;
		for(i=1;i<=a;i++) {
			factorial *=i;
		}
		return factorial;
	}
}
