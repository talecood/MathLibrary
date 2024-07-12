package com.project.mathlib;

public class Power {
	public int power(int base,int exponent) {
		int sonuc=1;
		int i;
		
		if(exponent ==0)return 1;
		
		for(i=1;i<=exponent;i++) {
			sonuc*=base;
		}
		return sonuc;
	}
}
