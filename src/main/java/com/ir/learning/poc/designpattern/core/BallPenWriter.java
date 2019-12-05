package com.ir.learning.poc.designpattern.core;


import com.ir.learning.poc.designpattern.Writer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BallPenWriter implements Writer {

	@Override
	public void write(String text) {
		log.info("Writing with ball pen: {}", text);

	}

}
