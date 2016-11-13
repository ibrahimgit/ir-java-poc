package com.ir.learning.poc.numberformat;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double vals = 5466.887;
		Long value = Math.round(vals);
		System.out.println(value);
		
		double vals1 = 5466.345;
		Long value1 = Math.round(vals1);
		System.out.println(value1);
		
		double vals2 = 55466.5;
		Long value2 = Math.round(vals2);
		System.out.println(value2);
		
		double vals3 = 65466.87;
		Long value3 = Math.round(vals3);
		System.out.println(value3);
		
		//NumberFormat nf = NumberFormat.);
		DecimalFormat df = new DecimalFormat("####");
		System.out.println(df.format(vals));
		System.out.println(df.format(vals1));
		System.out.println(df.format(vals2));
		System.out.println(df.format(vals3));
		
	}

}
