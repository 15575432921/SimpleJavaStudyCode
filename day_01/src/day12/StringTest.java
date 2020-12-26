package day12;

import org.junit.Test;

public class StringTest {
    @Test
    public void test1() {
        String s = "hello";
        String s1 = "he";
        s1 += "llo";
        System.out.println(s1.getClass());
        System.out.println(s1 == s);
        String s2 = "abc";
        String s3 = s2.replace('a', 'm');
        System.out.println(s2);
        System.out.println(s3);
        String s4 = new String("abc");
        String s5 = s4;
        s5.replace('a', 'm');
        System.out.println(s4);
        System.out.println(s5);
    }
    @Test
    public void test2()
    {
        String s1="javaee";
        String s2="hadoop";
        String s3="javaeehadoop";
        String s4="javaee"+"hadoop";
        String s5=s1+"hadoop";
        String s6="javaee"+s2;
        String s7=s1+s2;
        System.out.println(s3==s4);
        System.out.println(s3==s5);
        System.out.println(s3==s6);
        System.out.println(s3==s7);
        System.out.println(s5==s6);
        System.out.println(s5==s7);
        System.out.println(s6==s7);
        String s8=s5.intern();//返回得到的s8使用的常量池中已存在的
        System.out.println(s3==s8);
    }
}
