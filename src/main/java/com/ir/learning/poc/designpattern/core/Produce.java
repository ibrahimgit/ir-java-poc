package com.ir.learning.poc.designpattern.core;

import com.ir.learning.poc.designpattern.Workshop;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Produce implements Workshop {

	@Override
	public void work() {
		log.info("Produce");

	}

}
