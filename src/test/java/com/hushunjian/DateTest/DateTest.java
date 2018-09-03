package com.hushunjian.DateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import lombok.Data;

@Data
public class DateTest {
	
	private ZonedDateTime time1;
	
	private Date time2;
	
	public static void main(String[] args) throws ParseException {
		DateTest dateTest= new DateTest();
		dateTest.setTime1(ZonedDateTime.now());
		dateTest.setTime2(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-7-27 11:24:10"));
		System.out.println("===================");
		System.out.println("===================");
		String time1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Date.from(dateTest.getTime1().toInstant()));
		System.out.println("time1:"+time1);
		String time2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateTest.getTime2());
		System.out.println("time2:"+time2);
		
		boolean sameDay = DateUtils.isSameDay(Date.from(dateTest.getTime1().toInstant()), dateTest.getTime2());
		if(sameDay){
			System.out.println("同一天");
		}else{
			System.out.println("不是同一天");
		}
		
		
		ZonedDateTime startOfYear = ZonedDateTime.now();
		System.out.println(startOfYear.getYear());
		System.out.println("=====================");
		String date = "2018-8-10 9:20:50";
		System.out.println(date);
		Date stringToDate = DateUtils.parseDate(date, "yyyy-MM-dd HH:mm:ss");
		ZonedDateTime processDate = ZonedDateTime.ofInstant(stringToDate.toInstant(), ZoneId.systemDefault());
		System.out.println(processDate);
		System.out.println("=====================");
		
		dateTest.test();
		dateTest.test1();
	}
	
	
	private void test() throws ParseException{
		ZonedDateTime t1 = ZonedDateTime.now();
		String time1 = new SimpleDateFormat("yyyy-MM-dd").format(Date.from(t1.toInstant())) + " 23:59:59";
		Date t2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time1);
		System.out.println(t2);
	}
	
	private void test1() throws ParseException{
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-08-05");
		System.out.println(date);
		ZonedDateTime endDate = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		System.out.println(endDate);
	}


	
}
