package com.project.mathlib.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import com.project.mathlib.main.VectorProducts;

class VectorProductsTest {
    VectorProducts vectorProducts;
    TestInfo testInfo;
    TestReporter testReporter;
    
    @BeforeEach
    void setUp(TestInfo testInfo, TestReporter testReporter) {
        double[][] coefficients = {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0}
        };
        this.vectorProducts = new VectorProducts(coefficients);
        this.testInfo = testInfo;
        this.testReporter = testReporter;
    }
    
    @AfterEach
    void afterReport() {
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
    }
    @Tag("Vector")
    @Test
    @DisplayName("Scalar Vector Product (.)")
    void testScalarProduct() {
        double expected = 32.0; // (1*4 + 2*5 + 3*6)
        double result = vectorProducts.scalarProduct();
        assertEquals(expected, result, "Scalar product calculation failed");
    }
    @Tag("Vector")
    @Test
    @DisplayName("Vectorel Product (x)")
    void testVectorelProduct() {
    	
    	double[]expectedCoefficents = new double[3];
    	double[]resultCoefficents = new double[3];
    	
    	for(int i=0;i<3;i++) {
    		resultCoefficents[i]=vectorProducts.vectorProduct()[i];
    	}
    	expectedCoefficents[0]=-3;
    	expectedCoefficents[1]=6;
    	expectedCoefficents[2]=-3;
    	
    	assertArrayEquals(expectedCoefficents,resultCoefficents,"Vectorel product calculation failed");

    	
    	
    }
    	
    
}
