package com.perfect.cx;

import org.apache.commons.lang.StringUtils;

import java.util.Calendar;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        String businessMan = "0";
        String businessCode ;
        String businessName;
        if (StringUtils.isNotBlank(businessMan)) {
            String[] business = businessMan.split(" ");
            businessCode = business[0];
            businessName = business.length == 2 ? business[1] : "0";
        }
    }

    // 增加或减少天数
    public static Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.DAY_OF_MONTH, num);
        return startDT.getTime();
    }
}
