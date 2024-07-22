package com.project.test;

import static org.assertj.core.api.Assertions.byLessThan;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.intThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import com.project.mathlib.Factorial;
import static org.mockito.Mockito.when;

import org.hamcrest.Matchers;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.AdditionalMatchers.gt;
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
	 public void testWhenNegativeInputProvidedShouldThrowException() {
	    ArithmeticException exception = assertThrows(ArithmeticException.class, () -> obj.factorial(-1));
	    assertEquals(exception.getMessage(), EXCEPTION_MESSAGE);
	   }
	
	
}





//		ArithmeticException exception = assertThrows(ArithmeticException.class, () -> objM.factorial(intThat((ArgumentMatcher<Integer>) Matchers.lessThan(0))));
