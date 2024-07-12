package com.project.mathlib;

public class Main {

	public static void main(String[] args) {
		
	double[] coefficents_polynominal = {1,2,3,4,5};
			
	Polynomial polinom = new Polynomial(coefficents_polynominal);
	
	//scalar.setVectorValues();
	//scalar.scalarProduct();
	
	//vector.setVectorValues();
	//vector.vectorProduct();
	
	System.out.println(polinom.toString());		//Katsayýlarý Polinom Þeklinde Yazdýrýr.
	
	System.out.println(polinom.Derivative().toString()); //Türev alýr
	
	System.out.println(polinom.Integral().toString()+" +C"); //Belirsiz Ýntegral Alýr.
	
	System.out.println(polinom.definiteIntegral(polinom.Integral(), 1, 3)); // Belirli Ýntegral Alýr.
	
	polinom.function(polinom, 3);	//Basit Fonksiyon çýktýsý.
	
	
	
	Matrix matrix1= new Matrix(3,3);
	Matrix matrix2 = new Matrix(3,3);
	
	matrix1.setMatrixValue(1,1,5);
	matrix1.setMatrixValue(1,2,1);
	matrix1.setMatrixValue(1,0,2);
	
	matrix2.setMatrixValue(1,0,5);
	matrix2.setMatrixValue(1,1,4);
	matrix2.setMatrixValue(1,2,2);

	//System.out.println(matrix1.MatrixTransactions(matrix2)); // BURADA SORUN VAR The method MatrixTransactions(int[][]) in the type Matrix is not applicable for the arguments (Matrix)

	
	}
}
