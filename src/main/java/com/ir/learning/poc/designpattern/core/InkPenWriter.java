package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Writer;

public class InkPenWriter implements Writer {

	@Override
	public void write(String text) {
		System.out.println("Writing with ink pen: " + text);
	}

}
