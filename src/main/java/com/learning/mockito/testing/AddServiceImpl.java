package com.learning.mockito.testing;

public class AddServiceImpl implements AddService {

	@Override
	public int add(int num1, int num2) {
		
		System.out.println("*** --- AddServiceImpl add method executed --- ***");
		return num1+num2;
	}

}
