package test;


public class StringTest {

    public static void main(String[] args) {
        String str = new String();//char[] value=new char[0];
        String str1 = new String("abc");//char[] value=new char[]{'a','b','c'};
        StringBuffer sb1 = new StringBuffer();//char[] value=new char[16];底层创建了一个长度是16的数组
        System.out.println(sb1.length());//0
        sb1.append('a');//value[0]='a';
        StringBuffer sb2 = new StringBuffer("abc");//char[] value=new char[19];底层创建了一个长度是16+3的数组
        System.out.println(sb2.length());//3
    }
}
