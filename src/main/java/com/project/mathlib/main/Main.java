package com.project.mathlib.main;

public class Main {

	public static void main(String[] args) {
		
	double[] coefficents_polynominal = {1,2,3,4,5};
			
	Polynomial polinom = new Polynomial(coefficents_polynominal);
	
	//scalar.setVectorValues();
	//scalar.scalarProduct();
	
	//vector.setVectorValues();
	//vector.vectorProduct();
	
	System.out.println(polinom.toString());		//Katsay�lar� Polinom �eklinde Yazd�r�r.
	
	System.out.println(polinom.Derivative().toString()); //T�rev al�r
	
	System.out.println(polinom.Integral().toString()+" +C"); //Belirsiz �ntegral Al�r.
	
	System.out.println(polinom.definiteIntegral(polinom.Integral(), 1, 3)); // Belirli �ntegral Al�r.
	
	polinom.function(polinom, 3);	//Basit Fonksiyon ��kt�s�.
	
	
	//System.out.println(matrix1.MatrixTransactions(matrix2)); // BURADA SORUN VAR The method MatrixTransactions(int[][]) in the type Matrix is not applicable for the arguments (Matrix)

	
	int[][] m1 = 
				{{16, 14, 6},
                {10, 0, 0},
                {4, 10, 8}};
	
	Matrix matrix1 = new Matrix(m1);
	
	System.out.println(matrix1.toString());
	
	System.out.println(matrix1.determinant(m1, 3));
                
	
	}
}
