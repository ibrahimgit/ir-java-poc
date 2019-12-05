package com.ir.learning.poc.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FutureTaskTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FutureTaskTest.class);
	
	public static void main(String[] args) {
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		LOGGER.info("Initializing the job...");
		Future<Boolean> futureTask = newCachedThreadPool.submit(new Callable<Boolean>() {

			@Override
			public Boolean call() throws Exception {
				LOGGER.info(" I am called");
				Thread.sleep(10000);
				LOGGER.info(" I am finished");
				return Boolean.TRUE;
			}
		});
		LOGGER.info("Job Submitted....");
		Boolean response = false;
		try {
			response = futureTask.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LOGGER.info("Got the response.... " + response);
		newCachedThreadPool.shutdown();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				LOGGER.info("*****called when program is terminated.....");
			}
		});
		
		System.exit(0);
	}

}
