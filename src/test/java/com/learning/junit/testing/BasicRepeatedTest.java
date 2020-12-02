package com.learning.junit.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicRepeatedTest {

	@Disabled
	@RepeatedTest(4)
	void repeatedTest() {
		System.out.println("@RepeatedTest Simple Example");
	}
	
	
	@RepeatedTest(value=2, name="{displayName} {currentRepetition}/{totalRepetitions}")
	@DisplayName("MyTestMethod ☺")
	void test_with_cutom_DisplayName(TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}
	
	@Disabled("Explicitly Disabled")
	@RepeatedTest(3)
	void test_with_RepetitionInfo_Injection(RepetitionInfo repetitionInfo) {
		System.out.println("@RepeatedTest with RepetitionInfo Injection");
		assertEquals(3, repetitionInfo.getTotalRepetitions());
		
		System.out.println("Current Test Count = "+repetitionInfo.getCurrentRepetition());
	}

}
