package com.hushunjian.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test2 {
	public static void main(String[] args) throws ParseException {
		String a = "92.0";
		System.out.println(BigDecimal.valueOf(Double.valueOf("69070.75")));
		Integer round = (int)Math.round(Double.valueOf(a));
		System.out.println(round);
		System.out.println("YG30Z-074".substring(0,2)+"==========6666");
		
		System.out.println(BigDecimal.valueOf(Math.round(Double.valueOf(a))));
		
		System.out.println(Integer.valueOf(a));
		
		System.out.println(Double.valueOf(a));
		

		System.out.println(Long.valueOf("aa"));
		Object o = null;
		System.out.println((Date)o);
		
		
		System.out.println(Integer.class.toString());
		System.out.println(String.class);
		
		String fieldValue = "2018/06/01 10:12:05";
		LocalDateTime localDateTime = LocalDateTime.parse("2018-06-01 10:12:05",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		ZonedDateTime of = ZonedDateTime.of(localDateTime, ZoneId.systemDefault());
		System.out.println(of);
		
		Date date = new SimpleDateFormat("yyyy/MM/dd").parse(fieldValue);
		ZonedDateTime dateZonedDateTime = ZonedDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
		System.out.println(dateZonedDateTime);
	}
	

}
