package com.project.mathlib.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import com.project.mathlib.main.Factorial;
class FactorialTest {
	Factorial obj = new Factorial();
	TestInfo testinfo;
	TestReporter testreporter;
	
	@AfterEach
	void afterReport(TestInfo testinfo,TestReporter testreporter) {
		this.testinfo = testinfo;
		this.testreporter = testreporter;
		testreporter.publishEntry("Running "+testinfo.getDisplayName()+" with tags "+testinfo.getTags());
	}
	 
	@Test
	@DisplayName("Factorial Test (!)")
	void testFactorial() {
		assertAll(
				() -> assertEquals(1,obj.factorial(0)),
				() -> assertEquals(1,obj.factorial(1)),
				() -> assertEquals(120,obj.factorial(5))
				);
		
	}
	private static final String EXCEPTION_MESSAGE = "Factorial of Negative Numbers Cannot be Calculated";

	 @Test
	 @DisplayName(EXCEPTION_MESSAGE)
	 void testWhenNegativeInputProvidedShouldThrowException() {
	    ArithmeticException exception = assertThrows(ArithmeticException.class, () -> obj.factorial(-1));
	    assertEquals(EXCEPTION_MESSAGE,exception.getMessage());
	   }
	
	
}