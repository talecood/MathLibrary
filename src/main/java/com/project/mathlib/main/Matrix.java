package com.project.mathlib.main;

import com.project.mathlib.exceptions.*;


/**
 * nedim goktug tabak
 * 1 Ağu 2024
 */
public class Matrix {

	private static final String MATRIX_NON_SQUARE = "Matrix must have an order of n x n to calculate the operation.";
	private static final String MATRIX_INVALID_COEFFICIENTS = "Matrix Coefficients Cannot be null or NaN.";
	private static final String MATRIX_INVALID_PARAMETERS = "Parameter of Matrix Cannot be null or NaN.";
	
	private Double[][] matrixCoefficients;

	/**
	 * @param newMatrix
	 */
	public Matrix(Double[][] newMatrix) {
		this.matrixCoefficients = newMatrix;
	}

	/**
	 * @return the matrixCoefficients
	 */
	public Double[][] getMatrixCoefficients() {
		return matrixCoefficients;
	}

	/**
	 * @param matrixCoefficients the matrixCoefficients to set
	 */
	public void setMatrixCoefficients(Double[][] matrixCoefficients) {
		this.matrixCoefficients = matrixCoefficients;
	}



	public void setMatrixValue(int rows,int columns,Double value) {
		matrixCoefficients[rows][columns]=value;
	}
	public Double getMatrixValue(int rows,int columns){
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
		Double[][] newMatrix = new Double[matrixCoefficients.length][matrixCoefficients.length];
		
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
		Double[][] newMatrix = new Double[matrixCoefficients.length][matrixCoefficients.length];
		
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
	        throw new MatrixCannotBeMultipliedException
	        ("A: Rows: " + matrixCoefficients[0].length + " did not match B: Columns " + matrix2.matrixCoefficients.length + ".");
	    }

	    Double[][] newMatrixForMultiplication =
	    		new Double[matrixCoefficients.length][matrix2.matrixCoefficients[0].length];
	    
	    //Cannot invoke "java.lang.Double.doubleValue()" because "newMatrixForMultiplication[i][j]" is null. Filling the new array with 0.
	    for(int i =0;i<matrixCoefficients.length;i++) {
	    	for(int j =0;j<matrix2.matrixCoefficients[0].length;j++) {
	    		newMatrixForMultiplication[i][j]=0.;
	    	}
	    }
	    
	    for (int i = 0; i < matrixCoefficients.length; i++) { // aRow
	        for (int j = 0; j < matrix2.matrixCoefficients[0].length; j++) { // bColumn
	            for (int k = 0; k < matrixCoefficients[0].length; k++) { // aColumn
	                newMatrixForMultiplication[i][j] +=
	                		matrixCoefficients[i][k] * matrix2.matrixCoefficients[k][j];
	            }
	        }
	    }

