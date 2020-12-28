package com.learning.mockito.testing;

import java.util.List;

public class Fruits {
	
	private List<String> names;

	public Fruits(List<String> names) {
		this.names = names;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

}
