package com.learning.mockito.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

public class MockitoVoidMethodTest {


	/**
	 * If we want to throw an exception when method is called, we can use doThrow() method of mockito.
	 */
	@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void test_mockitoVoid_dothrow() {

		Employee emp = mock(Employee.class);
		doThrow(IllegalArgumentException.class).when(emp).setName(null);

		emp.setName(null);
	}
	
	
	/**
	 * If we just want to completely ignore the void method call, we can use doNothing().
	 */
	@Ignore
	@Test
	public void test_mockitoVoid_doNothing() {

		Employee emp = mock(Employee.class);
		doNothing().when(emp).setName(null);
		emp.setName(null);
	}
	
	
	/**
	 * If we do not want to call real method, however need to perform some runtime operation doAnswer is used.
	 */
	@Test
	public void test_mockitoVoid_doAnswer() {

		Employee emp = mock(Employee.class);

		doAnswer((i) -> {
			System.out.println("Employee setName Argument = " + i.getArgument(0));
			assertTrue("Pankaj".equals(i.getArgument(0)));
			return null;
		}).when(emp).setName(anyString());

		emp.setName("Pankaj");
		when(emp.getName()).thenReturn("Pankaj");
		assertEquals("Pankaj", emp.getName());

	}

	/**
	 * Sometimes it is necessary to call the real method from mocked object, in such case we need to use doCallRealMethod().
	 */
}
