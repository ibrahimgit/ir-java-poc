package com.ir.learning.poc;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.function.Function;

import org.apache.log4j.Logger;

import com.ir.learning.poc.api.TestInterface;

public class POC {
	
	private static final Logger LOGGER = Logger.getLogger(POC.class);
	
	public static void foo() {
		
	}
	
	
	public static void main(String[] args) throws CloneNotSupportedException, UnsupportedEncodingException {
		Set<Integer> setInt = new HashSet<>(); //no need to provide parameter type on RHS, Java 7 feature
		
		String s = "tets%%&&88";
		
		LOGGER.info(URLEncoder.encode(s, "UTF-8"));
		
		
		call();
		
		Map<String, Integer> map = new TreeMap<>();
		map.put("B", 6);
		map.put("A", 2);
		
		List<Integer> list1 = new ArrayList<>(map.values());
		LOGGER.info(list1);
		
		Collections.reverse(list1);
		
		LOGGER.info(list1);
		
		Vector<Integer> vt = new Vector<Integer>();
		vt.addAll(list1);
		
		LOGGER.info(vt);
		
		for (Integer innt: map.values()) {
			
		}
		
		LOGGER.info(map)
		;
		
		int million = 1_000_000_000; // java 7 features
		
		List<Integer> setInteger = Arrays.<Integer>asList(new Integer[]{1,2,3,4});
		
		setInteger.forEach( i -> LOGGER.info(i));
		
		setInteger.forEach(System.out::println);
		
		Function<String, Integer> strToInt = String::length; // method references
		Function<Integer, Integer> intToInt = intgr -> intgr + 5; // lambda expression
		
		LOGGER.info(strToInt.apply("Nobo"));
		LOGGER.info(intToInt.apply(5));
		
		//TestInterface
		
		//setInteger.add(6); not allowed
		int x = 3;
		
		int y = ~x;
		
		LOGGER.info("y: " + y);
		
		TestInterface tif = str -> 5;
		
		TestInterface ti = new TestInterface() {
			
			@Override
			public int foo(String str) {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		LOGGER.info("tif: " + tif.foo(""));
		LOGGER.info("ti: " + ti.foo(""));
		tif.doStuff(x);
		
		
		
		
		
		POC poc = new POC();
		
		Animal an = new Animal();
		LOGGER.info(String.class.getClassLoader());
		LOGGER.info(ClassNotFoundException.class.getClassLoader());
		LOGGER.info(POC.class.getClassLoader());
		LOGGER.info(POC.class.getClassLoader().getParent());
		LOGGER.info(POC.class.getClassLoader().getParent().getParent());
		try {
			Class animalClass = Class.forName("com.poc.ir.Animal");
			//Class animalClass1 = Class.forName("com.poc.ir.Animal", true, POC.class.getClassLoader().getParent()); // ext classs loader will not b able to find it
			Class animalClass2 = Class.forName("java.lang.StringBuilder", true, POC.class.getClassLoader().getParent().getParent());
			
			ClassLoader cl = ClassLoader.getSystemClassLoader();
			
			Vector<String> list = new Vector<String>();
			list.add("434dasd");
			list.add("dds");
			
			for (String str : list) {
				LOGGER.info("Vector: " + str);
				
			}
			
			//cl.loadClass("com.poc.ir.Animal1"); //ClassNotFoundException
			String str = null;
			List<String> strList = new ArrayList<>();
			strList.get(0);
			//str.length();
			LOGGER.info(cl.getParent());
			
			LOGGER.info(cl.toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NullPointerException | IndexOutOfBoundsException | IllegalArgumentException e) { //multi-catch exception, java 7 feature
			LOGGER.info("message: " + e.getMessage());
		}
		
		LOGGER.info("callTryCatchPoc: " + poc.callTryCatchPoc());
		
		setInt.add(6);
		setInt.add(7);
		
		Horse h1 = new Horse();
		
		h1.doStuff();
		
		LOGGER.info("Horse Cloning test: " + h1.clone());
		
		Horse.AHorse aah = h1.new AHorse(5);
		
		
		
		Iterator<Integer> it = setInt.iterator();
		
		while(it.hasNext()) {
			LOGGER.info(it.next());
			it.remove();
		}
		
		LOGGER.info(setInt);
	}

	private static void call() {
		String failures = "315|";
		List<String> failureCodes = new ArrayList<>();
		String[] errorArray = failures.split("\\|");
		LOGGER.info(errorArray.length);
		for(int i = 0; i < errorArray.length; i++) {
			/*
			 * Ideally it should be one database call
			 */
			//Failure failure = new Failure();
			//failure.setCode(errorArray[i]);
			//failure.setDescription(paymentRepository.getFailureCode(errorArray[i], dialectCode, dspType));
			LOGGER.info(errorArray[i]);
			failureCodes.add(errorArray[i]);
		}
		LOGGER.info(failureCodes.size());
	}


	private int callTryCatchPoc() {
		
		try {
			throw new Exception();
		} catch (Exception e) {
			return 4;
		} finally {
			return 5;
		}
	}	
}
