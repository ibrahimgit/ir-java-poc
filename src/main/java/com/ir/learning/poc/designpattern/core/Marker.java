package com.ir.learning.poc.designpattern.core;

import org.springframework.stereotype.Service;

@Service
public class Marker {
	
	public void mark(String text) {
		System.out.println("Writing with marker: " + text);
	}

}
