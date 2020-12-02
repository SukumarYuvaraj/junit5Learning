package com.learning.junit.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;
import java.util.function.Predicate;

class BasicAssumptions {

	/**
	 * If Condition is not met then all the statements under the assumption will be skipped
	 */
	@Test
	void testAssumeTrue() {
	     boolean b = 5 > 2;
	     assumeTrue(b);
	     System.out.println("Getting Executed based on above assumption holds true");
	     assertEquals("Hello", "Hello");
	}
	
	
	/**
	 * If Condition is not met then all the statements under the assumption will be skipped
	 */
	@Test
	@DisplayName("Test executes only on Monday")
	void testAssumeTrueFriday()
	{
		     LocalDateTime dt = LocalDateTime.now();
		     assumeTrue(dt.getDayOfWeek().getValue() == 1);
		     System.out.println("further code will execute only if above assumption holds true");
		     assertEquals("Hello", "Hello");
	}
	

	/**
	 * If Condition is not met then all the statements under the assumption will be skipped
	 */
	@Test
	void testAssumeFalse() {
	     boolean b = 'A' == 'B';
	     assumeFalse(b);
	     System.out.println("Getting Executed based on above assumption holds false: Start");
	     assertEquals("Hello", "Hello");
	     System.out.println("Getting Executed based on above assumption holds false: End ");
	}
	
	
	/**
	 * If the condition is not met then the code enclosed by lambda function alone will not be executed
	 */
	@Test
	void testAssumingThat()
	{
		final String testEnvironment = "test";
		System.setProperty("env", testEnvironment);
	    Predicate<String> predicate  = Predicate.isEqual(testEnvironment);

	    //Specific block will be executed if the below assumption holds true
		assumingThat(predicate.test(testEnvironment), () -> 
		{
			assertEquals(10, 10);
            System.out.println("perform below assertions only on the test env");
		});
		
		assertEquals(20, 20);
	    System.out.println("perform below assertions on all env");
		
	}
	
}
