package com.ir.learning.poc.numberformat;

import java.text.DecimalFormat;

import org.apache.log4j.Logger;

public class NumberFormatTest {
	
	private static final Logger LOGGER = Logger.getLogger(NumberFormatTest.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double vals = 5466.887;
		Long value = Math.round(vals);
		LOGGER.info(value);
		
		double vals1 = 5466.345;
		Long value1 = Math.round(vals1);
		LOGGER.info(value1);
		
		double vals2 = 55466.5;
		Long value2 = Math.round(vals2);
		LOGGER.info(value2);
		
		double vals3 = 65466.87;
		Long value3 = Math.round(vals3);
		LOGGER.info(value3);
		
		//NumberFormat nf = NumberFormat.);
		DecimalFormat df = new DecimalFormat("####");
		LOGGER.info(df.format(vals));
		LOGGER.info(df.format(vals1));
		LOGGER.info(df.format(vals2));
		LOGGER.info(df.format(vals3));
		
	}

}
