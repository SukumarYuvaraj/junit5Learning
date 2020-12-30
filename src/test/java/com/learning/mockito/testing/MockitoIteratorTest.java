package com.learning.mockito.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import java.util.Iterator;

public class MockitoIteratorTest {

	/**
	 *  To provide different responses in the thenReturn() method through var-args.
	 */
	@Test
	public void test_VarArgsResponse() {
		
		Utils mockUtils = Mockito.mock(Utils.class);
		
		when(mockUtils.update("Emp")).thenReturn("EMP", "EMPLOYEE", "EMP1");
		when(mockUtils.update("Emp")).thenReturn("EMP", "EMPLOYEE", "EMP1");

		assertEquals("EMP", mockUtils.update("Emp"));
		assertEquals("EMPLOYEE", mockUtils.update("Emp"));
		assertEquals("EMP1", mockUtils.update("Emp"));
		assertEquals("EMP1", mockUtils.update("Emp"));
	}
	
	/**
	 * Mockito Iterator Methods Stubbing
	 */
	@Test
	public void test_IteratorTest()
	{
		Iterator<Integer> mockIter = Mockito.mock(Iterator.class);
		when(mockIter.hasNext()).thenReturn(true, true, true, false);
		int[] values = new int[] {1,2,3,4};
		when(mockIter.next()).thenReturn(values[0], values[1], values[2], values[3]);

		int index = 0;
		while(mockIter.hasNext()) {
			assertTrue(values[index] == mockIter.next());
			index++;
		}
	}

}
