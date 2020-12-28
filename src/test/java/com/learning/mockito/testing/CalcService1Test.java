package com.learning.mockito.testing;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Using Mockito.mock() method
 *
 */
class CalcService1Test {

	@Test
	void testCalc() {
		System.out.println("*** --- CalcService1Test testCalc method executed --- ***");

		AddService addService;
		CalcService calcService;

		addService = Mockito.mock(AddService.class);
		calcService = new CalcService(addService);

		int num1 = 11;
		int num2 = 12;
		int expectedValue = 23;

		when(addService.add(num1, num2)).thenReturn(expectedValue);
		int actualValue = calcService.calc(num1, num2);

		assertEquals(expectedValue, actualValue);

	}

}
