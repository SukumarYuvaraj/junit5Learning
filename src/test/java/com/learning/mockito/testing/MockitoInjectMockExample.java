package com.learning.mockito.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

class MockitoInjectMockExample {
	
	/**
	 *  @InjectMock creates an instance of the class and 
	 *  injects the mocks that are marked with the annotations @Mock into it.
	 */
	@InjectMocks
	Fruits fruits;
	
	@Mock
	List<String> mockList;
	
	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void test() {
		
		when(mockList.get(0)).thenReturn("Apple");
		when(mockList.size()).thenReturn(1);
		
		assertEquals("Apple", mockList.get(0));
		assertEquals(1, mockList.size());
		
		assertEquals("Apple", fruits.getNames().get(0));
		assertEquals(1, fruits.getNames().size());
		
	}

}
