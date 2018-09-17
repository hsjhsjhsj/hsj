
package com.hushunjian.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtilTest {
	public static void main(String[] args) throws ParseException {
 		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = "2018-9-29";
		Date date = sdf.parse(time);
		getWeekInCurrentMonth(date);
	}
	
	private static void getWeekInCurrentMonth(Date currentDate){
		// 设置时间
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		// 获取传入日期所在周数
		int week = calendar.get(Calendar.WEEK_OF_YEAR);
		System.out.println(week);
		// 获取当前日期所在月份第一天所在周数
		int year = calendar.get(Calendar.YEAR);
		System.out.println(year);
		int month = calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println(month);
	}
}
