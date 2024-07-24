package com.project.mathlib.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.project.mathlib.exceptions.MatrixCannotBeMultipliedException;
import com.project.mathlib.exceptions.MatrixDeterminantInvalidMatrixException;
import com.project.mathlib.exceptions.MatrixsCannotBeAdditionException;
import com.project.mathlib.exceptions.MatrixsCannotBeSubtractedException;
import com.project.mathlib.main.Matrix;

import junit.framework.Assert;

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
        int[][] coefficentsMatrix1 = {
            {8, 7, 3},
            {5, 0, 0},
            {2, 5, 4}
        };
        int[][] coefficentsMatrix2 = {
            {3, 0, -9},
            {8, 3, -1},
            {-5, -2, 4}
        };
        int[][] coefficentsMatrix3 = {
                {6, -1},
                {-5, 2},
                {7, 1}
            };
        int[][] coefficentsMatrix4 = {
                {2, -1},
                {9, 0}
            };
        int[][] coefficentsMatrix5 = {
	            {3, 0, -9, -2},
	            {8, 3, -1,  5},
	            {-5, -2, 4, 2},
	            {4, 7, 4, 9}
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
        int[][] expectedMatrix = {
            {11, 7, -6},
            {13, 3, -1},
            {-3, 3, 8}
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
    	int [][] expectedMatrix = {
    			{5,7,12},
    			{-3,-3,1},
    			{7,7,0}	
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
    	int[][] expectedMatrix= {
    			{34,9},
    			{30,-5},
    			{15,12}
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
    	int[][] expectedMatrix = {
    			{9,8,4},
    			{6,1,1},
    			{3,6,5}
    	};
    	
    	resultMatrix = matrix1_3x3.matrixAddition(1);
    	
    	//For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 1; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("MatrixAndIntegerOperation")
    @DisplayName("Subtraction Test For A Matrix and An Integer")
    @Test
    void shouldCalculateSubtractOfMatrixAndInteger() {
    	int[][] expectedMatrix = {
    			{7,6,2},
    			{4,-1,-1},
    			{1,4,3}
    	};
    	
    	resultMatrix = matrix1_3x3.matrixSubtraction(1);
    	
    	//For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 1; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("MatrixAndIntegerOperation")
    @DisplayName("Multiplication Test For A Matrix and An Integer")
    @Test
    void shouldCalculateMultiplicateOfMatrixAndInteger() {
    	int[][] expectedMatrix = {
    			{16, 14, 6},
                {10, 0, 0},
                {4, 10, 8}
    	};
    	
    	resultMatrix = matrix1_3x3.matrixMultiplication(2);
    	
    	//For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 1; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("MatrixAndIntegerOperation")
    @DisplayName("Division Test For A Matrix and An Integer")
    @Test
    void shouldCalculateDivisionOfMatrixAndInteger() {
    	int[][] expectedMatrix = {
    			{2, 7/4, 3/4},
                {5/4, 0, 0},
                {2/4, 5/4, 1}
    	};
    	
    	resultMatrix = matrix1_3x3.matrixDivision(4);
    	
    	//For 2D Arrays, we need to use assertArrayEquals 2 times for check every row.
        for (int i = 1; i < expectedMatrix.length; i++) {
            assertArrayEquals(expectedMatrix[i], resultMatrix.getMatrix()[i]);
        }
    }
    
    
    @Tag("ExtraOperations")
    @DisplayName("toString() Test For a Matrix")
    @Test
    void shouldTurnTheMatrixToString() {
    	String expected1 ="8 7 3 \n5 0 0 \n2 5 4 \n"; 	
    	String expected2 = "6 -1 \n-5 2 \n7 1 \n";
    	
    	String resultString1 = matrix1_3x3.toString();
    	String resultString2 = matrix3_3x2.toString();
    	
    	assertThat(resultString1)
    	.isNotNull()
    	.isEqualTo(expected1);
    	
    	assertThat(resultString2)
    	.isNotNull()
    	.isEqualTo(expected2);
    	
   
    }
    
    @Tag("ExtraOperations")
    @DisplayName("Matrix Determinant Test For Invalid Matrix(Not a Square)")
    @Test
    void shouldThrowExceptionIfMatrixIsNotSquareMatrix(){
    	int[][] coefficentsMatrix3 = {
                {6, -1},
                {-5, 2},
                {7, 1}
            };
    	
    	try {
    	matrix3_3x2.determinant(coefficentsMatrix3,3);
    	}
    	catch(Exception e) {
    		assertThrows(MatrixDeterminantInvalidMatrixException.class,()->matrix3_3x2.determinant(coefficentsMatrix3,3),e.getMessage());
    	}
    }
    
    
    @Tag("ExtraOperations")
    @DisplayName("Matrix Determinant Test For 1x1 Matrices")
    @Test
    void testMatrixDeterminantFor1x1Matrices() {
    	int[][] coefficients1D = {{10}};
    	
    	Matrix matrix1D = new Matrix(coefficients1D);
    	int D = matrix1D.determinant(coefficients1D,1);
    	
    	assertThat(D)
    	  .isEqualTo(10);
    }	
    
    
    @Tag("ExtraOperations")
    @DisplayName("Matrix Determinant Test For 2x2 Matrices")
    @Test
    void testMatrixDeterminantFor2x2Matrices() {
    	 int[][] coefficentsMatrix4 = {
                 {2, -1},
                 {9, 0}
             };
    	int D = matrix4_2x2.determinant(coefficentsMatrix4,2);
    	
    	assertThat(D)
    	 .isEqualTo(9);
    }
    
    @Tag("ExtraOperations")
    @DisplayName("Matrix Determinant Test For NxN Matrices")
    @Test
    void testMatrixDeterminantForNxNMatrices() {
    	 int[][] coefficentsMatrix1 = {
    	            {8, 7, 3},
    	            {5, 0, 0},
    	            {2, 5, 4}
    	        };
    	 int[][] coefficentsMatrix5 = {
 	            {3, 0, -9, -2},
 	            {8, 3, -1,  5},
 	            {-5, -2, 4, 2},
 	            {4, 7, 4, 9}
 	        };
    	 
    	 assertEquals(-65,matrix1_3x3.determinant(coefficentsMatrix1, 3));
    	 
    	 assertEquals(1398,matrix5_4x4.determinant(coefficentsMatrix5, 4));
    	        
    }
    	
    	
   
}











