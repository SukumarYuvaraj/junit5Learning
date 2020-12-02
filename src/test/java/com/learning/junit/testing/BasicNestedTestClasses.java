package com.learning.junit.testing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


/**
 * Nested tests allow to create nested classes and execute all of its test methods. The inner classes must be non-static. 
 * Just annotate inner classes with @Nested and all test methods inside it will be executed.
 *
 */
class BasicNestedTestClasses {

	@BeforeAll
	static void beforeAll() {
	     System.out.println("**--- BasicNestedTestClasses :: beforeAll :: Executed once before all test methods ---**");
	}
	 
	@BeforeEach
	void beforeEach() {
		 System.out.println("**--- BasicNestedTestClasses :: beforeEach :: Executed before each test method ---**");
	}

	@AfterEach
	void afterEach() {
		 System.out.println("**--- BasicNestedTestClasses :: afterEach :: Executed after each test method ---**");
	}

	@AfterAll
	static void afterAll() {
		 System.out.println("**--- BasicNestedTestClasses :: afterAll :: Executed after all test method ---**");
	}
	 
	     @Nested
	     class InnerClass {
	 
	          @BeforeEach
	          void beforeEach() {
	               System.out.println("**--- InnerClass :: beforeEach :: Executed before each test method ---**");
	          }
	 
	          @AfterEach
	          void afterEach() {
	        	   System.out.println("**--- InnerClass :: afterEach :: Executed after each test method ---**");
	          }
	 
	          @Test
	          void testMethod1() {
	        	   System.out.println("**--- InnerClass :: testMethod1 :: Executed test method1 ---**");
	          }
	 
	          @Nested
	          class InnerMostClass {
	 
	               @BeforeEach
	               void beforeEach() {
	                    System.out.println("**--- InnerMostClass :: beforeEach :: Executed before each test method ---**");
	               }
	 
	               @AfterEach
	               void afterEach() {
	            	    System.out.println("**--- InnerMostClass :: afterEach :: Executed after each test method ---**");
	               }
	 
	               @Test
	               void testMethod2() {
	            	    System.out.println("**--- InnerMostClass :: testMethod2 :: Executed test method2 ---**");
	               }
	        }
	    }
	     
}

