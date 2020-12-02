package com.learning.junit.testing;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;


/**
 * The lambda function code is the code that is put under test
 *
 */
class BasicAssertThrows {

	@Test
	public void whenDerivedExceptionThrown_thenAssertionSucceds() {
	    Exception exception = assertThrows(NumberFormatException.class, () -> {
	    	System.out.println("Code that is put under testing");
	        Integer.parseInt("1a");
	    });
	 
	    String expectedMessage = "For input string";
	    String actualMessage = exception.getMessage();
	 
	    assertTrue(actualMessage.contains(expectedMessage), "Test case succeeded");
	}


}
