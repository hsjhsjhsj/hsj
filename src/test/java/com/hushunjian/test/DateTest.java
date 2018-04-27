package com.hushunjian.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DateTest {
	
	/*public static String getFirstDayOfWeek(int week) {
		  Calendar firDay = Calendar.getInstance();
		  // 滚动到周
		  firDay.set(Calendar.WEEK_OF_YEAR, week);
		  // 得到该周第一天
		  firDay.set(Calendar.DAY_OF_WEEK, 2);
		  SimpleDateFormat sdf = new SimpleDateFormat("MM.dd");
		  String firstDay = sdf.format(firDay.getTime());
		  return firstDay;
		 }
	public static String getLastDayOfWeek(int week){
		  Calendar lasDay = Calendar.getInstance();
		  // 滚动到周
		  lasDay.set(Calendar.WEEK_OF_YEAR, week);
		  // 得到该周第一天
		  lasDay.set(Calendar.DAY_OF_WEEK, 2);
		  // 得到该周最后一天
		  lasDay.add(Calendar.DAY_OF_WEEK, 6);
		  SimpleDateFormat sdf = new SimpleDateFormat("MM.dd");
		  String lastDay = sdf.format(lasDay.getTime());
		  return lastDay;
		 }
	
	 public Set<String> getQuarterBetween(Date beginTime,Date endTime){
		 	Set<String> quarters = new LinkedHashSet<String>();
		 	ArrayList<String> months = new ArrayList<String>();
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");//格式化为年月
		    Calendar min = Calendar.getInstance();
		    Calendar max = Calendar.getInstance();
		    min.setTime(beginTime);
		    min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
		    max.setTime(endTime);
		    max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
		    Calendar curr = min;
		    while (curr.before(max)) {
		     months.add(sdf.format(curr.getTime()));
		     int year = curr.get(Calendar.YEAR);	//年份
		     int month = curr.get(Calendar.MONTH) + 1;            //月份
		     int quarter = (int)Math.ceil( (month - 1)  / 3) + 1;     //季度
		     String quarterString = year+"年第"+quarter+"季度";
		     quarters.add(quarterString);
		     curr.add(Calendar.MONTH, 1);
		    }
		 return quarters;
	 }
	 
	 public Set<String> getYearBetween(Date beginTime,Date endTime){
		 Set<String> years = new LinkedHashSet<String>();
		 Calendar min = Calendar.getInstance();
		    Calendar max = Calendar.getInstance();
		    min.setTime(beginTime);
		    min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
		    max.setTime(endTime);
		    max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
		    Calendar curr = min;
		    while (curr.before(max)) {
		     int year = curr.get(Calendar.YEAR);	//年份
		     years.add(year+"年");
		     curr.add(Calendar.MONTH, 1);
		    }
		 return years;
	 }
	 
		 
		 public static void main(String[] args) {
			 DateTest dateTest = new DateTest();
			 //System.out.println(dateTest.getFirstDayOfWeek(17));
			 //System.out.println(dateTest.getLastDayOfWeek(17));
			 
			 Calendar endCalendar = Calendar.getInstance();
			 Date endTime = endCalendar.getTime();
			 Calendar beginCalendar = Calendar.getInstance();
			 beginCalendar.add(Calendar.YEAR, -2);
			 Date beginTime = beginCalendar.getTime();
			 Set<String> quarterBetween = dateTest.getQuarterBetween(beginTime,endTime);
			 System.out.println(quarterBetween.size());
			 Set<String> yearBetween = dateTest.getYearBetween(beginTime, endTime);
			 System.out.println(yearBetween.size());
		 }*/
	
	
	 /**
     * 得到某年某周的第一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getFirstDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);

        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getFirstDayOfWeek(cal.getTime());
    }

    /**
     * 得到某年某周的最后一天
     *
     * @param year
     * @param week
     * @return
     */
    public static Date getLastDayOfWeek(int year, int week) {
        week = week - 1;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DATE, 1);
        Calendar cal = (Calendar) calendar.clone();
        cal.add(Calendar.DATE, week * 7);

        return getLastDayOfWeek(cal.getTime());
    }

    /**
     * 取得当前日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                      calendar.getFirstDayOfWeek()); // Sunday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.SUNDAY);
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_WEEK,
                     calendar.getFirstDayOfWeek() + 6); // Saturday
        return calendar.getTime();
    }

    /**
     * 取得当前日期所在周的前一周最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfLastWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfWeek(calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.WEEK_OF_YEAR) - 1);
    }

    /**
     * 返回指定日期的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的第一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH), 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定年月的月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(Integer year, Integer month) {
        Calendar calendar = Calendar.getInstance();
        if (year == null) {
            year = calendar.get(Calendar.YEAR);
        }
        if (month == null) {
            month = calendar.get(Calendar.MONTH);
        }
        calendar.set(year, month, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的上个月的最后一天
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfLastMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR),
                     calendar.get(Calendar.MONTH) - 1, 1);
        calendar.roll(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 返回指定日期的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfQuarter(calendar.get(Calendar.YEAR),getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的第一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getFirstDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 1 - 1;
        } else if (quarter == 2) {
            month = 4 - 1;
        } else if (quarter == 3) {
            month = 7 - 1;
        } else if (quarter == 4) {
            month = 10 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getFirstDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfQuarter(calendar.get(Calendar.YEAR),getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 3 - 1;
        } else if (quarter == 2) {
            month = 6 - 1;
        } else if (quarter == 3) {
            month = 9 - 1;
        } else if (quarter == 4) {
            month = 12 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfLastQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfLastQuarter(calendar.get(Calendar.YEAR),
                                       getQuarterOfYear(date));
    }

    /**
     * 返回指定年季的上一季的最后一天
     *
     * @param year
     * @param quarter
     * @return
     */
    public static Date getLastDayOfLastQuarter(Integer year, Integer quarter) {
        Calendar calendar = Calendar.getInstance();
        Integer month = new Integer(0);
        if (quarter == 1) {
            month = 12 - 1;
        } else if (quarter == 2) {
            month = 3 - 1;
        } else if (quarter == 3) {
            month = 6 - 1;
        } else if (quarter == 4) {
            month = 9 - 1;
        } else {
            month = calendar.get(Calendar.MONTH);
        }
        return getLastDayOfMonth(year, month);
    }

    /**
     * 返回指定日期的季度
     *
     * @param date
     * @return
     */
    public static int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }
}
