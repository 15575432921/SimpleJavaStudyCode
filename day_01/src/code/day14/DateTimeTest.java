package code.day14;

import org.junit.Test;

import java.util.Date;

/*时间戳*/
public class DateTimeTest {
    @Test
    public  void test1() {
        long time=System.currentTimeMillis();
        System.out.println(time);
    }
    /*
    1.两个构造器的使用
    2.两个方法的使用
    toString
    getTime
     */
    @Test
    public  void test2() {
         Date date=new Date();
        System.out.println(date.toString());
        System.out.println(date.getTime());
       Date date2 =new Date(1609166755679L);
        System.out.println(date2.toString());
    }
    /*
    Date与java.sql.Date的转换
     */
    @Test
    public  void test3() {
        Date date =new Date(1609166755679L);
         java.sql.Date date2=new java.sql.Date(date.getTime());
        System.out.println(date2.toString());
    }
}
