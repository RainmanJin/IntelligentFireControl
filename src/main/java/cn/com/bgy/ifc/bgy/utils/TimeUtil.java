package cn.com.bgy.ifc.bgy.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author: ZhangCheng
 * @description:时间工具类
 * @date: 2018-12-19 12:02
 **/
public class TimeUtil {

    // 时间格式 yyyy-MM-dd HH:mm:ss
    private static final DateTimeFormatter LONG_DATETIME_FORMATTER = TimeFormat.LONG_DATE_PATTERN_LINE.dateTimeFormatter;

    private TimeUtil() {
    }

    /**
     * @author: ZhangCheng
     * @description:时间转换为String,格式yyyy-MM-dd HH:mm:ss
     * @param: [date]
     * @return: java.lang.String
     */
    public static String parseDateToStr(final Date date) {
        return formatDateToStr(date, LONG_DATETIME_FORMATTER);
    }

    /**
     * @author: ZhangCheng
     * @description:传入日期时间，格式化时间
     * @param: [date, timeFormat]
     * @return: java.lang.String
     */
    public static String formatDateToStr(final Date date, DateTimeFormatter dateTimeFormatter) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * @author: ZhangCheng
     * @description:时间字符串转换，格式yyyy-MM-dd HH:mm:ss
     * @param: [date]
     * @return: java.lang.String
     */
    public static Date parseStrToDate(String date) {
        return formatStrToDate(date, LONG_DATETIME_FORMATTER);
    }

    /**
     * @author: ZhangCheng
     * @description:传入时间字符串，格式化时间
     * @param: [date, dateTimeFormatter]
     * @return: java.lang.String
     */
    public static Date formatStrToDate(String date, DateTimeFormatter dateTimeFormatter) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = LocalDateTime.parse(date, dateTimeFormatter).atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    public enum TimeFormat {
        /**
         * 时间格式：yyyy-MM-dd
         */
        SHORT_DATE_PATTERN_LINE("yyyy-MM-dd"),
        /**
         * 时间格式：yyyy年MM月dd日
         */
        SHORT_DATE_PATTERN_CHINA("yyyy年MM月dd日"),

        /**
         * 长时间格式：yyyy-MM-dd HH:mm:ss
         */
        LONG_DATE_PATTERN_LINE("yyyy-MM-dd HH:mm:ss");

        /**
         * 使用transient关键字不序列化某个变量
         */
        private transient DateTimeFormatter dateTimeFormatter;

        TimeFormat(String pattern) {
            dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        }
    }
}
