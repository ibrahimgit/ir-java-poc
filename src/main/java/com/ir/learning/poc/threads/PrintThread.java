package com.ir.learning.poc.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintThread implements Runnable {

	@Override
	public void run() {
		log.info("Print Thread");
	}

}
