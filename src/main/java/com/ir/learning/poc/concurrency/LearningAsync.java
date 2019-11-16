package com.ir.learning.poc.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

import com.ir.learning.poc.domainmodel.Car;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LearningAsync {
	
	private static final String[] COLORS = new String[] {"red", "white", "green", "blue", "brown", "pink", "silver", "orange", "black", "yellow"};

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// https://dzone.com/articles/20-examples-of-using-javas-completablefuture
		//CompletableFuture<Void> cf = completableFutureDemo();
		//CompletableFuture<Void> cf2 = completableFutureDemo2();
		//threadPoolExecutorDemo();
		// Thread.sleep(4000);// waiting, may be, async task running in daemon thread still running
		// log.info("main thread waking up from deep slumber")
		// or
		// wait for joining the async daemon thread
		
		//cf.join(); // join is blocked ops that waits for task to be completed
		//log.info("async daemon thread completed and joined to main thread");
		
		//cf2.join();
		//log.info("All async tasks completed and joined to main thread");
		
		// CompletableFuture<Void> cf3 = completableFutureWithExceptionDemo();
		// cf3.join();
		
		CompletableFuture<Void> fc4 = realLifeDemo();
		fc4.join();
		
	}

	private static CompletableFuture<Void> completableFutureWithExceptionDemo() {
		
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> task1("testing", 1000l))
			.thenApplyAsync(input -> task2(input, " testing2", 1000l)) // then is a blocking operation on pervious op
			.thenApply(input -> exceptionTask(input, " testing3", 1000l))
			.thenApplyAsync(input -> task2(input, " ibrahim", 1000l))
			.exceptionally(th -> th.getMessage()) // this will gracefully handle any runtime exception occurring in above execution
			.thenApplyAsync(input -> task2(input, " testing4", 1000l))
			.thenApplyAsync(input -> exceptionTask(input, " testing5", 1000l)) //this may throw exception
			.thenAccept(msg -> log.info(msg));
		
		log.info("just executed exception tasks asynchronously");
		return cf;
		
	}

	private static void threadPoolExecutorDemo() throws InterruptedException, ExecutionException {
			ExecutorService executor = Executors.newSingleThreadExecutor();
			Future<String> futureResult = executor.submit(() -> task1("Hello stupid", 2000l));
			log.info("just executed the task");
			log.info("Lenght: " + futureResult.get().length()); // this is blocking on main thread
			log.info("just got the result");
			executor.shutdown();
	}

	private static CompletableFuture<Void> completableFutureDemo() throws InterruptedException {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> task1("Hello man", 5000l))//it runs in a daemon thread - By default (when no Executor is specified), asynchronous execution uses the common ForkJoinPool implementation, which uses daemon threads to execute the Runnable task. 
		.thenApply(String::length)//It uses the same daemon thread
		.thenAccept(len -> log.info("Async Length: " + len));////It uses the same daemon thread
		
		log.info("just executed a task asynchronously");
		
		return cf;
	}
	
	private static CompletableFuture<Void> completableFutureDemo2() {
		CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> task1("Hello world", 1000l))
			.thenApplyAsync(input -> task2(input, " from Aliens", 4000l)) // it may run in different daemon thread
			.thenApplyAsync(input -> task2(input, " and from God", 3000l))
			.thenAcceptAsync(input -> log.info(input));
		log.info("just executed all tasks asynchronously");
		return cf;
	}
	
	private static String exceptionTask(String input, String input2, Long sleepTime) {
		log.info("exception thread: " + Thread.currentThread().getName());
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if ((new Random().nextInt() % 2) == 0) {
			throw new RuntimeException("even excception");
		}
		return input.concat(input2);
	}

	private static String task2(String input, String input2, Long sleepTime) {
		log.info("Task2 thread: " + Thread.currentThread().getName());
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return input.concat(input2);
	}

	private static String task1(String message, Long sleepTime) {
			log.info(message + " from Task1 thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return message;
	}
	
	private static CompletableFuture<Void> realLifeDemo() {
		CompletableFuture<Void> task = CompletableFuture.supplyAsync(() -> getCars()) // fetching cars asynchronously
				.thenApplyAsync(cars -> {
					log.info("Got all cars");
					return cars.stream()
							.map(car -> // registering and customizing each car
								CompletableFuture.supplyAsync(() -> registerCar(car)).thenApplyAsync(LearningAsync::customizeCar)
							)
							.collect(Collectors.toList());
				}) //processing each car asynchronously and returning a future list
				.thenAcceptAsync(futureCars -> {
					log.info("got the futur cars");
					CompletableFuture<Car>[] futures = futureCars.toArray(new CompletableFuture[futureCars.size()]);
					CompletableFuture.allOf(futures) // allOf is not a blocking op that waits for all futures to be completed, use join to wait
					.whenComplete((v, th) -> { //when all future task completed, this will be called
						log.info("future is ready");
						futureCars.stream()
						.map(CompletableFuture::join) // retrieving the data from future
						.collect(Collectors.toList()) // collecting all ready data
						.stream()
						.forEach(car -> log.info(car.toString())); // displaying message
					})
					.join(); //blocked waiting for all future task to be completed
				});
		log.info("just executed fleet processing asynchronously");
		return task;
	}
	
	private static Car customizeCar(Car car) {
		log.info("customizing cars");
		addSomeDelay();
		int index = new Random().nextInt(9);
		car.setColor(COLORS[index]);
		return car;
	}
	
	private static Car registerCar(Car car) {
		log.info("registering cars");
		addSomeDelay();
		car.setRegistrationNumber(new Random().nextInt());
		return car;
	}

	private static List<Car> getCars() {
		log.info("fetching cars");
		addSomeDelay();
		return Arrays.asList("Tata", "Maruti", "Mahindra").stream().map(name -> Car.builder().name(name).build()).collect(Collectors.toList());
	}
	
	private static void addSomeDelay() {
		try {
			Thread.sleep(new Random().nextInt(2999));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
