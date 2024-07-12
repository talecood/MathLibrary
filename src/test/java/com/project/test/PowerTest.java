package com.project.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import com.project.mathlib.Power;

public class PowerTest {
	Power obj = new Power();
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
	@DisplayName("Power Test (^)")
	void testPower() {
	assertAll(
			() -> assertEquals(1,obj.power(1534, 0),"Power Test Failed"),
			() -> assertEquals(39,obj.power(39, 1),"Power Test Failed"),
			() -> assertEquals(64,obj.power(2, 6),"Power Test Failed"),
			() -> assertEquals(16,obj.power(-2, 4),"Power Test Failed"),
			() -> assertEquals(-27,obj.power(-3, 3),"Power Test Failed"),
			() -> assertEquals(81,obj.power(-3, 4),"Power Test Failed")
			);
	}
}
