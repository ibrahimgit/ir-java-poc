package com.ir.learning.poc.learn;

import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ir.learning.poc.domainmodel.Employee;

import lombok.extern.slf4j.Slf4j;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

@Slf4j
public class LearnReactive {
	
	
	
	public static void main(String[] args) {
		// Publisher -> Subscriber
		// Subject -> Observer
		// Observable -> Observer/Subscriber
		// Observable just register any data stream stream. The source will output the data only if a subscriber/observer is connected
		Observable<Employee> dataStream = getObservable();
		
		log.info("observable set");
		
		//subscribeBySubscriber(dataStream);
		subscribeByObserver(dataStream);
//		subscribeByAction(dataStream);
//		Stream.of("A", "B", "C", "D", "E", "F").forEach(val -> {
//			try {
//				Thread.sleep(1000l);
//			} catch (InterruptedException e1) {
//				System.err.println(e1);
//			}
//			log.info(val);
//		});
		
		
	}
	
	private static Observable<Employee> getObservable() {
		Employee emp1 = Employee.builder().name("name").build();
		Employee emp2 = Employee.builder().name("gane").gender("A").build();
		List<Employee> employees = List.of(emp1, emp2);
		return Observable.from(employees);
	}

	private static Observable<Employee> getObservable1() {
		return Observable
				.fromCallable(() -> {
					RestTemplate restTemplate = new RestTemplate();
					ResponseEntity<Employee> response = restTemplate.exchange("http://localhost:8080/ir/microservice/employees/{empId}", HttpMethod.GET, null, Employee.class, 4);
					return response.getBody();
				});
	}
	
	private static void subscribeBySubscriber(Observable<Employee> dataStream) {
		log.info("subscribing a blocking subscriber");
		dataStream.subscribe(new Subscriber<Employee>() {

			@Override
			public void onCompleted() {
				log.info("done");
			}

			@Override
			public void onError(Throwable e) {
				System.err.println(e);
			}

			@Override
			public void onNext(Employee emp) {
				log.info(emp.toString());
				
			}
			
		});
		log.info("Observer1 set");
		dataStream.subscribe(new Subscriber<Employee>() {

			@Override
			public void onCompleted() {
				log.info("completed");
			}

			@Override
			public void onError(Throwable e) {
				System.err.println(e);
			}

			@Override
			public void onNext(Employee emp) {
				log.info(emp.getName());
				
			}
			
		});
		log.info("Observer2 set");
	}
	
	private static void subscribeByObserver(Observable<Employee> dataStream) {
		log.info("subscribing a blocking observer");
		dataStream.subscribe(new Observer<Employee>() {

			@Override
			public void onCompleted() {
				log.info("done");
			}

			@Override
			public void onError(Throwable e) {
				System.err.println(e);
			}

			@Override
			public void onNext(Employee emp) {
				log.info("Emp: {}", emp);
				
			}
			
		});
		log.info("Observer1 set");
	}

	private static void subscribeByAction(Observable<Employee> dataStream) {
		log.info("subscribing a blocking observer by action");
		dataStream.subscribe(emp -> {log.info(emp.toString());}, e -> {System.err.println(e);}, () -> {log.info("done");});
//		log.info("Observer1 set");
//		dataStream.subscribe(emp1 -> {log.info(emp1.getName());}, e -> {}, () -> {log.info("done");});
//		log.info("Observer2 set");
	}

}
