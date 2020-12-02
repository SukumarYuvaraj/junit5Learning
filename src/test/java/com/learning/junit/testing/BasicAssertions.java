package com.learning.junit.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BasicAssertions {
	
	@Test
	void testAssertEqual() {
		 assertEquals("ABC", "ABC");
		 assertEquals(20, 20, "optional assertion message");
		 assertEquals(2 + 2, 4);
		 System.out.println("Executed --- testAssertEqual Method");
	}
	
	@Test
	void testAssertFalse() {
		 assertFalse("FirstName".length() == 11);
		 assertFalse(10 > 20, "assertion message");
		 System.out.println("Executed --- testAssertFalse Method");
	}
	
	
	@Test
	void testAssertNull() {
	     String str1 = null;
		 String str2 = "abc";
		 assertNull(str1);
		 assertNotNull(str2);	
		 System.out.println("Executed --- testAssertNull Method");
	}
	
	
	/**
	 * To make sure all the assertions are running irrespective of failures
	 */
	@Test
	void testAssertAll()
	{
		String str1 = "abc";
		String str2 = "def";
		String str3 = "ghi";
		assertAll("stringTest", () -> assertEquals(str1,"abc"),
				  () -> assertEquals(str2,"def"),
				  () -> assertEquals(str3,"ghi"));
		System.out.println("Executed --- testAssertAll Method");
	}
	
	
	@Test
	void testAssertTrue()
	{
		assertTrue("Yuvaraj".startsWith("Y"));
		System.out.println("Executed --- testAssertTrue Method");
	}
	
	
	@Test
	@DisplayName("This Method is meant to be failed")
	void testFail()
	{
		fail("This method implementation is not yet completed");
	}
	
	/**
	 * These methods are used to assert that expected and actual elements are same or not. 
	 * JUnit uses == operator for these methods to check if they are referring to same object or not.
	 */
	@Test
	void testAssertSame()
	{
		assertSame("Hello", "Hello");
		System.out.println("Executed --- testAssertSame Method");
	}
	
	@Test
	void testAssertNotSame()
	{
		assertNotSame("Hello", new String("Hello"));
		System.out.println("Executed --- testAssertNotSame Method");
	}
	
	
	/**
	 * Asserts that expected and actual arrays are deeply equal. The arrays elements are matched index by index.
	 */
	@Test
	@DisplayName("assertArrayEquals Examples")
	void testassertArrayEquals() {
		String[] s1 = { "A", "B" };
		String[] s2 = { "A", "B" };
		assertArrayEquals(s1, s2);
		assertArrayEquals(s1, s2, "My Custom Failure Message");
		System.out.println("Executed --- testassertArrayEquals Method");
	}


}
