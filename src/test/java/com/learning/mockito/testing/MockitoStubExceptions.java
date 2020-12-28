package com.learning.mockito.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MockitoStubExceptions {

	@Test
	void test() {
		@SuppressWarnings("unchecked")
		List<String> list = Mockito.mock(List.class);
		when(list.size()).thenThrow(new RuntimeException("RunTime Exception"));
		
		Exception exception = assertThrows(RuntimeException.class, ()-> list.size());
		
		assertEquals("RunTime Exception", exception.getMessage());
	}

}
