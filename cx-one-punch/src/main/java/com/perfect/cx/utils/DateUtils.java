package com.perfect.cx.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYY_MM_DD_HH = "yyyy-MM-dd HH";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     *
     * @return Date() 当前日期
     */
    public static Date getNowDate() {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     *
     * @return String
     */
    public static String getDate() {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime() {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow() {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format) {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date) {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date) {
        return new SimpleDateFormat(format).format(date);
    }


    public static final Date dateTime(final String format, final String ts) {
        try {
            return new SimpleDateFormat(format).parse(ts);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 获取年月
     *
     * @param date
     * @return
     */
    public static final String getYearMonth(Date date) {
        return DateFormatUtils.format(date, DateUtils.YYYY_MM);
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime() {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str) {
        if (str == null) {
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate() {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 获取两个时间的差(天数)
     */
    public static long getDatePoorDay(Date endDate, Date startDate) {

        Instant endInstant = endDate.toInstant();
        ZoneId endZoneId = ZoneId.systemDefault();
        LocalDateTime endDateTime = LocalDateTime.ofInstant(endInstant, endZoneId);
        LocalDate endLocalDate = endDateTime.toLocalDate();

        Instant startInstant = startDate.toInstant();
        ZoneId startZoneId = ZoneId.systemDefault();
        LocalDateTime startDateTime = LocalDateTime.ofInstant(startInstant, startZoneId);
        LocalDate startLocalDate = startDateTime.toLocalDate();

        long between = ChronoUnit.DAYS.between(startLocalDate, endLocalDate);

        return between;
    }

    public static String addDay(String date, Integer addNum) {
        DateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            Date dd = df.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dd);
            calendar.add(Calendar.DAY_OF_MONTH, addNum);//加天数
            return df.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Date addDay(Date date, Integer addNum) {
        Calendar calendar = new GregorianCalendar(); // 定义calendar对象
        calendar.setTime(date); // 把当前系统时间赋值给calendar
        calendar.add(calendar.DATE, addNum); // 在日期中增加天数,1天
        return calendar.getTime(); // 把calendar转换回日期格式
    }

    /**
     * 获取当月零点的时间戳
     *
     * @return
     */
    public static Date zeroTime(Date date) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 获取当天零点的时间戳
     *
     * @return
     */
    public static Long getTodayZeroPointTimestamps() {
        Long currentTimestamps = System.currentTimeMillis();
        Long oneDayTimestamps = Long.valueOf(60 * 60 * 24 * 1000);
        return currentTimestamps - (currentTimestamps + 60 * 60 * 8 * 1000) % oneDayTimestamps;
    }

    /**
     * 获取当前时间秒数，String类型
     *
     * @return
     */
    public static String getNowSeconds() {
        return String.valueOf(new Date().getTime() / 1000);
    }

    /**
     * 获取时间秒数，Long类型
     *
     * @return
     */
    public static Long getSeconds(Date date) {
        return date.getTime() / 1000;
    }

    /**
     * 获取时间秒数，Long类型
     *
     * @return
     */
    public static Long getMilliSeconds(Date date) {
        return date.getTime();
    }

    /**
     * 获取多少秒之前时间秒数，String类型
     *
     * @return
     */
    public static String getToXXXSeconds(String nowSeconds, int seconds) {
        return String.valueOf(Long.parseLong(nowSeconds) - seconds);
    }

    /**
     * 获取当月零点的时间戳
     *
     * @return
     */
    public static Long monthTimeInMillis() {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取当前月份的下个月零点的时间戳
     *
     * @return
     */
    public static Long nextMonthTimeInMillis() {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取指定月份的下个月零点的时间戳
     *
     * @return
     */
    public static Long nextMonthTimeInMillis(Long dateLong) {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.setTime(new Date(dateLong));
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取当前零点的时间戳
     *
     * @return
     */
    public static Long yearTimeInMillis() {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.DATE, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取当前零点的下一年时间戳
     *
     * @return
     */
    public static Long nextYearTimeInMillis() {
        Calendar calendar = Calendar.getInstance();// 获取当前日期
        calendar.add(Calendar.YEAR, 1);
        calendar.add(Calendar.DATE, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Long time = calendar.getTimeInMillis();
        return time;
    }

    /**
     * 获取指定月份最后一天
     */
    public static int getLastDayOfMonth(Long dateLong) {
        long lastDay = nextMonthTimeInMillis(dateLong) - 3600 * 24 * 1000;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(lastDay));
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String localTimeToUtcTime(String str) {
        SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");//转化后UTC时间格式
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat localFormater = (SimpleDateFormat) DateFormat.getDateTimeInstance();//解决Date.toLocaleString()过时
        Date date = null;
        try {
            date = localFormater.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return utcFormat.format(date);
    }

    /**
     * 字符串转时间戳
     *
     * @param date 日期字符串
     * @return
     */
    public static Long strToTimestamp(String date) {
        return dateTime(DateUtils.YYYY_MM_DD_HH_MM_SS, date).getTime() / 1000;
    }

    /**
     * 时间戳转字符串
     *
     * @param timestamp 时间戳
     * @return
     */
    public static String timestampToStr(Long timestamp) {
        if (timestamp == null) {
            return null;
        }
        return parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, new Date(timestamp * 1000L));
    }

    /**
     * 获得过去一周的时间
     *
     * @return
     */
    public static String getBeforeSevenTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -7);
        Date d = c.getTime();
        String day = format.format(d);
        return day;
    }

    /**
     * mongo 日期查询isodate
     *
     * @param dateStr
     * @return
     */
    public static Date dateToISODate(String dateStr) {
        //T代表后面跟着时间，Z代表UTC统一时间
        Date date = dateTime(YYYY_MM_DD_HH_MM_SS, dateStr);
        SimpleDateFormat format =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        format.setCalendar(new GregorianCalendar(new SimpleTimeZone(0, "GMT")));
        String isoDate = format.format(date);
        try {
            return format.parse(isoDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
//        Long currentTimestamps = System.currentTimeMillis() - Long.valueOf(60 * 60 * 34 * 1000);
//        System.out.println(new Date(getTodayZeroPointTimestamps()));
//        System.out.println(new Date(currentTimestamps));
//        System.out.println(getDatePoorDay(new Date(getTodayZeroPointTimestamps()),new Date(currentTimestamps)));

//        System.out.println(getLastDayOfMonth());
    }

    /**
     * 时间戳转日期
     * @param timestamp
     * @param fmt
     * @return
     */
    public static String parseTimestamp(long timestamp, String fmt) {
        Date date = new Date(timestamp);
        SimpleDateFormat dateFmt = new SimpleDateFormat(fmt);
        String dateStr = dateFmt.format(date);
        return dateStr;
    }

    /**
     * 判断是否是时间
     * @param time
     * @return
     */
    public static boolean isDate(String time) {
        String[] parsePatterns = {"yyyy-MM-dd", "yyyy年MM月dd日",
                "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy/MM/dd",
                "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyy-MM-dd'T'HH:mm:ss.SSSXXX"};
        try {
            org.apache.commons.lang3.time.DateUtils.parseDate(time, parsePatterns);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * 获取本周星期一
     *
     * @param date 日期
     * @return
     */
    public static Date getThisWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }

    /**
     * 获取下周星期一早上10点
     * @param date 日期
     * @return
     */
    public static Date getNextWeekMonday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getThisWeekMonday(date));
        cal.add(Calendar.DATE, 7);
        cal.set(Calendar.HOUR, -2);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }
}