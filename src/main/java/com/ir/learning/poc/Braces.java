package com.ir.learning.poc;

import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract public class Braces {

	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in)
        List<String> list = new ArrayList<String>()
        while (scanner.hasNext()) {
        	LOGGER.info("Hi");
        	String s = scanner.next();
        	LOGGER.info(s);
            list.add(s);
        }
        LOGGER.info("End");*/
        String regex = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";
        //Pattern pt = Pattern.matches(regex, input)
        log.info("matches: {}", Pattern.matches(regex, "27.27.27.27"));
        
        

	}
	
}
