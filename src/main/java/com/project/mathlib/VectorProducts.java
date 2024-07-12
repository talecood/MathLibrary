package com.project.mathlib;

public class VectorProducts {

    private double[][] vector;

    // Constructor
    public VectorProducts(double[][] coefficients) {
        this.vector = coefficients;
    }

    // Scalar product method
    public double scalarProduct() {
        double result = 0;
        for (int i = 0; i < vector[0].length; i++) {
            result += vector[0][i] * vector[1][i];
        }
        return result;
    }

    // Vector product method
    public double[] vectorProduct() {
        double[] newVector = new double[3];
        newVector[0] = vector[0][1] * vector[1][2] - vector[0][2] * vector[1][1];
        newVector[1] = vector[0][2] * vector[1][0] - vector[0][0] * vector[1][2];
        newVector[2] = vector[0][0] * vector[1][1] - vector[0][1] * vector[1][0];
        return newVector;
    }
}
