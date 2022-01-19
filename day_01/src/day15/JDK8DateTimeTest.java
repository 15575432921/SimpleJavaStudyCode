package day15;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class JDK8DateTimeTest {
    @Test
    public void test1(){
        //now() 获取当前的日期时间
        LocalDate date=LocalDate.now();
        LocalTime time =LocalTime.now();
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(date);
        System.out.println(time);
        System.out.println(localDateTime);
        //of()设定指定的时间
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 10, 10, 10, 10);
        System.out.println(localDateTime1);
        //getXxx()
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());
        //体现不可变性 withXxx()设置相关的属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);
        //
        LocalDateTime localDateTime3 = localDateTime.plusDays(10);
        System.out.println(localDateTime3);
        LocalDateTime localDateTime4 = localDateTime.minusDays(10);
        System.out.println(localDateTime4);
    }
    @Test
    public void test2(){
        //now()获取本初子午线对应的标准时间
        Instant instant=Instant.now();
        System.out.println(instant);
        //添加时间的偏移量
        OffsetDateTime offsetDateTime=instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);
        //获取毫秒数
        long l = instant.toEpochMilli();
        System.out.println(l);
        //获取自1970年开始的毫秒数
        Instant instant1=Instant.ofEpochMilli(1609337675361L);
        System.out.println(instant1);
    }
    /*
    DateTimeFormatter:格式化或解析日期、时间
    类似于SimpleDateFormat
     */
    @Test
    public void test3(){
        //方法一：预定义的标准形式
        //格式化 日期->字符串
        DateTimeFormatter formatter=DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime=LocalDateTime.now();
        String str1=formatter.format(localDateTime);
        System.out.println(str1);
        //解析 字符串-->日期
        TemporalAccessor parse = formatter.parse("2020-12-30T22:21:53.3260412");
        System.out.println(parse);
        //方法二：本地化相关的格式
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);
        //方法三：自定义的格式
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str3 = formatter2.format(localDateTime);
        System.out.println(str3);
        TemporalAccessor parse1 = formatter2.parse("2020-12-30 10:27:21");
        System.out.println(parse1);
    }
}
