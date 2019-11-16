package com.ir.learning.poc;

public class CalulateRatio {
	
	public static void main(String[] args) {
		Integer a = 17;
		Integer b = 19;
		
		String ratio = getRatio(a, b);
		
		System.out.printf("Ratio of %d and %d is %s", a, b, ratio);
	}

	private static String getRatio(int i, int j) {
		Integer gcd = getGcd(i, j);
		
		return i/gcd + ":" + j/gcd;
	}

	private static Integer getGcd(int i, int j) {
		if(j == 0)
			return i;
		else 
			return getGcd(j, i%j);
	}

}
