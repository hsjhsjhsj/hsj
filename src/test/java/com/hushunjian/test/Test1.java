package com.hushunjian.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test1 {
	public static void main(String[] args) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Calendar calendar = Calendar.getInstance();
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
			//calendar.add(Calendar.WEEK_OF_YEAR, -20);
			Date beginTime = sdf.parse(sdf.format(calendar.getTime()));
			calendar.setTime(beginTime);
			calendar.get(Calendar.WEEK_OF_YEAR);
			String beginTimeString = sdf.format(beginTime);
			System.out.println("YEAR:"+calendar.get(Calendar.YEAR));
			System.out.println("=================");
			System.out.println("WEEK:"+calendar.get(Calendar.WEEK_OF_YEAR));
			System.out.println("=================");
			System.out.println(beginTimeString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
