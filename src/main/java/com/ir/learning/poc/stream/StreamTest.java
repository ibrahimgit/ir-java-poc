package com.ir.learning.poc.stream;

import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class StreamTest {
	
	private static final Logger LOGGER = Logger.getLogger(StreamTest.class);
	
	public static void main(String[] args) {
		
		Stream.generate(() -> new String("Ibrahim")).forEach(intgr -> LOGGER.info(intgr));
		
	}
	
	

}
