package com.hushunjian.DateTest;

import java.time.ZonedDateTime;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import lombok.Data;

@Data
public class DateTest {
	
	private ZonedDateTime time1;
	
	private Date time2;
	
	public static void main(String[] args) {
		DateTest dateTest= new DateTest();
		dateTest.setTime1(ZonedDateTime.now());
		dateTest.setTime2(new Date());
		boolean sameDay = DateUtils.isSameDay(Date.from(dateTest.getTime1().toInstant()), dateTest.getTime2());
		if(sameDay){
			System.out.println("同一天");
		}else{
			System.out.println("不是同一天");
		}
	}
}