	    return new Matrix(newMatrixForMultiplication);
	}
	
	public Matrix matrixAddition(Double value) {
		Double[][] newMatrix = new Double[matrixCoefficients.length][matrixCoefficients.length];
		
		for(int x=0;x<matrixCoefficients.length;x++) {
			for(int h =0;h<matrixCoefficients.length;h++) {
				if(isInvalid(matrixCoefficients[x][h])){
					throw new NullParameterException(MATRIX_INVALID_COEFFICIENTS);
				}
			}
		}
		
		if(isInvalid(value)) {
			throw new NullParameterException(MATRIX_INVALID_PARAMETERS);
		}
		
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j=0;j<matrixCoefficients.length;j++) {
				newMatrix[i][j]=matrixCoefficients[i][j]+value;
			}
		}
		return new Matrix(newMatrix);
	}
	
	public Matrix matrixSubtraction(Double value) {
		Double[][] newMatrix = new Double[matrixCoefficients.length][matrixCoefficients.length];
		
		for(int x=0;x<matrixCoefficients.length;x++) {
			for(int h =0;h<matrixCoefficients.length;h++) {
				if(isInvalid(matrixCoefficients[x][h])){
					throw new NullParameterException(MATRIX_INVALID_COEFFICIENTS);
				}
			}
		}
		
		if(isInvalid(value)) {
			throw new NullParameterException(MATRIX_INVALID_PARAMETERS);
		}
		
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j=0;j<matrixCoefficients.length;j++) {
				newMatrix[i][j]=matrixCoefficients[i][j]-value;
			}
		}
		return new Matrix(newMatrix);
	}
	
	public Matrix matrixMultiplication(Double value) {
		Double[][] newMatrix = new Double[matrixCoefficients.length][matrixCoefficients.length];
		
		for(int x=0;x<matrixCoefficients.length;x++) {
			for(int h =0;h<matrixCoefficients.length;h++) {
				if(isInvalid(matrixCoefficients[x][h])){
					throw new NullParameterException(MATRIX_INVALID_COEFFICIENTS);
				}
			}
		}
		
		if(isInvalid(value)) {
			throw new NullParameterException("Parameter value is Invalid.");
		}
		
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j=0;j<matrixCoefficients.length;j++) {
				newMatrix[i][j]=matrixCoefficients[i][j]*value;
			}
		}
		return new Matrix(newMatrix);
	}
	
	public Matrix matrixDivision(Double value) {
		Double[][] newMatrix = new Double[matrixCoefficients.length][matrixCoefficients.length];
		
		for(int x=0;x<matrixCoefficients.length;x++) {
			for(int h =0;h<matrixCoefficients.length;h++) {
				if(isInvalid(matrixCoefficients[x][h])){
					throw new NullParameterException(MATRIX_INVALID_COEFFICIENTS);
				}
			}
		}
		
		if(isInvalid(value)) {
			throw new NullParameterException(MATRIX_INVALID_PARAMETERS);
		}
		
		for(int i =0;i<matrixCoefficients.length;i++) {
			for(int j=0;j<matrixCoefficients.length;j++) {
				newMatrix[i][j]=matrixCoefficients[i][j]/value;
			}
		}
		return new Matrix(newMatrix);
	}
	
	
	 // Determinant calculator
    //@return determinant of the input matrix
    public Double determinant(Double[][] matrix,int lengthOfMatrix) {
    	//For NxN Matrix
        Double det = 0.;
        int sign = 1;
        int p = 0;
        int q = 0;
        
        //For 2x2 Matrix
		Double dPlus=0.;
		Double dMinus=0.;
		
		//First of all, check if the matrix is not square.
		if(matrixCoefficients.length != matrixCoefficients[0].length) { //Check if Matrix is not Square Matrix.
			throw new MatrixDeterminantInvalidMatrixException(MATRIX_NON_SQUARE);
		}
		
		//Then, control is there any null parameters inside matrix values.
		for(int i=0;i<lengthOfMatrix;i++) {
			for(int j=0;j<lengthOfMatrix;j++) {
				if(matrix[i][j]==null) {
					throw new NullParameterException(MATRIX_INVALID_PARAMETERS);
				}
			}
		}
		
		//For 2x2 Matrix
		if(matrixCoefficients.length==2 && matrixCoefficients[0].length==2) {
			dPlus += matrixCoefficients[0][0]*matrixCoefficients[1][1];
			dMinus+= matrixCoefficients[0][1]*matrixCoefficients[1][0];
			
			return dPlus - dMinus;
		}
        
		//1x1 Matrix Determinant
        if (lengthOfMatrix == 1) {
            det = matrix[0][0];
            // Starts NxN Matrix Calculations
        } else {
            Double[][] smallerMatrix = new Double[lengthOfMatrix - 1][lengthOfMatrix - 1];
            for (int x = 0; x < lengthOfMatrix; x++) {
                p = 0;
                q = 0;
                for (int i = 1; i < lengthOfMatrix; i++) {
                    for (int j = 0; j < lengthOfMatrix; j++) {
                        if (j != x) {
                        	smallerMatrix[p][q++] = matrix[i][j];
                            if (q % (lengthOfMatrix - 1) == 0) {
                                p++;
                                q = 0;
                            }
                        }
                    }
                }
                //Recursive For Rows
                det = det + matrix[0][x] * determinant(smallerMatrix,lengthOfMatrix - 1) * sign;
                sign = -sign;
            }
        }
        return det;
    }
    
    public Matrix identityMatrix() {
    	Double[][] identityMatrix = new Double[matrixCoefficients.length][matrixCoefficients.length];
    	
    	//First of all, check if the matrix is not square.
    			if(matrixCoefficients.length != matrixCoefficients[0].length) {
    				throw new MatrixIdentityInvalidMatrixException
    				(MATRIX_NON_SQUARE);
    			}
    	//Secondly, check all values for any null or NaN value.
    			for(int x=0;x<matrixCoefficients.length;x++) {
    				for(int h =0;h<matrixCoefficients.length;h++) {
    					if(isInvalid(matrixCoefficients[x][h])){
    						throw new NullParameterException(MATRIX_INVALID_PARAMETERS);
    					}
    				}
    			}
    	
    			for(int i=0;i<matrixCoefficients.length;i++) {
    				for(int j=0;j<matrixCoefficients.length;j++) {
    					if(i==j) {
    						identityMatrix[i][j]=1.;
    					}
    					else {
    						identityMatrix[i][j]=0.;
    					}
    				}
    			}
    			return new Matrix(identityMatrix);	
    }

    
    public Matrix inverseMatrix() {
        int n = matrixCoefficients.length;
        
        // First of all, check if the matrix is not square.
        if (n != matrixCoefficients[0].length) {
            throw new MatrixInverseInvalidMatrixException(MATRIX_NON_SQUARE);
        }
        
        for(int x=0;x<matrixCoefficients.length;x++) {
			for(int h =0;h<matrixCoefficients.length;h++) {
				if(isInvalid(matrixCoefficients[x][h])){
					throw new NullParameterException(MATRIX_INVALID_PARAMETERS);
				}
			}
		}

        Double[][] inverseMatrix = new Double[n][n];
        
        // Initialize the inverse matrix as an identity matrix
      for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    inverseMatrix[i][j] = 1.;
                } else {
                    inverseMatrix[i][j] = 0.;
                }
            }
       }

        // Create a copy of the original matrix
        Double[][] tempMatrix = new Double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempMatrix[i][j] = matrixCoefficients[i][j];
            }
        }
        
        Matrix controlMatrix = new Matrix(matrixCoefficients);
        
        if((controlMatrix.determinant(matrixCoefficients, controlMatrix.matrixCoefficients.length))==0) {
        	throw new MatrixInverseInvalidMatrixException
        	("Inverse Operation on Singular Matrices Cannot Be Done. (Determinant == 0)");
        }

        // Perform Gauss-Jordan elimination
        for (int i = 0; i < n; i++) {
            double divider = tempMatrix[i][i];

            // Check for zero diagonal elements
            if (divider == 0) {
                throw new MatrixIdentityInvalidMatrixException
                ("Matrix is singular and cannot be inverted.");
            }

            for (int j = 0; j < n; j++) {
                tempMatrix[i][j] /= divider;
                inverseMatrix[i][j] /= divider;
            }

            for (int x = 0; x < n; x++) {
                if (x != i) {
                    double factor = tempMatrix[x][i];
                    for (int j = 0; j < n; j++) {
                        tempMatrix[x][j] -= tempMatrix[i][j] * factor;
                        inverseMatrix[x][j] -= inverseMatrix[i][j] * factor;
                    }
                }
            }
        }

        return new Matrix(inverseMatrix);
    }
    
    
    
    private boolean isInvalid(Double value) {
    		return value == null 
    		|| value == Double.NEGATIVE_INFINITY 
    		|| value == Double.POSITIVE_INFINITY;
    }
}