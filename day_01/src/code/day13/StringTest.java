package code.day13;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest {
    @Test
   public void test1(){
        String s1="abc123";
        char a[]=s1.toCharArray();
        char [] arr=new char[]{'a','b'};
        String s2=new String(arr);
        System.out.println(a);
        System.out.println(s2);
    }
    /*
    String 与byte[]的转换
     */
    @Test
    public void test2() throws UnsupportedEncodingException {
        String s1="abc123中";
        byte[] bytes=s1.getBytes();
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1=s1.getBytes("gbk");
        System.out.println(Arrays.toString(bytes1));
        //解码
        String s2=new String(bytes,"UTF-8");
        System.out.println(s2);
        String s3=new String(bytes1,"gbk");
        System.out.println(s3);
    }
    @Test
    public void test3(){
        String s1="hello";
        char s2[]={'h','e','l','l','o'};
        System.out.println(s1.equals(s2));
    }
    @Test
    public void test4(){
        String s = "祝你考出好成绩！";
        System.out.println(s.length());
    }
    //String-->基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)
    //基本数据类型、包装类-->String：调用String重载的valueOf(xxx)
    @Test
    public void test5(){
        String str1="123";
        int num=Integer.parseInt(str1);
        Integer num1=Integer.valueOf(str1);
        System.out.println(num);
        System.out.println(num1);
        String str2=String.valueOf(num);
        System.out.println(str2);
    }
    //String -->char[] 调用String的toCharArray()
    //char[]-->String 调用String的构造器
    @Test
    public void test6(){
        String str1="123";
        char[] charArray=str1.toCharArray();
        System.out.println(Arrays.toString(charArray));
        char arr[]=new char[]{'h','e','l','l','o'};
        String str2=new String(arr);
        System.out.println(str2);
    }
    //String-->StringBuffer、StringBuilder 调用StringBuffer、StringBuilder的构造器
    //StringBuffer、StringBuilder-->String 1.调用String的构造器2.StringBuffer、StringBuilder的toString()
    @Test
    public void test7(){
        String str1="123";
        StringBuilder stringBuilder=new StringBuilder(str1);
        StringBuffer stringBuffer=new StringBuffer(str1);
        String str2=stringBuffer.toString();
        String str3=new String(stringBuffer);
    }
}
