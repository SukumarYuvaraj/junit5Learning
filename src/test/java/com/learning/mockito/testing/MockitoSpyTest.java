package com.learning.mockito.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * By Default it will provide class implementation and it will 
 * also allow us to mock the values 
 *
 */

class MockitoSpyTest {
	
	@Spy
	Utils mockUtils;
	
	@BeforeEach
	private void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testSpy() {
		
		System.out.println(" *** --- MockitoSpyTest testSpy executed --- *** ");
		List<String> list = new ArrayList<String>();
		List<String> listSpy = spy(list);
		
		listSpy.add("first-element");
		System.out.println(listSpy.get(0));
		assertEquals("first-element", listSpy.get(0));
		
		when(listSpy.get(0)).thenReturn("second-element");
		System.out.println(listSpy.get(0));
		assertEquals("second-element", listSpy.get(0));
	}
	
	
	/**
	 * If we want to mock only specific behaviors and call the real methods for unstubbed behaviors, 
	 * then we can create a spy object using Mockito spy() method.
	 */
	@Test
	void testSpyObject()
	{
		List<String> list = new ArrayList<>();
		List<String> spyOnList = spy(list);
		
		when(spyOnList.size()).thenReturn(10);
		assertEquals(10, spyOnList.size());
		
		//calling real methods since below methods are not stubbed
		spyOnList.add("Pankaj");
		spyOnList.add("Meghna");
		assertEquals("Pankaj", spyOnList.get(0));
		assertEquals("Meghna", spyOnList.get(1));
	}
	
	
	/**
	 * We can use Mockito Spy to partial mock an object. 
	 * When we spy on an object, the real methods are being called unless it’s stubbed.
	 */
	@Test
	void testAnnotationSpyObject()
	{
		when(mockUtils.process(1, 1)).thenReturn(5);
		//mocked method
		assertEquals(5, mockUtils.process(1, 1));
		//real method called since it's not stubbed
		assertFalse(50 < mockUtils.process(20, 20));
	}

}
