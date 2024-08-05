package com.project.mathlib.main;

public class Main {

	public static void main(String[] args) {
		
	Double[] coefficentsPolynominal = {1.,2.,3.,4.,5.};
			
	Polynomial polinom = new Polynomial(coefficentsPolynominal);
	
	
	System.out.println(polinom.toString());		
	
	System.out.println(polinom.derivative().toString()); 
	
	System.out.println(polinom.integral().toString()+" +C"); 
	
	System.out.println(polinom.definiteIntegral(polinom.integral(), 1, 3)); 
	
	polinom.function(3.);	
	

	
	
                
	
	}
}
