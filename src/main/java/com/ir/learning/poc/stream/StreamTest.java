package com.ir.learning.poc.stream;

import java.util.stream.Stream;

public class StreamTest {
	
	public static void main(String[] args) {
		
		Stream.generate(() -> new String("Ibrahim")).forEach(intgr -> System.out.println(intgr));
		
	}
	
	

}
