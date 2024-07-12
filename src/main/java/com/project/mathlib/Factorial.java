package com.project.mathlib;

public class Factorial {
	public int factorial(int a) {
		int i;
		int factorial=1;
		
		if(a==0||a==1)return 1;
		
		for(i=1;i<=a;i++) {
			factorial *=i;
		}
		return factorial;
	}
}
