package day16;

import org.junit.Test;

public class SystemTest {
    @Test
    public void test1(){
        System.out.println(System.currentTimeMillis());
        System.out.println(System.in.getClass());
        System.out.println(System.out.getClass());
        System.gc();//请求垃圾回收，至于是否立即回收，取决于系统中的垃圾回收算法的实现以及系统执行时的情况
        //System.exit();
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }

}
