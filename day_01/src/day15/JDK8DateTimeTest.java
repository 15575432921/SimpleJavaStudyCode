package day15;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
}
