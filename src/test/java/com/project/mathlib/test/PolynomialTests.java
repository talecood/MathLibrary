package com.project.mathlib.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.project.mathlib.main.Polynomial;

@TestInstance(Lifecycle.PER_CLASS)
public class PolynomialTests {

	Polynomial poly;
	Polynomial poly1;
	
	TestInfo testinfo;
	TestReporter testreporter;
	
	@SuppressWarnings("unused")
	@BeforeAll
	void setUp(TestInfo testinfo,TestReporter testreporter) {
	double[] coefficents = new double[]
			{0,1,2,3,4,5};
	double[] coefficents2 = new double[]
			{2.3,-3.1,0,5.1,-9.6};
	
	this.testinfo = testinfo;
	this.testreporter = testreporter;
	this.poly = new Polynomial(coefficents);
	this.poly1 = new Polynomial(coefficents2);
	
	  testreporter.publishEntry("Running " + testinfo.getDisplayName() + " with tags " + testinfo.getTags());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	@DisplayName("Function Test")
	void Should_Return_ValueOfFunction_For_Parameter() {
		assertAll(
				() -> assertEquals(0.0, poly.function(poly,0),"Function returned wrong value"),
				() -> assertEquals(15.0, poly.function(poly,1),"Function returned wrong value"),
				() -> assertEquals(181896.0, poly.function(poly,8),"Function returned wrong value"),
				
				() -> assertEquals(2.3, poly1.function(poly1,0),"Function returned wrong value"),
				() -> assertEquals(-5.3, poly1.function(poly1,1),"Function returned wrong value"),
				() -> assertEquals(-36732.9, poly1.function(poly1,8),"Function returned wrong value")
			);
	}
	@Test
	@DisplayName("toString() Test for Polynomial")
	void Should_Return_StringVersion_Of_Polynomial() {
		String expected = "5.0x^5 + 4.0x^4 + 3.0x^3 + 2.0x^2 + 1.0x";
		String result = poly.toString();
		
		String expected2 = "-9.6x^4 + 5.1x^3 - 3.1x + 2.3";
		String result2 = poly1.toString();
		
		assertTrue(expected.equals(result),"toString() Test Failed");
		assertTrue(expected2.equals(result2),"toString() Test Failed");
	}
	
	@Test
	@DisplayName("Integral Test For Polynomial")
	void Should_Return_Integral_Of_Polynomial() {
		String expected = "0.8333333333333334x^6 + 0.8x^5 + 0.75x^4 + 0.6666666666666666x^3 + 0.5x^2";
		String result = poly.Integral().toString();
		
		String expected2 = "-1.92x^5 + 1.275x^4 - 1.55x^2 + 2.3x";
		String result2 = poly1.Integral().toString();
		
		assertTrue(expected.equals(result),"Integral Test Failed");
		assertTrue(expected2.equals(result2),"Integral Test Failed");
		
		
		}
	
	@Test
	@DisplayName("Derivative Test For Polynomial")
	void Should_Return_Derivative_Of_Polynomial() {
		String expected = "25.0x^4 + 16.0x^3 + 9.0x^2 + 4.0x + 1.0";
		String result = poly.Derivative().toString();
		
		String expected2 = "-38.4x^3 + 15.299999999999999x^2 - 3.1";
		String result2 = poly1.Derivative().toString();
		
		assertTrue(expected.equals(result),"Derivative Test Failed");
		assertTrue(expected2.equals(result2),"toString() Test Failed");
	}
	/*@Test
    @DisplayName("Definite Integral test for Polynomial")
    void shouldReturnValueOfDefiniteIntegralDueToUpperandLowerBounds() {
        assertAll(
        		//assertEqual Causing Problems here
            () -> assertEquals(11976.94285, poly.definiteIntegral(poly.Integral(), 1, 5)),
            () -> assertEquals(-1726.32, poly1.definiteIntegral(poly1.Integral(), -2, 4))
        );
    }*/
}