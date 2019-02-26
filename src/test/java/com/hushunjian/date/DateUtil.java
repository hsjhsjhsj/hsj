package com.hushunjian.date;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;


/**
 * @author lijunsong
 */
public class DateUtil {
    private static final String ZONED_ASIA_SHANGHAI = "Asia/Shanghai";

    private DateUtil() {
        //
         }

    public static String dateToString(ZonedDateTime date, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format).withZone(ZoneId.of(ZONED_ASIA_SHANGHAI));
        return date.format(formatter);
    }
    public static ZonedDateTime stringToZonedDateTime(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        LocalDate parsed = LocalDate.parse(dateStr, formatter);
        return ZonedDateTime.of(parsed, LocalTime.MIDNIGHT, ZoneId.of(ZONED_ASIA_SHANGHAI));
    }

    public static ZonedDateTime dateToZonedDateTime(Date date) {
        if (date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return  ZonedDateTime.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH),0,0,0,0,ZoneId.of(ZONED_ASIA_SHANGHAI));
    }

    public static Date zoneDateTimeToDate(ZonedDateTime zonedDateTime) {
        if (zonedDateTime == null){
            return null;
        }
        return Date.from(zonedDateTime.toInstant());
    }

    public static long diffDays(ZonedDateTime zonedDateTime1, ZonedDateTime zonedDateTime2) {
        return Duration.between(zonedDateTime1.truncatedTo(ChronoUnit.DAYS), zonedDateTime2.truncatedTo(ChronoUnit.DAYS)).toDays();
    }

    /**
     * 从date2到date1天数（date2，date1当天也算上）
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long countDays(Date date1, Date date2) {
        if (date1 == null || date2 == null){
            return 0L;
        }
        return Duration.between(dateToZonedDateTime(date1), dateToZonedDateTime(date2)).toDays() + 1;
    }

    /**
     * 得到当前时间，只要年月日,不能改成ZonedDateTime.now()，LocalDate.now(); 计算与当前时间天数之差会受小时影响
     * @return
     */
    public static ZonedDateTime genCurrDate() {
        return dateToZonedDateTime(new Date());
    }

    /**
     * 得到当前时间，只要年月日
     * @return
     */
    public static ZonedDateTime genCurrDateTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return ZonedDateTime.of(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),0,0,ZoneId.of(ZONED_ASIA_SHANGHAI));
    }

    /**
     * 从date2到date1天数（date2，date1当天也算上）
     *
     * @param date1
     * @param date2
     * @return
     */
    public static long countDays(ZonedDateTime date1, ZonedDateTime date2) {
        if (date1 == null || date2 == null){
            return 0L;
        }
        return Duration.between(date1.truncatedTo(ChronoUnit.DAYS), date2.truncatedTo(ChronoUnit.DAYS)).toDays() + 1;
    }

    /**
     * 拼装开始时间和结束时间的数据
     *
     * @param startDate
     * @param endDate
     * @param format
     * @return
     */
    public static String startAndEndDateToString(ZonedDateTime startDate, ZonedDateTime endDate, String format) {
        return dateToString(startDate, format) + "-" + dateToString(endDate, format);
    }

    /** 得到日期string
     * @param zonedDateTime
     * @return
     */
    public static String genStringOfDate(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toLocalDate().toString();
    }

    public static ZonedDateTime toZonedDateTime(LocalDateTime localDateTime) {
        if (localDateTime == null){
            return null;
        }
        return ZonedDateTime.ofLocal(localDateTime, ZoneId.of(ZONED_ASIA_SHANGHAI), null);
    }

    /**
     * 获取当前月的第一天,时间 00:00:00
     * @return
     */
    public static ZonedDateTime getFirstDayByMonth(){
        LocalDate first = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        return first.atStartOfDay(ZoneId.systemDefault());
    }

    /**
     * 获取当前月的最后一天,时间 00:00:00
     * @return
     */
    public static ZonedDateTime getLastDayByMonth(){
        LocalDate last  = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth());
        return last.atStartOfDay(ZoneId.systemDefault());
    }

}

