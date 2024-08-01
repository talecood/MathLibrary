package com.project.mathlib.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;

import com.project.mathlib.exceptions.InvalidParameterException;
import com.project.mathlib.main.Polynomial;

@TestInstance(Lifecycle.PER_CLASS)
class PolynomialTests {

    Polynomial poly;
    Polynomial poly1;

    TestInfo testinfo;
    TestReporter testreporter;

    @BeforeAll
    void setUp(TestInfo testinfo, TestReporter testreporter) {
        Double[] coefficents = new Double[] { 0., 1., 2., 3., 4., 5. };
        Double[] coefficents2 = new Double[] { 2.3, -3.1, 0., 5.1, -9.6 };

        this.testinfo = testinfo;
        this.testreporter = testreporter;
        this.poly = new Polynomial(coefficents);
        this.poly1 = new Polynomial(coefficents2);

        testreporter.publishEntry("Running " + testinfo.getDisplayName() + " with tags " + testinfo.getTags());
    }

    @Test
    @DisplayName("Function Valid Test")
    void Should_Return_ValueOfFunction_For_Parameter() {
        assertAll(
            () -> assertEquals(0.0, poly.function(0.), "Function returned wrong value"),
            () -> assertEquals(15.0, poly.function(1.), "Function returned wrong value"),
            () -> assertEquals(181896.0, poly.function(8.), "Function returned wrong value"),

            () -> assertEquals(2.3, poly1.function(0.), "Function returned wrong value"),
            () -> assertEquals(-5.3, poly1.function(1.), "Function returned wrong value"),
            () -> assertEquals(-36732.9, poly1.function(8.), "Function returned wrong value")
        );
    }

    @Test
    @DisplayName("Function Invalid Parameter Test")
    void shouldControlIfTheParameterInvalid() {
        assertAll(
            () -> assertThrows(InvalidParameterException.class, () -> poly.function(null),
                    "Parameter is invalid(null or infinity)."),
            () -> assertThrows(InvalidParameterException.class, () -> poly.function(Double.NEGATIVE_INFINITY),
                    "Parameter is invalid(null or infinity)."),
            () -> assertThrows(InvalidParameterException.class, () -> poly.function(Double.POSITIVE_INFINITY),
                    "Parameter is invalid(null or infinity).")
        );
    }

    @Test
    @DisplayName("Function Invalid Coefficients Test")
    void shouldCheckIfThePolynomialCoefficientsInvalid() {
        Double[] invalidCoefficients = { null, 3., -1., Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

        Polynomial invalidPoly = new Polynomial(invalidCoefficients);

        assertThrows(IllegalArgumentException.class, () -> invalidPoly.function(5.), "Coefficients are Invalid.");
    }

    @Test
    @DisplayName("toString() Test for Polynomial")
    void Should_Return_StringVersion_Of_Polynomial() {
        String expected = "5.0x^5 + 4.0x^4 + 3.0x^3 + 2.0x^2 + 1.0x";
        String result = poly.toString();

        String expected2 = "-9.6x^4 + 5.1x^3 - 3.1x + 2.3";
        String result2 = poly1.toString();

        assertTrue(expected.equals(result), "toString() Test Failed");
        assertTrue(expected2.equals(result2), "toString() Test Failed");
    }

    @Test
    @DisplayName("integral Test For Polynomial")
    void Should_Return_integral_Of_Polynomial() {
    	
    	Polynomial coef = poly.integral();
    	Polynomial coef1 = poly1.integral();		
    	
        String expected = "0.8333333333333334x^6 + 0.8x^5 + 0.75x^4 + 0.6666666666666666x^3 + 0.5x^2";
        String result = coef.toString();

        String expected2 = "-1.92x^5 + 1.275x^4 - 1.55x^2 + 2.3x";
        String result2 = coef1.toString();

        assertTrue(expected.equals(coef.toString()), "integral Test Failed");
        assertTrue(expected2.equals(coef1.toString()), "integral Test Failed");
    }

    @Test
    @DisplayName("integral Test For Invalid Polynomial")
    void shouldChechIfThePolynomialInvalidForintegral() {
        Double[] invalidCoefficients = { null, 3., -1., Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

        Polynomial invalidPoly = new Polynomial(invalidCoefficients);

        assertThrows(IllegalArgumentException.class, () -> invalidPoly.integral(), "Coefficient are Invalid.");
    }

    @Test
    @DisplayName("derivative Test For Polynomial")
    void Should_Return_derivative_Of_Polynomial() {
        String expected = "25.0x^4 + 16.0x^3 + 9.0x^2 + 4.0x + 1.0";
        String result = poly.derivative().toString();

        String expected2 = "-38.4x^3 + 15.299999999999999x^2 - 3.1";
        String result2 = poly1.derivative().toString();

        assertTrue(expected.equals(result), "derivative Test Failed");
        assertTrue(expected2.equals(result2), "toString() Test Failed");
    }

    @Test
    @DisplayName("derivative Test For Invalid Polynomial")
    void shouldChechIfThePolynomialInvalidForderivative() {
        Double[] invalidCoefficients = { null, 3., -1., Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };

        Polynomial invalidPoly = new Polynomial(invalidCoefficients);

        assertThrows(IllegalArgumentException.class, () -> invalidPoly.derivative(), "Coefficient are Invalid.");
    }

    @Test
    @DisplayName("Definite integral test for Polynomial")
    void shouldReturnValueOfDefiniteintegralDueToUpperandLowerBounds() {
    	
    	
        double expected = 16081.86666666667;
        double actual = poly.definiteIntegral(poly.integral(), 1, 5);
        double delta = 0.00001;

        assertEquals(expected, actual, delta);
        	
    }
}
