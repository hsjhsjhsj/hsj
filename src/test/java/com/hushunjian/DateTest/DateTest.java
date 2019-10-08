package com.hushunjian.DateTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import lombok.Data;

@Data
public class DateTest {
	
	private ZonedDateTime time1;
	
	private Date time2;
	
	public static void main(String[] args) throws ParseException {
		System.out.println(ZonedDateTime.now());
		
		System.out.println("==========1==========");
		Date start = new Date();
		System.out.println(start.getTime());
		System.out.println("==========1==========");
		
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
		dateTest.test2();
		
		System.out.println("=====================");
		dateTest.test3();
		System.out.println("=====================");
		System.out.println("==========1==========");
		System.out.println(ZonedDateTime.of(LocalDate.now(), LocalTime.of(0, 0, 0), ZoneId.systemDefault()));
		System.out.println("==========1==========");
		System.out.println("==========2==========");
		String date1String = "2018-8-11 9:20:51";
		Date date1Date = DateUtils.parseDate(date1String, "yyyy-MM-dd HH:mm:ss");
		String date2String = "2018-8-11 9:21:51";
		Date date2Date = DateUtils.parseDate(date2String, "yyyy-MM-dd HH:mm:ss");
		ZonedDateTime date1 = ZonedDateTime.ofInstant(date1Date.toInstant(), ZoneId.systemDefault());
		ZonedDateTime date2 = ZonedDateTime.ofInstant(date2Date.toInstant(), ZoneId.systemDefault());
		Duration between = Duration.between(date1, date2);
		System.out.println("seconds:" + Math.abs(between.getSeconds()));
		System.out.println("==========2==========");
		System.out.println("==========3==========");
		long days = Duration.between(ZonedDateTime.of(ZonedDateTime.now().toLocalDate(), LocalTime.of(0, 0, 0), ZoneId.systemDefault()), ZonedDateTime.of(ZonedDateTime.now().toLocalDate(), LocalTime.of(0, 0, 0), ZoneId.systemDefault())).toDays();
		System.out.println(days);
		System.out.println("==========3==========");
		System.out.println("==========4==========");
		String endTime = "20180811092151";
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyyMMddHHmm");
		Date parse2 = simpleDateFormat2.parse(endTime);
		System.out.println(parse2);
		System.out.println("==========4==========");
		System.out.println("==========5==========");
		ZonedDateTime time = ZonedDateTime.now();
		System.out.println(time);
		long d = -1L;
		System.out.println(time.minusDays(d));
		System.out.println("==========5==========");
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

	private void test2(){
		System.out.println("test2");
		Calendar calendar = Calendar.getInstance();
		System.out.println(calendar.getFirstDayOfWeek());
		System.out.println(calendar.getWeeksInWeekYear());
		System.out.println(calendar.getWeekYear());
	}
	
	private void test3(){
		ZonedDateTime time = ZonedDateTime.now();
		System.out.println(time.getDayOfYear());
	}
}
