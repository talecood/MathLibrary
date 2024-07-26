package com.project.mathlib.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.project.mathlib.main.Matrix;

@TestInstance(Lifecycle.PER_CLASS)
class MatrixTest2 {

	public static void main(String[] args) {

		Double[][] c = new Double[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
			c[i][j]  = Double.NEGATIVE_INFINITY;
		}}
		
		
		Double[][] coefficentsMatrix1 = c;
		Double[][] coefficentsMatrix5 = { { 3., 0., -9., -2. }, { 8., 3., -1., 5. }, { -5., -2., 4., 2. },
				{ 4., 7., 4., 9. } };

		Matrix matrix1_3x3 = new Matrix( coefficentsMatrix1);
		Matrix matrix5_4x4 = new Matrix(coefficentsMatrix5);

		Double determinant = matrix1_3x3.determinant(coefficentsMatrix1, 3);
		assertEquals(-65, determinant);

		assertEquals(1398, matrix5_4x4.determinant(coefficentsMatrix5, 4));
		
		System.out.println("end of test");

	}

}
