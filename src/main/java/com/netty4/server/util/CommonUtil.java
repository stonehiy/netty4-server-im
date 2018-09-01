package com.netty4.server.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CommonUtil {


    /**
     * 计算两个日期相差了几个月
     * @param start
     * @param end
     * @return
     */
    public static int getMonthDiff(Date start,Date end)  {
        LocalDate startLocalDate = getMonthDayStartTime(start).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endLocalDate = getMonthDayEndTime(end).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(startLocalDate,endLocalDate);
        return period.getYears() * 12 + period.getMonths()+(period.getDays()>0?1:0);
    }
    /**
     * 计算两个日期相差了几个月
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public static int getDiffMonth(Date start,Date end){
        int result=0;
        int startYear=getYear(start);
        int startMonth=getMonth(start);
        int startDay=getDay(start);
        int endYear=getYear(end);
        int endMonth=getMonth(end);
        int endDay=getDay(end);
        //1月17  大于 2月28
        if (startDay>endDay){
            //也满足一月
            if (endDay==getDaysOfMonth(getYear(new Date()),2)){
                result=(endYear-startYear)*12+endMonth-startMonth;
            }else{
                result=(endYear-startYear)*12+endMonth-startMonth-1;
            }
        }else{
            result=(endYear-startYear)*12+endMonth-startMonth;
        }
        return result;
    }
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);
    }

    /**
     * 返回日期的月份，1-12,即yyyy-MM-dd中的MM
     *
     * @param date
     * @return
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 返回日期的年,即yyyy-MM-dd中的yyyy
     *
     * @param date
     *            Date
     * @return int
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }





    public static void main(String[] args) throws ParseException {
        Date start = DateUtils.parseDate("2018-03-31", "yyyy-MM-dd");
        Date end = DateUtils.parseDate("2018-06-30", "yyyy-MM-dd");
        int monthDiff = getQuarterDiff(start, end);
        for(int i=0;i<monthDiff;i++){
            Date sstart = CommonUtil.getQuarterStartTime(start);
            sstart = DateUtils.addMonths(sstart,i*3);
            Date endTime = CommonUtil.getQuarterEndTime(sstart);
            System.out.println(DateFormatUtils.format(sstart,"yyyy-MM-dd HH:mm:ss") +
                    "    "+DateFormatUtils.format(endTime,"yyyy-MM-dd HH:mm:ss"));
        }
    }


    /**
     * 计算两个日期相差了多少天
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public static int getDayDiff(Date start,Date end)  {
        Long time = end.getTime()-start.getTime();
        int dayTime = 1000 * 60 * 60 * 24;
        if(time < dayTime){
            return 1;
        }
        Double day = Math.ceil(time / (dayTime*1.0));
        return day.intValue();
    }
 /**
     * 计算两个日期相差了多少周
     * @param start
     * @param end
     * @return
     * @throws ParseException
     */
    public static int getWeekDiff(Date start,Date end)  {
        Date weekDayStartTime = getWeekDayStartTime(start);
        Date weekDayEndTime = getWeekDayEndTime(end);
        if(weekDayStartTime.after(weekDayEndTime)){
            return 1;
        }
        int dayDiff = getDayDiff(weekDayStartTime, weekDayEndTime);
        Double ceil = Math.ceil(dayDiff / 7.0);
        return ceil.intValue() ;
    }

    public static int getQuarterDiff(Date start,Date end)  {
        List<Date> quarterTail = QuarterUtil.getQuarterTail(DateTime.parse(DateFormatUtils.format(start, "yyyy-MM-dd")),
                DateTime.parse(DateFormatUtils.format(end, "yyyy-MM-dd")));

        return quarterTail.size();

    }

    public static Date getQuarterStartTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3)
                c.set(Calendar.MONTH, 0);
            else if (currentMonth >= 4 && currentMonth <= 6)
                c.set(Calendar.MONTH, 3);
            else if (currentMonth >= 7 && currentMonth <= 9)
                c.set(Calendar.MONTH, 6);
            else if (currentMonth >= 10 && currentMonth <= 12)
                c.set(Calendar.MONTH, 9);
            c.set(Calendar.DAY_OF_MONTH, 1);
            now = DateUtils.parseDate(DateFormatUtils.format(c.getTime(),"yyyy-MM-dd") + " 00:00:00","yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前季度的结束时间
     *
     * @return
     */
    public static Date getQuarterEndTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        Date now = null;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            now = DateUtils.parseDate(DateFormatUtils.format(c.getTime(),"yyyy-MM-dd") + " 23:59:59","yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 获得本周的第一天，周一
     *
     * @return
     */
    public static Date getWeekDayStartTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        try {
            int d = 0;
            if (c.get(Calendar.DAY_OF_WEEK) == 1) {
                d = -6;
            } else {
                d = 2 - c.get(Calendar.DAY_OF_WEEK);
            }
            c.add(Calendar.DAY_OF_WEEK, d);
            c.setTime( DateUtils.parseDate(DateFormatUtils.format(c.getTime(),"yyyy-MM-dd") + " 00:00:00","yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }

    /**
     * 获得本月的第一天，周一
     *
     * @return
     */
    public static Date getMonthDayStartTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        try {
            c.set(Calendar.DAY_OF_MONTH,1);
            c.setTime( DateUtils.parseDate(DateFormatUtils.format(c.getTime(),"yyyy-MM-dd") + " 00:00:00","yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }

    /**
     * 获得本周的最后一天，周日
     *
     * @return
     */
    public static Date getWeekDayEndTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        try {
            c.add(Calendar.DAY_OF_WEEK, 8-c.get(Calendar.DAY_OF_WEEK));
            c.setTime( DateUtils.parseDate(DateFormatUtils.format(c.getTime(),"yyyy-MM-dd") + " 23:59:59","yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }



    /**
     * 获得本月的最后一天，周日
     *
     * @return
     */
    public static Date getMonthDayEndTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        try {
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            c.setTime(DateUtils.parseDate(DateFormatUtils.format(c.getTime(),"yyyy-MM-dd") + " 23:59:59","yyyy-MM-dd HH:mm:ss"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c.getTime();
    }





    public static int getQuarter(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        if(month>=0 && month <=2){
            return 1;
        }else if(month>=3 && month <=5){
            return 2;
        }else if(month>=6 && month <=8){
            return 3;
        }else if(month>=9 && month<= 11){
            return 4;
        }
        return 0;
    }

    public static String urlEncoder(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String urlDecode(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }



}
