package com.learning.mockito.testing;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CalcService2Test {
	
	@InjectMocks
	CalcService calcService;
	
	@Mock
	AddService addService;
	
	/**
	 * we need to call MockitoAnnotations.initMocks(this); to initialize objects annotated 
	 * with @Mock, @Spy, @Captor, or @InjectMocks.
	 */
	@BeforeEach
	public void setup() {
		MockitoAnnotations.initMocks(this);
		calcService = new CalcService(addService);
	}

	@Test
	void testCalc_AssertEquals() {
		System.out.println("*** --- CalcService2Test testCalc method executed --- ***");
		
		int num1 = 11;
		int num2 = 12;
		int expectedValue = 23;

		when(addService.add(num1, num2)).thenReturn(expectedValue);
		int actualValue = calcService.calc(num1, num2);

		assertEquals(expectedValue, actualValue);
	}
	
}
