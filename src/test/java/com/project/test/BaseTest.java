package com.project.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestReporter;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

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
	@AfterEach
	void afterEach() {
		  testreport.publishEntry("Running " + testinfo.getDisplayName() + " with tags " + testinfo.getTags());
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
	void testDivision() throws Exception{
		
		assertAll(
				() -> assertEquals(100,base.division(300, 3),"Test should return correctly (/)"),
				() -> assertEquals(25,base.division(75, 3),"Test should return correctly (/)"),
				
				() -> assertEquals(100,base.division(100, 1),"Test should return correctly (/)"),
				() -> assertEquals(1,base.division(300, 300),"Test should return correctly (/)"),
				
				() -> assertEquals(-100,base.division(-500, 5),"Test should return correctly (/)"),
				() -> assertEquals(100,base.division(-400, -4),"Test should return correctly (/)")
				);
	}
	
	@Tag("Exception")
	@Test
	@DisplayName("Divide by Zero Test For Division (int/0)")
	void testDivideByZero() {
		Integer numerator = (int) Math.random();
	
		 assertThrows(ArithmeticException.class, ()-> base.division(numerator,0));
	}
	
	
	@SuppressWarnings("static-access")
	@Tag("Exception")
	@Test
	@DisplayName("NullPointer Test For Division (null/int)")
	void testCheckNullParametersOrNullResult() throws Exception{
		
	Base baseM = Mockito.mock(Base.class);
		
	assertThat(baseM).isNotNull();
	
	Mockito.when(baseM.division(null, null)).thenThrow(new NullPointerException());
	
	
	doThrow(new NullPointerException()).when(baseM).division(anyInt(),eq(null));
	doThrow(new NullPointerException()).when(baseM).division(eq(null), anyInt());
	doThrow(new NullPointerException()).when(baseM).division(eq(null), eq(null));

	assertThrows(NullPointerException.class,()-> baseM.division(5, null));
	assertThrows(NullPointerException.class,()-> baseM.division(null, 5));
	assertThrows(NullPointerException.class,()-> baseM.division(null, null));

	}
	
}
	

	
	
	


