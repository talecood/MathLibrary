package com.project.mathlib;

import java.util.Scanner;

public class Matrix {

	private int[][] matrix;
	
	
	public Matrix(int rows,int columns) { //Constructor
		this.matrix = new int[rows][columns];
		
		System.out.println(rows+"x"+columns+" matrix created.");
	}

	public Matrix(int[][] newMatrix) {
		// TODO Auto-generated constructor stub
	}

	//Setter ve Getter
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	public void setMatrixValue(int rows,int columns,int value) {
		matrix[rows][columns]=value;
	}
	public int getMatrixValue(int rows,int columns){
		return matrix[rows][columns];
	}
	
	public String toString() {
		String result = "";
		
		for(int i =0;i<matrix.length;i++) {
			for(int j =0;j<matrix.length;j++) {
				result += matrix[i][j];
				result+=" ";
			}result += "\n";
		}
		return result;	
	}
	
	public Matrix MatrixOperations(int[][] matrix2) {
		int option1;
		int[][] newMatrix = new int[matrix.length][matrix.length];
		try (Scanner option = new Scanner(System.in)) {
			System.out.println("1. Addition\n2. Subtraction");
			option1 = option.nextInt();
		}
		switch (option1) {
		case 1:
			for(int i =0;i<matrix.length;i++) {
				for(int j=0;j<matrix.length;j++) {
					newMatrix[i][j]=this.matrix[i][j]+matrix2[i][j];
				}
			}
			break;
			
		case 2:
			for(int i =0;i<matrix.length;i++) {
				for(int j=0;j<matrix.length;j++) {
					newMatrix[i][j]=this.matrix[i][j]-matrix2[i][j];
				}
			}
			break;	
		}
		return new Matrix(newMatrix);
	}
	
}
	

