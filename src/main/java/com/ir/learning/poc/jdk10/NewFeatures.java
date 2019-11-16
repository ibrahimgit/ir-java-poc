package com.ir.learning.poc.jdk10;

import java.util.List;

public class NewFeatures {
	
	public static void main(String[] args) {
		
		doSomething();
	}

	private static void doSomething() {
		
		var number = 10;
		var name = "dfdds";
		
		var list = List.of("2", "1", "t", "2", "1", "t", "2", "1", "t", "4", "");
		
		for(var str : list) {
			str.concat(str);
		}
		
	}

}
