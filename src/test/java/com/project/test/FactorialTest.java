package com.project.test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.*;

import com.project.mathlib.Factorial;

public class FactorialTest {
	Factorial obj = new Factorial();
	TestInfo testinfo;
	TestReporter testreporter;
	
	@AfterEach
	void afterReport(TestInfo testinfo,TestReporter testreporter) {
		this.testinfo = testinfo;
		this.testreporter = testreporter;
		//System.out.println("Running "+testinfo.getDisplayName()+" with tags "+testinfo.getTags());
		testreporter.publishEntry("Running "+testinfo.getDisplayName()+" with tags "+testinfo.getTags());
	}
	/* private static final String EXCEPTION_MESSAGE = "Input number cannot be negative";

	 @Test
	 @DisplayName(EXCEPTION_MESSAGE)
	 public void testWhenInvalidInoutProvidedShouldThrowException() {
	    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> obj.factorial(-1));
	    assertEquals(exception.getMessage(), EXCEPTION_MESSAGE);
	   }*/
	 
	 
	@Test
	@DisplayName("Factorial Test (!)")
	void testFactorial() {
		assertAll(
				() -> assertEquals(1,obj.factorial(0)),
				() -> assertEquals(1,obj.factorial(1)),
				() -> assertEquals(120,obj.factorial(5))
				);
		
	}
	
	
}
