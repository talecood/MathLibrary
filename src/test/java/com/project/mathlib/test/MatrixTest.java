package com.project.mathlib.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;

import com.project.mathlib.exceptions.MatrixCannotBeMultipliedException;
import com.project.mathlib.exceptions.MatrixDeterminantInvalidMatrixException;
import com.project.mathlib.exceptions.MatrixIdentityInvalidMatrixException;
import com.project.mathlib.exceptions.MatrixsCannotBeAdditionException;
import com.project.mathlib.exceptions.MatrixsCannotBeSubtractedException;
import com.project.mathlib.exceptions.NullParameterException;
import com.project.mathlib.main.Matrix;

@TestInstance(Lifecycle.PER_CLASS)
class MatrixTest {
    
    TestInfo testinfo;
    TestReporter testreporter;
    
    Matrix matrix1_3x3;
    Matrix matrix2_3x3;
    Matrix matrix3_3x2;
    Matrix matrix4_2x2;
    Matrix matrix5_4x4;
    Matrix resultMatrix;
    
    @BeforeAll
    void setUp(TestInfo testinfo, TestReporter testreporter) {
        Double[][] coefficentsMatrix1 = {
            {8., 7., 3.},
            {5., 0., 0.},
            {2., 5., 4.}
        };
        Double[][] coefficentsMatrix2 = {
            {3., 0., -9.},
            {8., 3., -1.},
            {-5., -2., 4.}
        };
        Double[][] coefficentsMatrix3 = {
                {6., -1.},
                {-5., 2.},
                {7., 1.}
            };
        Double[][] coefficentsMatrix4 = {
                {2., -1.},
                {9., 0.}
            };
        Double[][] coefficentsMatrix5 = {
	            {3., 0., -9., -2.},
	            {8., 3., -1.,  5.},
	            {-5., -2., 4., 2.},
	            {4., 7., 4., 9.}
	        };
   
   
   
        this.matrix1_3x3 = new Matrix(coefficentsMatrix1);
        this.matrix2_3x3 = new Matrix(coefficentsMatrix2);
        this.matrix3_3x2 = new Matrix(coefficentsMatrix3);
        this.matrix4_2x2 = new Matrix(coefficentsMatrix4);
        this.matrix5_4x4 = new Matrix(coefficentsMatrix5);
        
        this.testinfo = testinfo;
        this.testreporter = testreporter;
    }
    
    
    @Tag("MatrixAndMatrixOperation")
    @DisplayName("Addition Test For Two Different Matrices")
    @Test
    void shouldCalculateSumOfTwoDifferentMatrices() {
    	Double[][] expectedMatrix = {
            {11., 7., -6.},
            {13., 3., -1.},
            {-3., 3., 8.}
        };
        
        resultMatrix = matrix1_3x3.matrixAddition(matrix2_3x3);
       try {
    	   resultMatrix = matrix1_3x3.matrixAddition(matrix3_3x2);
       }catch(Exception e) {
    	   assertThrows(MatrixsCannotBeAdditionException.class,() -> matrix1_3x3.matrixAddition(matrix3_3x2),e.getMessage());
       }
        
        
        //For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("MatrixAndMatrixOperation")
    @DisplayName("Subtraction Test For Two Different Matrices")
    @Test
    void shouldCalculateSubtractOfTwoDifferentMatrices(){
    	Double [][] expectedMatrix = {
    			{5.,7.,12.},
    			{-3.,-3.,1.},
    			{7.,7.,0.}	
    	};
    	
    	resultMatrix = matrix1_3x3.matrixSubtraction(matrix2_3x3);
    	
    	try {
     	   resultMatrix = matrix1_3x3.matrixSubtraction(matrix3_3x2);
        }catch(Exception e) {
     	   assertThrows(MatrixsCannotBeSubtractedException.class,() -> matrix1_3x3.matrixSubtraction(matrix3_3x2),e.getMessage());
        }
    	
    	 //For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 0; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("MatrixAndMatrixOperation")
    @DisplayName("Multiplication Test For Two Different Matrices")
    @Test
    void shouldCalculateMultiplyOfTwoDifferentMatrices() {
    	Double[][] expectedMatrix= {
    			{34.,9.},
    			{30.,-5.},
    			{15.,12.}
    	};
    	
    	resultMatrix = matrix1_3x3.matrixMultiplication(matrix3_3x2);
    	
    	try {
    		resultMatrix = matrix2_3x3.matrixMultiplication(matrix4_2x2);
    	}catch(Exception e) {
    		assertThrows(MatrixCannotBeMultipliedException.class ,()->matrix2_3x3.matrixMultiplication(matrix4_2x2));
    	}
    	
    	 //For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 1; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("MatrixAndIntegerOperation")
    @DisplayName("Addition Test For A Matrix and An Integer")
    @Test
    void shouldCalculateSumOfMatrixAndInteger() {
    	Double[][] expectedMatrix = {
    			{9.,8.,4.},
    			{6.,1.,1.},
    			{3.,6.,5.}
    	};
    	
    	resultMatrix = matrix1_3x3.matrixAddition(1.);
    	
    	//For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 1; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("MatrixAndIntegerOperation")
    @DisplayName("Subtraction Test For A Matrix and An Integer")
    @Test
    void shouldCalculateSubtractOfMatrixAndInteger() {
    	Double[][] expectedMatrix = {
    			{7.,6.,2.},
    			{4.,-1.,-1.},
    			{1.,4.,3.}
    	};
    	
    	resultMatrix = matrix1_3x3.matrixSubtraction(1.);
    	
    	//For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 1; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("MatrixAndIntegerOperation")
    @DisplayName("Multiplication Test For A Matrix and An Integer")
    @Test
    void shouldCalculateMultiplicateOfMatrixAndInteger() {
    	Double[][] expectedMatrix = {
    			{16., 14., 6.},
                {10., 0., 0.},
                {4., 10., 8.}
    	};
    	
    	resultMatrix = matrix1_3x3.matrixMultiplication(2.);
    	
    	//For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 1; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("MatrixAndIntegerOperation")
    @DisplayName("Division Test For A Matrix and An Integer")
    @Test
    void shouldCalculateDivisionOfMatrixAndInteger() {
    	Double[][] expectedMatrix = {
    			{2., 7/4., 3/4.},
                {5/4., 0., 0.},
                {2/4., 5/4., 1.}
    	};
    	
    	resultMatrix = matrix1_3x3.matrixDivision(4.);
    	
    	//For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 1; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("toString() Method ")
    @DisplayName("toString() Test For a Matrix")
    @Test
    void shouldTurnTheMatrixToString() {
    	String expected1 ="8.0 7.0 3.0 \n5.0 0.0 0.0 \n2.0 5.0 4.0 \n"; 	
    	String expected2 = "6.0 -1.0 \n-5.0 2.0 \n7.0 1.0 \n";
    	
    	String resultString1 = matrix1_3x3.toString();
    	String resultString2 = matrix3_3x2.toString();
    	
    	assertThat(resultString1)
    	.isNotNull()
    	.isEqualTo(expected1);
    	
    	assertThat(resultString2)
    	.isNotNull()
    	.isEqualTo(expected2);
    	
   
    }
    
    @Tag("MatrixDeterminant")
    @DisplayName("Matrix Determinant Test For Null Parameters")
    @Test
    void shouldControlMatrixDeterminantWithNullParameters(){
    	Double[][] matrixCoef = {
    			{null,1., 2.},
    			{3.,4.,5.},
    			{6.,null,null},
    	};
    	
    	Matrix matrixWithNullParameters = new Matrix(matrixCoef);
    
    	
    	assertThrows(NullParameterException.class, ()-> {
    		
    		matrixWithNullParameters.determinant(matrixCoef, matrixCoef.length);
    		
    	}, "Parameters of a Matrix Cannot Be Null Value.");
    			
    	};
 	

    
    
    @Tag("MatrixDeterminant")
    @DisplayName("Matrix Determinant Test For 1x1 Matrices")
    @Test
    void testMatrixDeterminantFor1x1Matrices() {
    	Double[][] coefficients1D = {{10.}};
    	
    	Matrix matrix1D = new Matrix(coefficients1D);
    	Double D = matrix1D.determinant(coefficients1D,1);
    	
    	assertThat(D)
    	  .isEqualTo(10);
    }	
    
    
    @Tag("MatrixDeterminant")
    @DisplayName("Matrix Determinant Test For 2x2 Matrices")
    @Test
    void testMatrixDeterminantFor2x2Matrices() {
    	 Double[][] coefficentsMatrix4 = {
                 {2., -1.},
                 {9., 0.}
             };
    	 Double D = matrix4_2x2.determinant(coefficentsMatrix4,2);
    	
    	assertEquals(9,D);
    }
    
    @Tag("MatrixDeterminant")
    @DisplayName("Matrix Determinant Test For NxN Matrices")
    @Test
    void testMatrixDeterminantForNxNMatrices() {
    	Double[][] coefficentsMatrix1 = {
    	            {8., 7., 3.},
    	            {5., 0., 0.},
    	            {2., 5., 4.}
    	        };
    	Double[][] coefficentsMatrix5 = {
 	            {3., 0., -9., -2.},
 	            {8., 3., -1.,  5.},
 	            {-5., -2., 4., 2.},
 	            {4., 7., 4., 9.}
 	        };
    	 
    	 assertEquals(-65,matrix1_3x3.determinant(coefficentsMatrix1, 3));
    	 
    	 assertEquals(1398,matrix5_4x4.determinant(coefficentsMatrix5, 4));
    	        
    }
    
    
    @Tag("MatrixDeterminant")
    @DisplayName("Matrix Determinant Test For Non Square Matrices")
    @Test
    void determinantTestForNonSquareMatrix(){
    	Double[][]nonSquareMatrixValues = {
    			{6., -1.},
                {-5., 2.},
                {7., 1.}
            };
    	
    	Matrix nonSquareMatrix = new Matrix(nonSquareMatrixValues);
    	
    	assertThrows(MatrixDeterminantInvalidMatrixException.class, ()-> {
    		nonSquareMatrix.determinant(nonSquareMatrixValues,nonSquareMatrixValues[0].length);
    		
    	}, "Matrix must have an order of n x n to have a determinant.");
    }
    
    
    @Tag("MatrixDeterminant")
    @DisplayName("Matrix Determinant Test For NaN Parameters")
    @Test
    void shouldControlMatrixDeterminantWithParameterInfinity() {
    	
    	Double[][] c = new Double[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
			c[i][j]  = Double.NEGATIVE_INFINITY;
		}}
		
		Double[][] coefficentsMatrix1 = c;

		Matrix matrix_3x3 = new Matrix( coefficentsMatrix1);

		Double determinant = matrix_3x3.determinant(coefficentsMatrix1, 3);
		
		assertThat(determinant)
		.isNaN();
    	
    }
    
    
   @Tag("Matrix Inverse")
   @DisplayName("Identity Matrix Test for 4x4 Matrix")
   @Test
   void testIdentityFor4x4Matrix() {
	   Double[][] expectedIdentityMatrixCoef = {
			   {1.,0.,0.,0.},
			   {0.,1.,0.,0.},
			   {0.,0.,1.,0.},
			   {0.,0.,0.,1.}
	   };
	   
	   
	   resultMatrix = matrix5_4x4.identityMatrix();
	   
	   for(int i=0;i<expectedIdentityMatrixCoef.length;i++) {
		   assertArrayEquals(expectedIdentityMatrixCoef[i],resultMatrix.getMatrix()[i]);
	   }
   }
   
   
   @Tag("Matrix Inverse")
   @DisplayName("Identity Matrix Test For Non Square Matrix")
   @Test
   void shouldControlIfMatrixIsNonSquare() {
	   Double[][] nonSquareMatrixCoef = {
			   {3., 0., -9., -2.},
			   {5.,-2.,4.,8.},
			   {1.,6.,-5.,7.}
	   };
	   
	   Matrix nonSquareMatrix = new Matrix(nonSquareMatrixCoef);
	   
	   assertThrows(MatrixIdentityInvalidMatrixException.class, ()-> 
	   
	   			nonSquareMatrix.identityMatrix(),
			   "Matrix must have an order of n x n to have an identity matrix.");
   }
   
   public Matrix invalidMatrix11,invalidMatrix22,invalidMatrix33;
   @Tag("Matrix Inverse")
   @DisplayName("Identity Matrix Test For Invalid Parameters")
   @Test
   void testShouldControlParametersOfMatrixForIdentityOperation() {
	   
	   Double[][] invalidMatrix1 = {
			   {null,null},
			   {1.,null}
	   };
	   Double[][] invalidMatrix2 = {
			   {Double.NEGATIVE_INFINITY,2.},
			   {Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY}
	   };
	   Double[][] invalidMatrix3 = {
			   {null,Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY},
			   {Double.POSITIVE_INFINITY,null,Double.NEGATIVE_INFINITY},
			   {Double.POSITIVE_INFINITY,null,(double) Double.MAX_EXPONENT}
	   };
   
	   invalidMatrix11 = new Matrix(invalidMatrix1);
	   invalidMatrix22 = new Matrix(invalidMatrix2);
	   invalidMatrix33 = new Matrix(invalidMatrix3);
	   
	   
	   assertAll(
			   
			   () ->  assertThrows(NullParameterException.class, () -> invalidMatrix11.identityMatrix(),
					   "Parameter of Matrix Cannot be null or NaN."),
			   
			   () -> assertThrows(NullParameterException.class, () -> invalidMatrix22.identityMatrix(),
					   "Parameter of Matrix Cannot be null or NaN."),
			   
			   () -> assertThrows(NullParameterException.class, () -> invalidMatrix33.identityMatrix(),
					   "Parameter of Matrix Cannot be null or NaN.")
			   
			   );
   
   }
   
   //Inverse testleri yazýlacak
   @Tag("Matrix Inverse")
   @DisplayName("Inverse Matrix Test For Square Matrices")
   @Test
   void testShouldInverseTheMatrixCorrectly() {
	   
   }
  
   
}
    	
