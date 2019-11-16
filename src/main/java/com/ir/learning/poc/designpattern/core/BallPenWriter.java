package com.ir.learning.poc.designpattern.core;


import org.springframework.stereotype.Service;

import com.ir.learning.poc.designpattern.Writer;

@Service
public class BallPenWriter implements Writer {

	@Override
	public void write(String text) {
		System.out.println("Writing with ball pen: " + text);

	}

}
