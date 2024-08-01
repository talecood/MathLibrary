package com.project.mathlib.main;

import com.project.mathlib.exceptions.InvalidParameterException;

public class Polynomial {
	
	private static final String INVALID_POLYNOMIAL = "Coefficients are Invalid.(null/infinite)";
	
	private Double[] coefficent; //0. Indexli eleman x^0, 1.Indexli eleman x^1...
	
	public Polynomial(Double[] coefficients) {
        this.coefficent = coefficients;
    }
	
	public Double getCoefficent(Double[] array,int i) {
		return array[i];
	}


	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    for(int i=0;i<coefficent.length;i++) {
			if(isInvalid(coefficent[i])) {
				throw new IllegalArgumentException(INVALID_POLYNOMIAL);
			}
		}
	    
	    for (int i = coefficent.length - 1; i >= 0; i--) {
	    	
	        if (coefficent[i] != 0) {  // Check if the element is non-zero
	        	
	            if (sb.isEmpty()) {
	                // Directly add the first non-zero coefficient
	                sb.append(coefficent[i]);
	            } 
	            else {
	            	
	                // For subsequent coefficients, add + or -
	                if (coefficent[i] > 0) sb.append(" + "+Math.abs(coefficent[i]));
	                else sb.append(" - "+Math.abs(coefficent[i]));
	            }
	            
	            if (i > 0) {  // Prevent adding "x" to the constant term
	                sb.append("x");
	                if (i > 1) {  // Add the power for exponents greater than 1
	                    sb.append("^"+i);
	                }
	            }
	        }
	    }
	    
	    return sb.toString();
	}

	
	public Double function(Double j) {
		if(isInvalid(j)) {
			throw new InvalidParameterException("Parameter is invalid(null or infinity).");
		}
		
		for(int i=0;i<coefficent.length;i++) {
			if(isInvalid(coefficent[i])) {
				throw new IllegalArgumentException(INVALID_POLYNOMIAL);
			}
		}
		
		double function=0;
		for(int i=coefficent.length-1;i>=0;i--) {
			function+=coefficent[i]*Math.pow(j,i);
		}
		return function;
	}
	
	public Polynomial derivative() {
		if(coefficent.length == 1) return new Polynomial(new Double[] {0.0});//Sabit polinomun türevi 0
		
		for(int i=0;i<coefficent.length;i++) {
			if(isInvalid(coefficent[i])) {
				throw new IllegalArgumentException(INVALID_POLYNOMIAL);
			}
		}
		
		Double[] derivativeCoefficents = new Double[coefficent.length-1]; //Sabit terim kaybolacak. -1
		
		for(int i =coefficent.length-1;i>0;i--) { //Sabit terim kaybolacaðýndan coef.length-1 
			derivativeCoefficents[i-1]= coefficent[i]*i; // yeni katsayýmýz index numarasý(üs)*normal katsayý.
		}
		
		return new Polynomial(derivativeCoefficents); // polinom tipindeki katsayýlarý geri çaðýrýyoruz.
	}
	
	
	public Polynomial integral() {
		
		Double[] integralCoefficents = new Double[coefficent.length+1]; 
		// Index numaralarý üstü temsil ettiði için hepsini 1 birim kaydýrdým. 0 indeksli eleman 1'e kayýnca üssü de artmýþ oldu.
		for(int i=0;i<coefficent.length;i++) {
			if(isInvalid(coefficent[i])) {
				throw new IllegalArgumentException(INVALID_POLYNOMIAL);
			}
		}
		
		for(int i=coefficent.length-1;i>=0;i--) {
			integralCoefficents[i+1]=coefficent[i]/(i+1);
		}
		
		//constant term
		integralCoefficents[0] = 0.;
		
		return new Polynomial(integralCoefficents);
	}
	
	
	public double definiteIntegral(Polynomial poly,int lowerBound,int upperBound) {
		double upper=0;
		double lower=0;
		
		if(isInvalid((double) lowerBound) || isInvalid((double) upperBound)) {
			throw new IllegalArgumentException("Bounds are Invalid.");
		}
			
		for(int i=0;i<coefficent.length;i++) {
			if(isInvalid(coefficent[i])) {
				throw new IllegalArgumentException(INVALID_POLYNOMIAL);
			}
		}
		
		for(int i = poly.coefficent.length-1;i>=0;i--) { //Ýntegrali alýnmýþ polinomun
			upper += poly.coefficent[i]*Math.pow(upperBound,i);
			lower += poly.coefficent[i]*Math.pow(lowerBound,i);
		}
		
		return upper-lower;
	}
	
	
	private boolean isInvalid(Double value) {
    	return value == null || value == Double.NEGATIVE_INFINITY || value == Double.POSITIVE_INFINITY;
    }
	
	
}



