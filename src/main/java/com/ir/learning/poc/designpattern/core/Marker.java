package com.ir.learning.poc.designpattern.core;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Marker {
	
	public void mark(String text) {
		log.info("Writing with marker: {}", text);
	}

}
