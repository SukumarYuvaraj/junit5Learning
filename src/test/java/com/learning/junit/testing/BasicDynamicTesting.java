package com.learning.junit.testing;

import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class BasicDynamicTesting {

	/**
	 * JUnit 5 Dynamic tests functionality can be achieved by parameterized tests.
	 * Also, Parameterized tests follow the standard JUnit test lifecycle and 
	 * @BeforeEach and @AfterEach methods are executed for them. Whereas dynamic
	 * tests lifecycle is totally different and they don’t have access to @BeforeEach and @AfterEach methods.
	 * @return
	 */
	@TestFactory
	Stream<DynamicTest> dynamicTestExample()
	{
		List<Integer> input1List = Arrays.asList(1,2,3);
		List<Integer> input2List = Arrays.asList(10,20,30);
		
		List<DynamicTest> dynamicTests = new ArrayList<>();
		
		for(int i=0; i < input1List.size(); i++) {
			int x = input1List.get(i);
			int y = input2List.get(i);
			DynamicTest dynamicTest = DynamicTest.dynamicTest("Dynamic Test for MyUtils.add("+x+","+y+")", () ->
			{
				assertEquals(x+y, MyUtils.add(x,y));
			});
			
			dynamicTests.add(dynamicTest);
		}
		
		return dynamicTests.stream();
	}
}
