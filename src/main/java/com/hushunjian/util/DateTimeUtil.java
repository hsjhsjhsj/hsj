/**
 * 
 */
package com.hushunjian.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;

/**
 * 日期时间工具类
 * 
 * @author xiezz
 * @version 1.0.0
 * @date 2015-08-06
 */
public class DateTimeUtil {

	public static String getDate() {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(new Date());
	}

	public static String getDateTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(new Date());
	}

	public static String getDateTimeSSS() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return formatter.format(new Date());
	}

	public static Date strToDateLong(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static Date getLastDateByDays(Date d, int day) {
		try {
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(d);
			rightNow.add(Calendar.DATE, day);
			Date dt1 = rightNow.getTime();
			return dt1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Date();
	}

	public static int getWEEK(Date d) {
		try {
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(d);
			return rightNow.get(Calendar.WEEK_OF_YEAR);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static Date getLastMONTHByDays(Date d, int day) {
		try {
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(d);
			rightNow.add(Calendar.MONTH, day);
			Date dt1 = rightNow.getTime();
			return dt1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Date();
	}

	public static String getDate(Date d) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(d);
	}

	public static String getNextDate(Date d, int day) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar rightNow = Calendar.getInstance();
			rightNow.setTime(d);
			rightNow.add(Calendar.DATE, day);
			Date dt1 = rightNow.getTime();
			return sdf.format(dt1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getDaysDis(Date date1, Date date2) {
		long t1 = date1.getTime();
		long t2 = date2.getTime();
		int result = (int) ((t2 - t1) / (1000 * 60 * 60 * 24));
		return result;

	}

	/**
	 * 提供精确的除法运算方法div
	 * 
	 * @param value1
	 *            被除数
	 * @param value2
	 *            除数
	 * @param scale
	 *            精确范围
	 * @return 两个参数的商
	 * @throws IllegalAccessException
	 */
	public static String div(String value1, double value2, int scale) {
		// 如果精确范围小于0，抛出异常信息
		try {
			BigDecimal b1 = new BigDecimal(value1);
			BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
			return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws ParseException {
		String d = "2191621862853.66440678";
		System.out.println(d);

		BigDecimal dc = new BigDecimal(d);
		BigDecimal dd = new BigDecimal(10000);
		System.out.println(dc.divide(dd, 2, BigDecimal.ROUND_HALF_UP));
	}

	public static String getFirstDayOfWeek(int year, int week) {
		Calendar firDay = Calendar.getInstance();
		firDay.setFirstDayOfWeek(Calendar.MONDAY);
		// 年
		firDay.set(Calendar.YEAR, year);
		// 滚动到周
		firDay.set(Calendar.WEEK_OF_YEAR, week);
		// 得到该周第一天
		firDay.set(Calendar.DAY_OF_WEEK, 2);
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd");
		String firstDay = sdf.format(firDay.getTime());
		return firstDay;
	}

	public static String getLastDayOfWeek(int year, int week) {
		Calendar lasDay = Calendar.getInstance();
		lasDay.setFirstDayOfWeek(Calendar.MONDAY);
		// 年
		lasDay.set(Calendar.YEAR, year);
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

	public static List<String> getMonthBetween(Date minDate, Date maxDate) {
		ArrayList<String> result = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月");// 格式化为年月
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		min.setTime(minDate);
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
		max.setTime(maxDate);
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}
		return result;
	}

	public static Map<String, String> getWeekBetween(Date beginDate, Date EndDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd");
		Map<String, String> result = Maps.newLinkedHashMap();
		Calendar c1 = Calendar.getInstance();
		c1.setFirstDayOfWeek(Calendar.MONDAY);
		c1.setTime(beginDate);
		// 转为周一
		int weekYear = c1.get(Calendar.YEAR);
		int weekOfYear = c1.get(Calendar.WEEK_OF_YEAR);
		c1.setWeekDate(weekYear, weekOfYear, Calendar.MONDAY);
		Calendar c2 = Calendar.getInstance();
		c2.setFirstDayOfWeek(Calendar.MONDAY);
		c2.setTime(EndDate);
		int weekYear2 = c2.get(Calendar.YEAR);
		int weekOfYear2 = c2.get(Calendar.WEEK_OF_YEAR);
		c2.setWeekDate(weekYear2, weekOfYear2, Calendar.MONDAY);
		while (true) {
			int year = c1.get(Calendar.YEAR);
			int week = c1.get(Calendar.WEEK_OF_YEAR);
			String weekBegin = sdf.format(c1.getTime());
			c1.add(Calendar.DAY_OF_MONTH, 6);
			String weekEnd = sdf.format(c1.getTime());
			String key = year + "." + week;
			String value = weekBegin + "-" + weekEnd;
			result.put(key, value);
			if (c1.getTimeInMillis() >= c2.getTimeInMillis()) {
				break;
			}
			c1.add(Calendar.DAY_OF_MONTH, 1);
		}
		return result;
	}

	public static Set<String> getQuarterBetween(Date beginTime, Date endTime) {
		Set<String> quarters = new LinkedHashSet<String>();
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		min.setTime(beginTime);
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
		max.setTime(endTime);
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
		Calendar curr = min;
		while (curr.before(max)) {
			int year = curr.get(Calendar.YEAR); // 年份
			int month = curr.get(Calendar.MONTH) + 1; // 月份
			int quarter = (int) Math.ceil((month - 1) / 3) + 1; // 季度
			String quarterString = year + "年" + quarter + "季度";
			quarters.add(quarterString);
			curr.add(Calendar.MONTH, 1);
		}
		return quarters;
	}

	public static Set<String> getYearBetween(Date beginTime, Date endTime) {
		Set<String> years = new LinkedHashSet<String>();
		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		min.setTime(beginTime);
		min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
		max.setTime(endTime);
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
		Calendar curr = min;
		while (curr.before(max)) {
			int year = curr.get(Calendar.YEAR); // 年份
			years.add(year + "年");
			curr.add(Calendar.MONTH, 1);
		}
		return years;
	}
	
    public static Date getFirstDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getFirstDayOfQuarter(calendar.get(Calendar.YEAR),getQuarterOfYear(date));
    }
    
    public static int getQuarterOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) / 3 + 1;
    }
    
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
    
    public static Date getLastDayOfQuarter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return getLastDayOfQuarter(calendar.get(Calendar.YEAR),getQuarterOfYear(date));
    }
    
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

	
}
