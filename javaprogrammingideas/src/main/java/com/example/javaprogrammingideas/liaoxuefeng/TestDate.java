package com.example.javaprogrammingideas.liaoxuefeng;

import android.os.Build;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import androidx.annotation.RequiresApi;

/**
 * ClassName:TestDate
 * Package:com.example.javaprogrammingideas.liaoxuefeng
 *
 * @date:21-5-13
 * @author:liujianming
 */
public class TestDate {
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args) {
//        testCurrentDate();
//        testCalendar();
//        testTimeZone();
//        convertTimeZone();
//        testLocalDateAndLocalTime();
//        testDateTimeFormatter();
//        testZonedDateTime();
        testConvertTimeZoned();
    }

    private static void testCurrentDate() {
        Date date = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E MMM dd, yyyy");
        System.out.println(simpleDateFormat.format(date));
    }

    private static void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = 1 + calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int second = calendar.get(Calendar.SECOND);
        int minute = calendar.get(Calendar.MILLISECOND);
        System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + second + ":" + minute);
    }

    private static void testTimeZone() {
        TimeZone tzDefault = TimeZone.getDefault();
        TimeZone tzGMT9 = TimeZone.getTimeZone("GMT+09:00");
        TimeZone tzNY = TimeZone.getTimeZone("America/New_York");

        System.out.println(tzDefault.getID());
        System.out.println(tzGMT9.getID());
        System.out.println(tzNY.getID());

        String[] ids;
        ids = TimeZone.getAvailableIDs();
        for (String id : ids) {
            System.out.println(id);
        }
    }

    private static void convertTimeZone() {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        calendar.set(2019, 10 /* 11月 */, 20, 8, 15, 0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(simpleDateFormat.format(calendar.getTime()));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void testLocalDateAndLocalTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void testDateTimeFormatter() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        System.out.println(dtf.format(LocalDateTime.now()));

        LocalDateTime dtf2 = LocalDateTime.parse("2019/11/30 15:16:17", dtf);
        System.out.println(dtf2);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void testZonedDateTime() {
        ZonedDateTime zbj = ZonedDateTime.now();
        ZonedDateTime zny = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println(zbj);
        System.out.println(zny);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static void testConvertTimeZoned() {
        ZonedDateTime zbj = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zny = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zbj);
        System.out.println(zny);
    }
}
