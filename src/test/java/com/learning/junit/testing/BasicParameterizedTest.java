package com.learning.junit.testing;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;

import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class BasicParameterizedTest {
	
	@Disabled
	@ParameterizedTest
	@ValueSource(ints = {1, 20, 3, 5, 60})
	void testParameterizedTestWithValueSource(int i)
	{
		assumingThat(i < 10, () -> 
		{
			System.out.println("Given value "+i +" is lesser than 10");
		});
		
		assumeFalse(i < 10);
		System.out.println("Given value "+i +" is greater than 10");
	}
	
	enum Days {
		Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
		}
	
	@Disabled
	@ParameterizedTest
	@EnumSource(BasicParameterizedTest.Days.class)
	void testEnumSource(BasicParameterizedTest.Days days)
	{
		System.out.println("The Given Days are :"+days);
	}
		
	static Stream<String> ms() {
		return Stream.of("A", null, "B");
	}
	
	
	/**
	 * We shall use Objects as well and it is not limited to primitive alone
	 * @param s
	 */
	@Disabled
	@ParameterizedTest
	@MethodSource("ms")
	void testMethodSource(String s)
	{
		assertAll("stringTest", () ->
		{
			assertNotNull(s);
			System.out.println("The Given string is "+s);
		});
	}
	

	@Disabled
	@ParameterizedTest
	@MethodSource("com.learning.junit.testing.BasicMethodSources#msMultipleArguments")
		void test_MethodSource_MultipleParams(int i, String s) {
			assertTrue(4 > i);
			assertTrue(Arrays.asList("A", "B", "C").contains(s));
			System.out.println("The given int value "+i +" is lesser than 4  and the given String "+s 
					+ " available in our list");
	}
	
	/**
	 * Also refer @CsvFileSource - where entire CSV file shall be used to test our logic
	 * @param i
	 * @param s
	 */
	
	@ParameterizedTest
	@CsvSource(delimiter='|', value= {"1|'A'","2|B"})
	void test_CsvSource(int i, String s) {
		assertTrue(3 > i);
		assertTrue(Arrays.asList("A", "B", "C").contains(s));
		System.out.println("The given int value "+i +" is lesser than 3  and the given String "+s 
				+ " available in our list");
	}
	
}
