package com.learning.junit.testing;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;


public class BasicMethodSources {
	
	public static Stream<Arguments> msMultipleArguments()
	{
		return Stream.of(Arguments.of(1, "A"), Arguments.of(2, "B"), Arguments.of(3, "C"));
	}

}
