package day15;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateTimeTest {
    @Test
    public void testSimpleDateFormat(){
        SimpleDateFormat sdf=new SimpleDateFormat();
        Date date=new Date();
        System.out.println(date);
        // 格式化： 日期-->字符串
        String format =sdf.format(date);
        System.out.println(format);

        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1=sdf1.format(date);
        System.out.println(format1);
    }
    @Test
    public void test2() throws ParseException {
        //字符串-->日期
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date =sdf1.parse("2020-12-29 11:18:52");
        System.out.println(date);
    }
    @Test
    public void test3() throws ParseException {
        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
        Date date =sdf1.parse("2020-12-29");
        java.sql.Date date1=new java.sql.Date(date.getTime());
        System.out.println(date1);
    }

}
