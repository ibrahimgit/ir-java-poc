package com.ir.learning.poc;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.log4j.Logger;

public class DateTest {
	
	private static final Logger LOGGER = Logger.getLogger(DateTest.class);

	public static void main(String[] args) {
		Date dt = new Date();
		LOGGER.info("Date: " + dt);
		LOGGER.info("getTime: " + dt.getTime());
		Timestamp ts = new Timestamp(dt.getTime());
		LOGGER.info("TimeStamp: " + ts);
	}

}
