package com.example.developandart.chapter_3.utils;

import com.blankj.utilcode.constant.TimeConstants;
import com.blankj.utilcode.util.TimeUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class TimeUtil {

    private static final SimpleDateFormat yyMMdd_HHmmss_DataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());

    public static String getNowString() {
        return TimeUtils.getNowString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH));
    }

    public static String getNowDayStart() {
        String nowDayStart = TimeUtils.getNowString(new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH));
        return nowDayStart + " 00:00:00";
    }

    public static String getNowTomorrowString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
        String nowString = TimeUtils.getNowString(dateFormat);
        long millis = string2Millis(nowString, dateFormat) + TimeUnit.DAYS.toMillis(1);
        return millis2String(millis, dateFormat);
    }

    public static String getNowYearMonth() {
        String nowMonth = TimeUtils.getNowString(new SimpleDateFormat("yyyy-MM", Locale.ENGLISH));
        return nowMonth;
    }

    public static String getNowMonth() {
        String nowMonth = TimeUtils.getNowString(new SimpleDateFormat("MM", Locale.ENGLISH));
        return nowMonth;
    }

    public static String getAlarmDate(long time) {
        String newTime = TimeUtils.getString(time, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH), 0, TimeConstants.SEC);
        return newTime;
    }

    public static String getAlarmDateStart(long time) {
        String newTime = TimeUtils.getString(time, new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH), 0, TimeConstants.DAY);
        return newTime + " 00:00:00";
    }

    public static String millis2String(long millis) {
        return TimeUtils.millis2String(millis, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH));
    }

    public static String millis2String(long millis, DateFormat format) {
        return TimeUtils.millis2String(millis, format);
    }

    public static long string2Millis(String time) {
        return TimeUtils.string2Millis(time, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH));
    }

    public static long string2Millis(String time, DateFormat format) {
        return TimeUtils.string2Millis(time, format);
    }

    public static long getTimezoneOffset() {
        Calendar calendar = Calendar.getInstance();
        //计算时区的偏移时间(毫秒)
        return -(calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET));
    }

    /**
     * Returns a string representation of an offset from UTC.
     *
     * <p>The format is "[GMT](+|-)HH[:]MM". The output is not localized.
     *
     * @param includeGmt true to include "GMT", false to exclude
     * @param includeMinuteSeparator true to include the separator between hours and minutes, false
     *     to exclude.
     * @param offsetMillis the offset from UTC
     *
     */
    public static String createGmtOffsetString(boolean includeGmt,
                                               boolean includeMinuteSeparator, int offsetMillis) {
        int offsetMinutes = offsetMillis / 60000;
        char sign = '+';
        if (offsetMinutes < 0) {
            sign = '-';
            offsetMinutes = -offsetMinutes;
        }
        StringBuilder builder = new StringBuilder(9);
        if (includeGmt) {
            builder.append("GMT");
        }
        builder.append(sign);
        appendNumber(builder, 2, offsetMinutes / 60);
        if (includeMinuteSeparator) {
            builder.append(':');
        }
        appendNumber(builder, 2, offsetMinutes % 60);
        return builder.toString();
    }

    private static void appendNumber(StringBuilder builder, int count, int value) {
        String string = Integer.toString(value);
        for (int i = 0; i < count - string.length(); i++) {
            builder.append('0');
        }
        builder.append(string);
    }

    /**
     * 根据UTC时间偏移量，获取手机对应的时间
     *
     * @param alarmTime alarm time
     * @param timeDiff seconds
     * @return
     */
    public static long getLocalTime(long alarmTime, String timeDiff) {
        Date time = null;
        try {
            yyMMdd_HHmmss_DataFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            time = yyMMdd_HHmmss_DataFormat.parse(TimeUtils.millis2String(alarmTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String format;
        if (null != time) {
            yyMMdd_HHmmss_DataFormat.setTimeZone(TimeZone.getDefault());
            format = yyMMdd_HHmmss_DataFormat.format(new Date(time.getTime() - Integer.parseInt(timeDiff) * 1000));
            alarmTime = TimeUtils.string2Millis(format);
        }
        return alarmTime;
    }

}
