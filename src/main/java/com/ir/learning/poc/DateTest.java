package com.ir.learning.poc;

import java.sql.Timestamp;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date dt = new Date();
		System.out.println("Date: " + dt);
		System.out.println("getTime: " + dt.getTime());
		Timestamp ts = new Timestamp(dt.getTime());
		System.out.println("TimeStamp: " + ts);
	}

}
