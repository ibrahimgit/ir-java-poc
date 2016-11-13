package com.ir.learning.poc;

import java.util.regex.Pattern;

abstract public class Braces {

	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<String>();
        while (scanner.hasNext()) {
        	System.out.println("Hi");
        	String s = scanner.next();
        	System.out.println(s);
            list.add(s);
        }
        System.out.println("End");*/
        String regex = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";
        //Pattern pt = Pattern.matches(regex, input);
        System.out.println(Pattern.matches(regex, "27.27.27.27"));
        
        

	}
	
}
