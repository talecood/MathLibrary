package com.project.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import junit.framework.Assert;
import com.project.mathlib.Base;


//Every scenario different test methods -independent from others
// Naming : test[Feature] or Should_ExpectedBehaviour_When_Condition or When_Condition_Expect_Behaviour

@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {
	
	Base base = new Base();
	TestInfo testinfo;
	TestReporter testreport;
	
	@Tag("Math")
	@DisplayName("System Start")
	@BeforeAll
	 void setup(TestInfo testinfo,TestReporter testreport) {
		this.testinfo = testinfo;
		this.testreport = testreport;
		
		base= new Base();
	}

	@Tag("Math")
	@DisplayName("Addition Test (+)")	
	@Test
	void testAddition() {
		assertAll(
				()-> assertEquals(10,base.addition(10, 0),"Test should return correctly (+)"),
				()-> assertEquals(19,base.addition(20, -1),"Test should return correctly (+)"),
				
				()-> assertEquals(-19,base.addition(-10, -9),"Test should return correctly (+)"),
				()-> assertEquals(15,base.addition(25,-10),"Test should return correctly (+)")
				);

	}
	
	@Tag("Math")
	@DisplayName("Subtraction Test (-)")
	@Test
	void testSubtraction() {
		assertAll(
				()->assertEquals(15,base.subtraction(20, 5),"Test should return correctly (-)"),
				()->assertEquals(20,base.subtraction(15, -5),"Test should return correctly (-)"),
				
				()->assertEquals(-45,base.subtraction(-30, 15),"Test should return correctly (-)"),
				()->assertEquals(-20,base.subtraction(-15, 5),"Test should return correctly (-)")
				);
	}
	
	@Tag("Math")
	@Test
	@DisplayName("Multiplication Test (x)")
	void testMultiplication() {
		assertAll(
				() -> assertEquals(1,base.multiplication(1, 1),"Test should return correctly (x)"),
				() -> assertEquals(0,base.multiplication(3124123, 0),"Test should return correctly (x)"),
				() -> assertEquals(100,base.multiplication(5, 20),"Test should return correctly (x)"),
				
				() -> assertEquals(-10,base.multiplication(2, -5),"Test should return correctly (x)"),
				() -> assertEquals(45,base.multiplication(-9, -5),"Test should return correctly (x)"),
				
				() -> assertEquals(81,base.multiplication(9, 9),"Test should return correctly (x)"),
				() -> assertEquals(0,base.multiplication(-131432, 0),"Test should return correctly (x)")
				);
	}
	
	@Tag("Math")
	@Test
	@DisplayName("Division Test (/)")
	void testDivision() {
		assertAll(
				() -> assertEquals(100,base.division(300, 3),"Test should return correctly (/)"),
				() -> assertEquals(25,base.division(75, 3),"Test should return correctly (/)"),
				
				() -> assertEquals(100,base.division(100, 1),"Test should return correctly (/)"),
				() -> assertEquals(1,base.division(300, 300),"Test should return correctly (/)"),
				
				() -> assertEquals(-100,base.division(-500, 5),"Test should return correctly (/)"),
				() -> assertEquals(100,base.division(-400, -4),"Test should return correctly (/)")
				);
		
	}
}
	

	
	
	


