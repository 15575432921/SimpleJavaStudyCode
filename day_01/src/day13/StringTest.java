package day13;

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
}
