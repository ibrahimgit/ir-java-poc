package com.ir.learning.poc;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaTest {

	public static void main(String[] args) throws ParseException {
		
		String controlBlock = "030T00000000018321181100000110";
		String retryCode = controlBlock.substring(27, 29);
		System.out.println("retryCOde: " + retryCode);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");
		System.out.println("Date: " + dateFormat.parse("1987-01-20"));
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = df.parse("1987-12-29 00:00:00");
		System.out.println(date);
		DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Date: " + df1.format(date));
		// Week Year ("YYYY") should not be used for date formatting
		/*
		 * Few developers are aware of the difference between Y for "Week year" and y
		 * for Year when formatting and parsing a date with SimpleDateFormat. That's
		 * likely because for most dates, Week year and Year are the same, so testing at
		 * any time other than the first or last week of the year will yield the same
		 * value for both y and Y. But in the last week of December and the first week
		 * of January, you may get unexpected results.
		 */		
		//MM/dd/yyyy 01/02/2018
		//dd-M-yyyy hh:mm:ss 02-1-2018 06:07:59
		//dd MMMM yyyy 02 January 2018
		//dd MMMM yyyy zzzz 02 January 2018 India Standard Time
		//E, dd MMM yyyy HH:mm:ss z Tue, 02 Jan 2018 18:07:59 IST
		Long mobile = 919732827307l;
		int length = (int) (Math.log10(mobile) + 1);
		System.out.println(length);
		if (length > 10) {
			Long sales24MobileNo = mobile % 10000000000L;
			System.out.println("sales24MobileNo: " + sales24MobileNo);
		}
		System.out.println("mobile: " + mobile);
		
		LocalDateTime firstDayOfMonth = LocalDate.now().withDayOfMonth(1).atStartOfDay();
		System.out.println(firstDayOfMonth);
		
		
		List<String> lists = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I");
		int batchSize = 5;
		
		int iteration = lists.size()/batchSize;
		iteration = iteration + ((lists.size() % batchSize == 0) ? 0 : 1);
		System.out.println("Iteration: " + iteration);
		for(int i = 0; i < iteration; i++) {
			int fromIndex = i*batchSize;
			int toIndex = fromIndex + batchSize;
			if(toIndex > lists.size()) {
				toIndex = lists.size();
			}
			List<String> subLists = lists.subList(fromIndex, toIndex);
			System.out.println(subLists);
		}
		
		//String sms = "Thanks for showing interest in SBI Card. To view your application 98765432100 in detail, click here www.google.com & use APPCODE  123456  to verify your data capture, or send this SMS to 9540765999  within next 3 hrs.";
		String sms = "Thank you for choosing SBI card. In view of our discussion, please send this SMS to 9540765999 within next 3 hrs (APPCODE 123456)";
		String appcode = getAppCodeFromSms(sms);
		System.out.println("App code: " + appcode);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.printf("Local Date: %s ", localDateTime);
		ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("UTC"));
		System.out.printf("%nDate at UTC: %s ", zonedDateTime);
		System.out.printf("%nLocal Date at UTC: %s ", zonedDateTime.toLocalDateTime());
		
		
		LocalDateTime localDateTimeWithZone = LocalDateTime.now(ZoneId.of("UTC"));
		System.out.printf("%nLocal Date with UTC Zone: %s ", localDateTimeWithZone);
		ZonedDateTime utcDateWithPstZone = localDateTimeWithZone.atZone(ZoneId.of("America/Los_Angeles"));
		System.out.printf("%nUTC Date at PST: %s ", utcDateWithPstZone);
		System.out.printf("%nPST local Date: %s ", utcDateWithPstZone.toLocalDateTime());
		
		
		ZonedDateTime zonedDate = ZonedDateTime.now(ZoneId.of("UTC"));
		
		System.out.println("\nZone Date: " + zonedDate);
		
		
	}
	
	private static String getAppCodeFromSms(String sms) {
		Pattern pattern = Pattern.compile("\\d{6}");
		String appCode = null;
		
		if (!sms.isEmpty()) {
			Matcher matcher = pattern.matcher(sms);
			if(matcher.find()) {
				appCode = matcher.group(0);
			}
		}
		return appCode;
	}

}
