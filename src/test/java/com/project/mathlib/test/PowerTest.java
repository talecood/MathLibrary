package com.project.mathlib.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static com.googlecode.catchexception.CatchException.*;

import com.googlecode.catchexception.throwable.*;
import com.project.mathlib.main.Power;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

@SuppressWarnings("unused")
class PowerTest {
	Power obj = new Power();
	TestInfo testinfo;
	TestReporter testreporter;
	
	@AfterEach
	void afterReport(TestInfo testinfo,TestReporter testreporter) {
		this.testinfo = testinfo;
		this.testreporter = testreporter;
		testreporter.publishEntry("Running "+testinfo.getDisplayName()+" with tags "+testinfo.getTags());
	}
	
	@Test
	@DisplayName("Power Test For Positive Exponents(^)")
	void positiveExponentPowerTest(){
	assertAll(
			() -> assertEquals(1,obj.power(1534, 0),"Power Test Failed"),
			() -> assertEquals(39,obj.power(39, 1),"Power Test Failed"),
			() -> assertEquals(64,obj.power(2, 6),"Power Test Failed")
			);
	}
	@Test
	@DisplayName("Power Test For Negative Exponents")
	void negativeExponentsPowerTest(){
		assertAll(
				() -> assertEquals(0.02631578947368421,obj.power(38, -1),"Power Test Failed"),
				() -> assertEquals(0.015625,obj.power(2, -6),"Power Test Failed")
				);
	}
	@Test
	@DisplayName("Power Test for Zero Base")
	void zeroBasePowerTest() {
		assertEquals(0,obj.power(0, 5));
		assertEquals(0,obj.power(0, -17));

	}
	
	@Test
	@DisplayName("Power Test For Zero Exponent")
	void zeroExponentPowerTest() {
		assertAll(
				() -> assertEquals(1,obj.power(1534, 0),"Power Test Failed"),
				() -> assertEquals(1,obj.power(-53234, 0),"Power Test Failed")
				);
	}
	@Test
	@DisplayName("Power Test For Zero Exponent & Zero Base (0^0)")
	void zeroExponentAndZeroBase(){	
	
		assertThrows(ArithmeticException.class,()->obj.power(0, 0)
												,"0^0 is undefined.");
	}
}
