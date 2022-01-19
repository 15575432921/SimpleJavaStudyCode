package day13;

import org.junit.Test;

public class StringMethodTest {
    @Test
    public void test1(){
        String s1="Helloworld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());
        System.out.println(s1);
        String s2="  hello  ";
        System.out.println(s2.trim());
        String s3="helloWorld";
        System.out.println(s1.equalsIgnoreCase(s3));
    }
    @Test
    public void test2(){
        String s1="Helloworld";
        String s2=s1.concat("def");
        System.out.println(s2);
        String s3="abc";
        String s4="abcd";
        System.out.println(s3.compareTo(s4));
        System.out.println(s2.substring(10));
        System.out.println(s2.substring(0,10));
    }
    @Test
    public void test3(){
        String s1="hello";
        System.out.println(s1.endsWith("llo"));
        System.out.println(s1.startsWith("he"));
        System.out.println(s1.startsWith("llo",2));
    }
    @Test
    public void test4(){
        String s1="helloworld";
        System.out.println(s1.indexOf("world"));
        System.out.println(s1.lastIndexOf("hello"));//从后往前找
    }
    @Test
    public void test5(){
        String s1="helloworld";
        System.out.println(s1.replace('e','b'));
        //replaceAll replaceFirst matches正则表达式
        String  tel="0571-4534289";
        System.out.println(tel.matches("0571-\\d{7,8}"));
        //split
    }
}
