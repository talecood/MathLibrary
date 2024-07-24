package com.project.mathlib.test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

import com.project.mathlib.main.Area;

public class AreaTest {
	Area objectArea= new Area();
	
	TestInfo testinfo;
	TestReporter testreporter;
	
	@BeforeEach
	void setUp(TestInfo testinfo,TestReporter testreporter) {
	objectArea = new Area();
	this.testinfo = testinfo;
	this.testreporter = testreporter;
	}
	@AfterEach
	void afterEach() {
		  testreporter.publishEntry("Running " + testinfo.getDisplayName() + " with tags " + testinfo.getTags());
	}
	
	@Nested
	@DisplayName("Area Test for Objects")
	class AreaTests{
		@Tag("Basic Objects")
		@Test
		@DisplayName("Square Area Test")
		void ShouldReturnAreaOfSquare() {
			assertAll(
					()-> assertEquals(1,objectArea.squareArea(1),"Square Test Failed"),
					()-> assertEquals(0,objectArea.squareArea(0),"Square Test Failed"),
					()-> assertEquals(100,objectArea.squareArea(10),"Square Test Failed")
					);
		try {
			assertEquals(100,objectArea.squareArea(-10));
			fail("Should Have thrown IllegalArgumentException");
		}	catch(Exception e) {
			assertEquals(objectArea.POSITIVE_BASE,e.getMessage());
		}
	}
		
	@Tag("Basic Objects")
	@Test
	@DisplayName("Rectangle Area Test")
	void ShouldReturnAreaOfRectangle() {
			assertAll(
					() -> assertEquals(0,objectArea.rectangleArea(0, 5),"Rectangle Test Failed"),
					() -> assertEquals(10,objectArea.rectangleArea(2, 5),"Rectangle Test Failed")
					);
			try {
				assertEquals(-5,objectArea.rectangleArea(-5, 1));
				assertEquals(10,objectArea.rectangleArea(-2, -5));
				fail("Should have thrown IllegalArgumentException");
			}
			catch(Exception e) {
				assertEquals(objectArea.POSITIVE_BASE+objectArea.POSITIVE_HEIGHT,e.getMessage());
			}
	}
	@Tag("Basic Objects")
	@Test
	@DisplayName("Circle Area Test")
	void ShouldReturnAreaOfCircle() {
		assertAll(
				() -> assertEquals(50.26548245743669,objectArea.circleArea(4)),
				() -> assertEquals(0,objectArea.circleArea(0))
				);
		
		try {
			assertEquals(78,5398,objectArea.circleArea(-5));
		}
		catch(Exception e) {
			assertEquals(objectArea.POSITIVE_RADIUS,e.getMessage());
		}
		
	}
	@Tag("Basic Objects")
	@Test
	@DisplayName("Triangle Area Test")
	void ShouldReturnAreaOfTriangle() {
		assertAll(
				() -> assertEquals(12.0,objectArea.triangleArea(3.0, 8.0)),
				() -> assertEquals(0.0,objectArea.triangleArea(0.0, 3.0))
				);
		try {
			assertEquals(-100,objectArea.triangleArea(-50.0, 4.0),"Triangle Test Failed");
			assertEquals(-100,objectArea.triangleArea(50.0, -4.0),"Triangle Test Failed");
			assertEquals(100,objectArea.triangleArea(-50.0, -4.0),"Triangle Test Failed");
		}
		catch(Exception e) {
			assertEquals(objectArea.POSITIVE_BASE+objectArea.POSITIVE_HEIGHT,e.getMessage());
		}
	}
	@Tag("Basic Objects")
    @Test
    @DisplayName("Parallelogram Area Test")
    void shouldReturnAreaOfParallelogram() {
        assertAll(
                () -> assertEquals(20.0, objectArea.parallelogramArea(5.0, 4.0)),
                () -> assertEquals(0.0, objectArea.parallelogramArea(0.0, 4.0))
        );
        try {
			assertEquals(-100,objectArea.parallelogramArea(-50.0, 2.0),"Triangle Test Failed");
			assertEquals(-100,objectArea.parallelogramArea(50.0, -2.0),"Triangle Test Failed");
			assertEquals(100,objectArea.parallelogramArea(-50.0, -2.0),"Triangle Test Failed");
		}
		catch(Exception e) {
			assertEquals(objectArea.POSITIVE_BASE+objectArea.POSITIVE_HEIGHT,e.getMessage());
		}
	}
	@Tag("Basic Objects")
	@Test
	@DisplayName("Trapezium Area Test")
	void shouldReturnAreaOfTrapezium() {
		assertAll(
				() ->	assertEquals(16.0,objectArea.trapeziumArea(3,5,4)),
				() ->	assertEquals(0,objectArea.trapeziumArea(6, 2, 0))
				);
		try {
			assertEquals(16.0,objectArea.trapeziumArea(-5, 13, 4));
			assertEquals(16.0,objectArea.trapeziumArea(29, -13, 4));
			assertEquals(16.0,objectArea.trapeziumArea(-5, -3, -4));
		}
		catch(Exception e) {
			assertEquals(objectArea.POSITIVE_BASE+objectArea.POSITIVE_HEIGHT,e.getMessage());
		}
	}
	
		
		
	}
}
