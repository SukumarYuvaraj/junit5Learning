package com.learning.mockito.testing;

import org.junit.Ignore;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyList;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import org.mockito.AdditionalMatchers;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockitoArgumentMatchersTest {

	/**
	 * We shall pass any argument of given Type
	 */
	@Ignore
	@Test
	public void test_ArgumentMatcherAny() {
	
		Foo foo = mock(Foo.class);
		when(foo.bool(any(String.class), anyInt(), any(Object.class))).thenReturn(true);
		
		assertTrue(foo.bool("A", 1, "A"));
		assertTrue(foo.bool("B", 10, new Object()));

	}
	
	
	/**
	 * To pass equivalent value of the given type.. 
	 * To stub any collection like anyList()/anyBoolean value 
	 */
	@Test
	public void test_ArgumentMatcherEq() {
	
		Foo foo = mock(Foo.class);
		when(foo.bool(any(String.class), eq(10), any(Object.class))).thenReturn(true);
		
		assertTrue(foo.bool("B", 10, new Object()));
		when(foo.in(anyBoolean(), anyList())).thenReturn(10);
		
		assertEquals(10, foo.in(true, new ArrayList<String>()));
	}
	
	
	/**
	 * org.mockito.AdditionalMatchers class provides some rarely used matchers. 
	 * We can specify arguments to be greater than, less than, perform OR, AND, NOT operations. 
	 * We can also check for equality of arrays.
	 */
	@Test
	public void test_AdditionalMatchers() {
	
		Foo foo = mock(Foo.class);
		when(foo.bar(any(byte[].class), AdditionalMatchers.aryEq(new String[] { "A", "B" }),
				AdditionalMatchers.gt(10))).thenReturn(11);
		
		assertEquals(11, foo.bar("abc".getBytes(), new String[] { "A", "B" }, 20));
		
		verify(foo, atLeast(0)).bool(anyString(), anyInt(), any(Object.class));
	}

}
