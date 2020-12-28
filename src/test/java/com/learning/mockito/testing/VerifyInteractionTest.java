package com.learning.mockito.testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.calls;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class VerifyInteractionTest {

	@Disabled("Disabled for current Execution")
	@Test
	public void testMethod() {
		
		System.out.println("*** --- VerifyInteractionTest testMethod executed --- ***");
		
		@SuppressWarnings({"unchecked" })
		List<String> mockedList = Mockito.mock(List.class);
		
		mockedList.add("first-element");
		mockedList.add("second-element");
		mockedList.add("third-element");
		mockedList.add("third-element");
		
		mockedList.clear();
		
		verify(mockedList).add("first-element");
		verify(mockedList, VerificationModeFactory.times(2)).add("third-element");
		mockedList.clear();
		
	}

	@Disabled
	@Test
	public void simpleVerifyTest()
	{
		@SuppressWarnings({"unchecked" })
		List<String> mockList = Mockito.mock(List.class);
		mockList.add("Pankaj");
		mockList.size();
		
		//verify(mockList).add("Pankaj");
		verify(mockList).add(anyString());
		verify(mockList).add(any(String.class));
		verify(mockList).add(ArgumentMatchers.any(String.class));
		verify(mockList, times(1)).size();
		
		/*
		 * verify(mockList, times(1)).size(); //same as normal verify method
		 * verify(mockList, atLeastOnce()).size(); // must be called at least once
		 * verify(mockList, atMost(2)).size(); // must be called at most 2 times
		 * verify(mockList, atLeast(1)).size(); // must be called at least once
		 * verify(mockList, never()).clear(); // must never be called
		 */		
		verifyNoMoreInteractions(mockList);
		mockList.isEmpty();
		
		// isEmpty() is not verified, so below will fail if the below line is commented
		verify(mockList, times(1)).isEmpty();
		//NoMoreInteractions is similar to ZeroInteractions
		//verifyNoMoreInteractions(mockList);
		verifyZeroInteractions(mockList);

	}
	
	
	@Disabled
	@SuppressWarnings("rawtypes")
	@Test
	public void verifyOnlyMethod()
	{
		Map mockMap = Mockito.mock(Map.class);
		mockMap.isEmpty();
		//mockMap.clear();
		
		//Allows checking if given method was the only one invoked
		verify(mockMap, only()).isEmpty();
	}
	
	
	@Disabled
	@SuppressWarnings("rawtypes")
	@Test
	public void verifyInOrderMethod()
	{
		@SuppressWarnings("unchecked")
		List<String> mockList = Mockito.mock(List.class);
		Map mockMap = Mockito.mock(Map.class);
		
		InOrder inOrder = inOrder(mockList, mockMap);
		inOrder.verify(mockList).add("Pankaj");
		inOrder.verify(mockList, calls(1)).size();
		inOrder.verify(mockList).isEmpty();
		inOrder.verify(mockMap).isEmpty();
	}

}
