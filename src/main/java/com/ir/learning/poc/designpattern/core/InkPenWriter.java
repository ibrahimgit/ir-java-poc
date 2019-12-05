package com.ir.learning.poc.designpattern.core;

import org.apache.log4j.Logger;

import com.ir.learning.poc.designpattern.Writer;

public class InkPenWriter implements Writer {

	private static final Logger LOGGER = Logger.getLogger(InkPenWriter.class);
	
	@Override
	public void write(String text) {
		LOGGER.debug("Writing with ink pen: " + text);
	}

}
