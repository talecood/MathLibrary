package com.project.mathlib.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.project.mathlib.exceptions.DivisionToZeroArithmeticException;
import com.project.mathlib.exceptions.NullParameterException;
import com.project.mathlib.main.Base;

@TestInstance(Lifecycle.PER_CLASS)
class BaseTest {
	
	Base base = new Base();
	TestInfo testinfo;
	TestReporter testreport;
	
	@Tag("Math")
	@DisplayName("System Start")
	@BeforeAll
	void setup(TestInfo testinfo, TestReporter testreport) {
		this.testinfo = testinfo;
		this.testreport = testreport;
		base = new Base();
	}
	
	@AfterEach
	void afterEach() {
		testreport.publishEntry("Running " + testinfo.getDisplayName() + " with tags " + testinfo.getTags());
	}

	@Tag("Math")
	@DisplayName("Addition Test (+)")	
	@Test
	void testAddition() {
		assertAll(
				() -> assertEquals(10, base.addition(10, 0), "Test should return correctly (+)"),
				() -> assertEquals(19, base.addition(20, -1), "Test should return correctly (+)"),
				() -> assertEquals(-19, base.addition(-10, -9), "Test should return correctly (+)"),
				() -> assertEquals(15, base.addition(25, -10), "Test should return correctly (+)")
		);
	}
	
	@Tag("Math")
	@DisplayName("Subtraction Test (-)")
	@Test
	void testSubtraction() {
		assertAll(
				() -> assertEquals(15, base.subtraction(20, 5), "Test should return correctly (-)"),
				() -> assertEquals(20, base.subtraction(15, -5), "Test should return correctly (-)"),
				() -> assertEquals(-45, base.subtraction(-30, 15), "Test should return correctly (-)"),
				() -> assertEquals(-20, base.subtraction(-15, 5), "Test should return correctly (-)")
		);
	}
	
	@Tag("Math")
	@Test
	@DisplayName("Multiplication Test (x)")
	void testMultiplication() {
		assertAll(
				() -> assertEquals(1, base.multiplication(1, 1), "Test should return correctly (x)"),
				() -> assertEquals(0, base.multiplication(3124123, 0), "Test should return correctly (x)"),
				() -> assertEquals(100, base.multiplication(5, 20), "Test should return correctly (x)"),
				() -> assertEquals(-10, base.multiplication(2, -5), "Test should return correctly (x)"),
				() -> assertEquals(45, base.multiplication(-9, -5), "Test should return correctly (x)"),
				() -> assertEquals(81, base.multiplication(9, 9), "Test should return correctly (x)"),
				() -> assertEquals(0, base.multiplication(-131432, 0), "Test should return correctly (x)")
		);
	}
	
	@Tag("Math")
	@Test
	@DisplayName("Division Test (/)")
	void testDivision() {
		assertAll(
				() -> assertEquals(100, base.division(300, 3), "Test should return correctly (/)"),
				() -> assertEquals(25, base.division(75, 3), "Test should return correctly (/)"),
				() -> assertEquals(100, base.division(100, 1), "Test should return correctly (/)"),
				() -> assertEquals(1, base.division(300, 300), "Test should return correctly (/)"),
				() -> assertEquals(-100, base.division(-500, 5), "Test should return correctly (/)"),
				() -> assertEquals(100, base.division(-400, -4), "Test should return correctly (/)")
		);
	}
	
	@Tag("Exception")
	@Test()
	@DisplayName("Divide by Zero Test For Division (int/0)")
	void testDivideByZero() {
		Integer numerator = (int) Math.random();
		assertThrows(DivisionToZeroArithmeticException.class, () -> base.division(numerator, 0));
	}
	
	@Nested
	@DisplayName("Operations With Invalid Parameters.")
	class InvalidOperations {
		
		@Tag("Exception")
		@DisplayName("Addition (+)")
		@Test
		void testCheckNullParametersForAddition() {
			assertThrows(NullParameterException.class, () -> base.addition(5, null));
			assertThrows(NullParameterException.class, () -> base.addition(null, 5));
			assertThrows(NullParameterException.class, () -> base.addition(null, null));
			assertThrows(NullParameterException.class, () -> base.addition((int) Double.NEGATIVE_INFINITY, null));
		}
		
		@Tag("Exception")
		@DisplayName("Subtraction (-)")
		@Test
		void testCheckNullParametersForSubtraction() {
			assertThrows(NullParameterException.class, () -> base.subtraction(5, null));
			assertThrows(NullParameterException.class, () -> base.subtraction(null, 5));
			assertThrows(NullParameterException.class, () -> base.subtraction(null, null));
			assertThrows(NullParameterException.class, () -> base.subtraction((int) Double.NEGATIVE_INFINITY, null));
		}
		
		@Tag("Exception")
		@DisplayName("Multiplication (x)")
		@Test
		void testCheckNullParametersForMultiply() {
			assertThrows(NullParameterException.class, () -> base.multiplication(5, null));
			assertThrows(NullParameterException.class, () -> base.multiplication(null, 5));
			assertThrows(NullParameterException.class, () -> base.multiplication(null, null));
			assertThrows(NullParameterException.class, () -> base.multiplication((int) Double.NEGATIVE_INFINITY, null));
		}
		
		@Tag("Exception")
		@Test
		@DisplayName("Division (/)")
		void testCheckNullParametersOrNullResult() {
			assertThat(base).isNotNull();
			assertThrows(NullParameterException.class, () -> base.division(5, null));
			assertThrows(NullParameterException.class, () -> base.division(null, 5));
			assertThrows(NullParameterException.class, () -> base.division(null, null));
			assertThrows(NullParameterException.class, () -> base.division((int) Double.NEGATIVE_INFINITY, null));

		}
	}
}
