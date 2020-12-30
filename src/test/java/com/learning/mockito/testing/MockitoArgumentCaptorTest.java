package com.learning.mockito.testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.verify;

public class MockitoArgumentCaptorTest {
	
	@Captor 
	ArgumentCaptor<Long> acLong = ArgumentCaptor.forClass(Long.class);


	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Test
	@Ignore
	public void test_ArgumentCaptor() {
		
		MathUtils mockMathUtils = Mockito.mock(MathUtils.class);
		when(mockMathUtils.add(1, 1)).thenReturn(2);

		when(mockMathUtils.isInteger(anyString())).thenReturn(true);
		
		ArgumentCaptor acInteger = ArgumentCaptor.forClass(Integer.class);
		ArgumentCaptor acString = ArgumentCaptor.forClass(String.class);
		
		 assertEquals(2, mockMathUtils.add(Integer.valueOf(1), Integer.valueOf(1)));
		 verify(mockMathUtils).add((int) acInteger.capture(), (int) acInteger.capture());
		 Integer value = (Integer) acInteger.getValue();
		 assertEquals(1, value.intValue());
			
		
		 assertTrue(mockMathUtils.isInteger("1"));
		 assertTrue(mockMathUtils.isInteger("999"));
		 verify(mockMathUtils, times(2)).isInteger((String) acString.capture()); 
		 List allStringValues = acString.getAllValues();
		 List<String> expectedList = new ArrayList();
		 expectedList.add("1");
		 expectedList.add("999");
		 assertEquals(expectedList, allStringValues);
		

	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	@Ignore
	public void test_ArugmentCaptorStack()
	{
		Stack stack = Mockito.mock(Stack.class);
		ArgumentCaptor argumentCaptor = ArgumentCaptor.forClass(String.class);
		stack.add("Java Code Geeks");
		Mockito.verify(stack).add(argumentCaptor.capture());
		System.out.println("The captured values is :"+argumentCaptor.getValue());
		assertEquals("Java Code Geeks", argumentCaptor.getValue());
	}
	
	@Test
	public void test_ArgumentCaptorAnnotation() {
		MathUtils mockMathUtils = Mockito.mock(MathUtils.class);
		when(mockMathUtils.squareLong(2L)).thenReturn(4L);
		assertEquals(4L, mockMathUtils.squareLong(2L));
		verify(mockMathUtils).squareLong(acLong.capture());
		System.out.println("The captured values is :"+acLong.getValue());
	}
		

}
