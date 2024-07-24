package com.project.mathlib.main;



public class Power {
	public double power(int base,int exponent) {
		
		if(base ==0 && exponent ==0) {
			throw new ArithmeticException("0^0 is undefined.");
		}
		
		int absExponent = Math.abs(exponent);
		double sonuc=1;
		int i;
		
		for(i=1;i<=absExponent;i++) {
			sonuc*=base;
		}
		
		if(exponent <0) {
			if(base ==0) return 0;
			return 1 / sonuc;
		}
		
		return sonuc;
	}
}
