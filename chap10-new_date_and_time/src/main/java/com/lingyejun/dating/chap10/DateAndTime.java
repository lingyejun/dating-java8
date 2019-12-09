package com.lingyejun.dating.chap10;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DateAndTime {

    public static void testSync() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<String> dateStrList = Arrays.asList(
                "2019-12-01 10:00:01",
                "2019-12-02 11:00:02",
                "2019-12-03 12:00:03",
                "2019-12-04 13:00:04",
                "2019-12-05 14:00:05"
        );
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (String str : dateStrList) {
            executorService.execute(() -> {
                try {
                    simpleDateFormat.parse(str);
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {
        // testSync();

        // LocalDate
        LocalDate localDate1 = LocalDate.now();
        System.out.println(localDate1);
        LocalDate localDate2 = LocalDate.of(2019, 06, 06);
        LocalDate localDate3 = LocalDate.of(2019, Month.JUNE, 06);
        System.out.println(localDate2 + " " + localDate3);
        System.out.println(localDate2.getDayOfYear());
        System.out.println(localDate2.getDayOfWeek());
        System.out.println(localDate2.getDayOfMonth());
        System.out.println(localDate2.getMonth());
        System.out.println(localDate2.get(ChronoField.DAY_OF_WEEK));
        System.out.println(localDate2.get(ChronoField.DAY_OF_YEAR));

        // LocalTime
        LocalTime localTime1 = LocalTime.now();
        System.out.println(localTime1);
        LocalTime localTime2 = LocalTime.of(12, 02);
        LocalTime localTime3 = LocalTime.of(12, 02, 03);
        LocalTime localTime4 = LocalTime.of(12, 02, 03, 900_000_000);
        System.out.println(localTime2 + " " + localTime3 + " " + localTime4);
        System.out.println(localTime4.getHour());
        System.out.println(localTime4.getMinute());
        System.out.println(localTime4.getSecond());

        // LocalDateTime
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = LocalDateTime.of(2000, Month.AUGUST, 22, 04, 05, 06);
        System.out.println(localDateTime2);
        System.out.println(LocalDateTime.of(localDate1, localTime1));
        System.out.println(localDate2.atTime(localTime2));
        System.out.println(localTime3.atDate(localDate3));
        System.out.println(localTime3.get(ChronoField.HOUR_OF_DAY));
        System.out.println(localTime3.get(ChronoField.MINUTE_OF_HOUR));

        // Instant
        Instant instant = Instant.now();
        System.out.println(instant);
        // 时间戳，秒，毫秒
        System.out.println(instant.toEpochMilli());
        System.out.println(instant.getEpochSecond());
        // Date、Calendar、System
        Date date = new Date();
        System.out.println(date.getTime());
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(instant.toEpochMilli() + " " + instant.getNano());

        // Duration 用在LocalTime、LocalDateTime
        Duration duration1 = Duration.between(localTime1, localTime2);
        System.out.println(duration1);
        System.out.println(Duration.between(localDateTime1, localDateTime2));
        System.out.println(Duration.ofDays(2));
        System.out.println(Duration.ofHours(5));
        System.out.println(Duration.ofMinutes(100));
        System.out.println(Duration.of(2, ChronoUnit.MINUTES));
        System.out.println(Duration.of(2, ChronoUnit.SECONDS));

        // Period用在LocalDate上面
        Period period = Period.between(localDate1, localDate2);
        System.out.println(period);
        System.out.println(Period.ofYears(2));

        // 简单直接的操纵日期
        LocalDate localDate = LocalDate.of(2020, 01, 01);
        System.out.println(localDate);
        LocalDate updLocalDate1 = localDate.withYear(2008);
        LocalDate updLocalDate2 = localDate.withMonth(10);
        LocalDate updLocalDate3 = localDate.withDayOfMonth(31);
        System.out.println(updLocalDate1 + " " + updLocalDate2 + " " + updLocalDate3);
        System.out.println(localDate);
        System.out.println(localDate.with(ChronoField.YEAR, 2019));
        System.out.println(localDate.with(ChronoField.MONTH_OF_YEAR, 06));
        System.out.println(localDate.with(ChronoField.DAY_OF_MONTH, 06));
        System.out.println(localDate.with(ChronoField.YEAR, 2019).with(ChronoField.MONTH_OF_YEAR, 06).with(ChronoField.DAY_OF_MONTH, 06));

        // 使用TemporalAdjuster中预定义的方法快速操纵和修改日期
        System.out.println(localDate.with(TemporalAdjusters.lastDayOfYear()));
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
        System.out.println(localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
        System.out.println(localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.TUESDAY)));

        LocalDate firstMonthOfYear = localDate.with((temporal) -> localDate.withMonth(1));
        LocalDate lastMonthOfYear = localDate.with((temporal) -> localDate.withMonth(12));
        System.out.println(firstMonthOfYear + " " + lastMonthOfYear);

        // 解析日期对象
        LocalDate localDate4 = LocalDate.of(2019, 06, 06);
        System.out.println(localDate4);
        // 转换为特定格式的日期字符串
        System.out.println(localDate4.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(localDate4.format(DateTimeFormatter.ISO_LOCAL_DATE));
        // 解析指定的日期字符串为LocalDate对象
        LocalDate localDate5 = LocalDate.parse("2009-06-06");
        System.out.println(localDate5);
        LocalDate localDate6 = LocalDate.parse("20090606", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate6);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy*MM*dd");
        System.out.println(localDate5.format(dateTimeFormatter));
        System.out.println(LocalDate.parse("2019*06*06", dateTimeFormatter));

        // 时区
        ZoneId nowZoneId = ZoneId.systemDefault();
        ZoneId japanZoneId = ZoneId.of("Asia/Tokyo");
        System.out.println(nowZoneId + " " + japanZoneId);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // 标明这个时间是哪个时区下的
        System.out.println(localDateTime.atZone(japanZoneId));
        System.out.println(localDateTime.atZone(nowZoneId));

        // 时间戳转为另外一个时区的时间
        System.out.println(Instant.now().atZone(japanZoneId));

        // LocalDateTime和Instant互转
        Instant instant1 = Instant.now();
        LocalDateTime localDateTime3 = LocalDateTime.ofInstant(instant1, nowZoneId);
        LocalDateTime localDateTime4 = LocalDateTime.ofInstant(instant1, japanZoneId);
        System.out.println(localDateTime3 + " " + localDateTime4);
        Instant instant2 = localDateTime.toInstant(ZoneOffset.of("+08:00"));
        System.out.println(instant2);

        // ZoneOffset LocalDateTime 和 OffsetDateTime
        ZoneOffset japanOffset = ZoneOffset.of("+09:00");
        ZoneOffset beijingOffset = ZoneOffset.of("+08:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(LocalDateTime.now(), beijingOffset);
        OffsetDateTime offsetDateTime1 = OffsetDateTime.of(LocalDateTime.now(), japanOffset);
        System.out.println(offsetDateTime + " " + offsetDateTime1);
    }
}
