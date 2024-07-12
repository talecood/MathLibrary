package com.project.mathlib;

public class Polynomial {
	
	private double[] coefficent; //0. Indexli eleman x^0, 1.Indexli eleman x^1...
	
	public Polynomial(double[]coefficent)
	{
		this.coefficent = coefficent;
	}
	
	public double getCoefficent(double[] array,int i) {
		return array[i];
	}


	public String toString() {
	    String result = "";

	    for (int i = coefficent.length - 1; i >= 0; i--) {
	        if (coefficent[i] != 0) {  // Check if the element is non-zero
	            if (result.isEmpty()) {
	                // Directly add the first non-zero coefficient
	                result += coefficent[i];
	            } else {
	                // For subsequent coefficients, add + or -
	                if (coefficent[i] > 0) result += " + " + coefficent[i];
	                else result += " - " + Math.abs(coefficent[i]);
	            }
	            if (i > 0) {  // Prevent adding "x" to the constant term
	                result += "x";
	                if (i > 1) {  // Add the power for exponents greater than 1
	                    result += "^" + i;
	                }
	            }
	        }
	    }
	    return result;
	}

	
	public double function(Polynomial poly,double x) {
		double function=0;
		for(int i=poly.coefficent.length-1;i>=0;i--) {
			function+=poly.coefficent[i]*Math.pow(x,i);
		}
		return function;
	}
	
	public Polynomial Derivative() {
		if(coefficent.length == 1) return new Polynomial(new double[] {0});//Sabit polinomun t�revi 0
		
		double[] derivativeCoefficents = new double[coefficent.length-1]; //Sabit terim kaybolacak. -1
		
		for(int i =coefficent.length-1;i>0;i--) { //Sabit terim kaybolaca��ndan coef.length-1 
			derivativeCoefficents[i-1]= coefficent[i]*i; // yeni katsay�m�z index numaras�(�s)*normal katsay�.
		}
		
		return new Polynomial(derivativeCoefficents); // polinom tipindeki katsay�lar� geri �a��r�yoruz.
	}
	
	
	public Polynomial Integral() {
		
		double[] integralCoefficents = new double[coefficent.length+1]; 
		// Index numaralar� �st� temsil etti�i i�in hepsini 1 birim kayd�rd�m. 0 indeksli eleman 1'e kay�nca �ss� de artm�� oldu.
		for(int i=coefficent.length-1;i>=0;i--) {
			integralCoefficents[i+1]=coefficent[i]/(i+1);
		}
		return new Polynomial(integralCoefficents);
	}
	
	
	public double definiteIntegral(Polynomial poly,int lowerBound,int upperBound) {
		double sonu�=0;
		double upper=0,lower=0;
		for(int i = poly.coefficent.length-1;i>=0;i--) { //�ntegrali al�nm�� polinomun
			upper += poly.coefficent[i]*Math.pow(upperBound,i);
			lower += poly.coefficent[i]*Math.pow(lowerBound,i);
		}
		sonu� =upper-lower;
		return sonu�;
	}
	
	
	
	
	
}











/* //Polinom haline getirme
	public String toString() {
	String result ="";
	
	for(int i=coefficent.length-1;i>=0;i--) {
		if(coefficent[i] !=0) { 	//Eleman var m� kontrol edilir
			if(!result.isEmpty()) { 	// return de�erinin i�i bo� de�ilse devam eder.
				if(coefficent[i]>0)result += " +"; 	//+ ve - String olarak yan�na yaz�l�r.
				if(coefficent[i]<0)result += " -";
					else { 
						if (coefficent[i] < 0) result += " -"; // Handle the first negative coefficient
	            }
			}
			result += Math.abs(coefficent[i]); //Sadece katsay�n�n mutla�� al�n�r. i�areti �stte String halinde konulur.
			if(i>0) {	 // Sabit de�erin yan�na x de�i�keni koymas�n� �nler
				result+="x";
				if(i>1) { 	// �ss� 1'den b�y�k olan her �eye ^ koyar
					result += "^"+i;	//Derecesini yazmak i�in
				}
			}
		}
	}
	return result;
}*/
