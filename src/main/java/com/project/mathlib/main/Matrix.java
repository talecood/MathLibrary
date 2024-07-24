package com.project.mathlib.main;

import com.project.mathlib.exceptions.MatrixsCannotBeAdditionException;
import com.project.mathlib.exceptions.MatrixCannotBeMultipliedException;
import com.project.mathlib.exceptions.MatrixDeterminantInvalidMatrixException;
import com.project.mathlib.exceptions.MatrixsCannotBeSubtractedException;

public class Matrix {

	private int[][] matrixCoefficients;

	public Matrix(int[][] newMatrix) {
		this.matrixCoefficients = newMatrix;
	}

	//Setter and Getter
	public int[][] getMatrix() {
		return matrixCoefficients;
	}

	public void setMatrix(int[][] matrix) {
		this.matrixCoefficients = matrix;
	}
	
	public void setMatrixValue(int rows,int columns,int value) {
		matrixCoefficients[rows][columns]=value;
	}
	public int getMatrixValue(int rows,int columns){
		return matrixCoefficients[rows][columns];
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j =0;j<matrixCoefficients[0].length;j++) {
				sb.append(matrixCoefficients[i][j]);
				sb.append(" ");
				
			}
			sb.append("\n");
		}
		return sb.toString();	
	}

	public Matrix matrixAddition(Matrix matrix2) {
		int[][] newMatrix = new int[matrixCoefficients.length][matrixCoefficients.length];
		
		if(matrixCoefficients.length!=matrix2.matrixCoefficients.length || matrixCoefficients[0].length != matrix2.matrixCoefficients[0].length) {
			throw new MatrixsCannotBeAdditionException("Two matrices must have the same dimensions.");
		}
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j=0;j<matrixCoefficients.length;j++) {
				newMatrix[i][j]=matrixCoefficients[i][j]+matrix2.matrixCoefficients[i][j];
			}
		}
		return new Matrix(newMatrix);
	}
	
	public Matrix matrixSubtraction(Matrix matrix2_3x3) {
		int[][] newMatrix = new int[matrixCoefficients.length][matrixCoefficients.length];
		
		if(matrixCoefficients.length!=matrix2_3x3.matrixCoefficients.length || matrixCoefficients[0].length != matrix2_3x3.matrixCoefficients[0].length) {
			throw new MatrixsCannotBeSubtractedException("Two matrices must have the same dimensions.");
		}
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j=0;j<matrixCoefficients.length;j++) {
				newMatrix[i][j]=matrixCoefficients[i][j]-matrix2_3x3.matrixCoefficients[i][j];
			}
		}
		return new Matrix(newMatrix);	
	}
	
	public Matrix matrixMultiplication(Matrix matrix2) {
	    if (matrixCoefficients[0].length != matrix2.matrixCoefficients.length) {
	        throw new MatrixCannotBeMultipliedException("A: Rows: " + matrixCoefficients[0].length + " did not match B: Columns " + matrix2.matrixCoefficients.length + ".");
	    }

	    int[][] newMatrixForMultiplication = new int[matrixCoefficients.length][matrix2.matrixCoefficients[0].length];

	    for (int i = 0; i < matrixCoefficients.length; i++) { // aRow
	        for (int j = 0; j < matrix2.matrixCoefficients[0].length; j++) { // bColumn
	            for (int k = 0; k < matrixCoefficients[0].length; k++) { // aColumn
	                newMatrixForMultiplication[i][j] += matrixCoefficients[i][k] * matrix2.matrixCoefficients[k][j];
	            }
	        }
	    }

	    return new Matrix(newMatrixForMultiplication);
	}
	
	public Matrix matrixAddition(int value) {
		int[][] newMatrix = new int[matrixCoefficients.length][matrixCoefficients.length];
		
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j=0;j<matrixCoefficients.length;j++) {
				newMatrix[i][j]=matrixCoefficients[i][j]+value;
			}
		}
		return new Matrix(newMatrix);
	}
	
	public Matrix matrixSubtraction(int value) {
		int[][] newMatrix = new int[matrixCoefficients.length][matrixCoefficients.length];
		
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j=0;j<matrixCoefficients.length;j++) {
				newMatrix[i][j]=matrixCoefficients[i][j]-value;
			}
		}
		return new Matrix(newMatrix);
	}
	
	public Matrix matrixMultiplication(int value) {
		int[][] newMatrix = new int[matrixCoefficients.length][matrixCoefficients.length];
		
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j=0;j<matrixCoefficients.length;j++) {
				newMatrix[i][j]=matrixCoefficients[i][j]*value;
			}
		}
		return new Matrix(newMatrix);
	}
	
	public Matrix matrixDivision(int value) {
		int[][] newMatrix = new int[matrixCoefficients.length][matrixCoefficients.length];
		
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j=0;j<matrixCoefficients.length;j++) {
				newMatrix[i][j]=matrixCoefficients[i][j]/value;
			}
		}
		return new Matrix(newMatrix);
	}
	 // Determinant calculator
    //@return determinant of the input matrix
    public int determinant(int[][] matrix,int lengthOfMatrix) {
        int det = 0;
        int sign = 1;
        int p = 0;
        int q = 0;
        
        int D=0; //Determinant
		int dPlus=0;
		int dMinus=0;
		
		if(matrixCoefficients.length != matrixCoefficients[0].length) { //Check if Matrix is not Square Matrix.
			throw new MatrixDeterminantInvalidMatrixException("Matrix must have an order of n x n to have a determinant.");
		}
		
		if(matrixCoefficients.length==2 && matrixCoefficients[0].length==2) {
			dPlus += matrixCoefficients[0][0]*matrixCoefficients[1][1];
			dMinus+= matrixCoefficients[0][1]*matrixCoefficients[1][0];
			
			return dPlus - dMinus;
		}
        
        if (matrix.length == 1) {
            det = matrix[0][0];
        } else {
            int[][] smallerMatrix = new int[matrix.length - 1][matrix.length - 1];
            for (int x = 0; x < matrix.length; x++) {
                p = 0;
                q = 0;
                for (int i = 1; i < matrix.length; i++) {
                    for (int j = 0; j < matrix.length; j++) {
                        if (j != x) {
                        	smallerMatrix[p][q++] = matrix[i][j];
                            if (q % (matrix.length - 1) == 0) {
                                p++;
                                q = 0;
                            }
                        }
                    }
                }
                det = det + matrix[0][x] * determinant(smallerMatrix,matrix.length - 1) * sign;
                sign = -sign;
            }
        }
        return det;
    }
}















/*public Matrix matrixMultiplication(Matrix matrix2) {
    if (matrixCoefficients[0].length != matrix2.matrixCoefficients.length) {
        throw new MatrixCannotBeMultipliedException("A: Rows: " + matrixCoefficients[0].length + " did not match B: Columns " + matrix2.matrixCoefficients.length + ".");
    }

    int[][] newMatrixForMultiplication = new int[matrixCoefficients.length][matrix2.matrixCoefficients[0].length];

    for (int i = 0; i < matrixCoefficients.length; i++) { // aRow
        for (int j = 0; j < matrix2.matrixCoefficients[0].length; j++) { // bColumn
            for (int k = 0; k < matrixCoefficients[0].length; k++) { // aColumn
                newMatrixForMultiplication[i][j] += matrixCoefficients[i][k] * matrix2.matrixCoefficients[k][j];
            }
        }
    }

    return new Matrix(newMatrixForMultiplication);
}*/






