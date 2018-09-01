package com.netty4.server.util;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuarterUtil {

private static final int MONTHS_OF_QUARTER = 3;

public static List<Date> getQuarterTail(DateTime sTime, DateTime eTime) {
    int mounthNum = new Period(sTime,eTime, PeriodType.months()).getMonths()+1;
    List<Date> quarterList = new ArrayList<>();
    int sMonth = sTime.getMonthOfYear();
    int leftMonth = (MONTHS_OF_QUARTER==MONTHS_OF_QUARTER-(sMonth%MONTHS_OF_QUARTER)?0:MONTHS_OF_QUARTER-(sMonth%MONTHS_OF_QUARTER));
    DateTime quarterTail = sTime.plusMonths(leftMonth);
    for(int i=0;i<mounthNum;i=i+MONTHS_OF_QUARTER) {
        quarterList.add(new DateTime(quarterTail).toDate());
        quarterTail = quarterTail.plusMonths(MONTHS_OF_QUARTER);
    }
    return quarterList;
    }
}