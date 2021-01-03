package code.day15;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    @Test
    public void test1(){
        Calendar calendar=Calendar.getInstance();
        System.out.println(calendar.getClass());
        //get()
        int days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days=calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        calendar.add(Calendar.DAY_OF_MONTH,3);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        //getTime() 日历类 -->Date
        Date time = calendar.getTime();
        System.out.println(time);
        //setTime() Date -->日历类
        Date date1=new Date();
        calendar.setTime(date1);

    }
}
