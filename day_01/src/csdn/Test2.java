package csdn;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("要加密的字符串");
        String  s=in.next();
        StringBuilder ss=new StringBuilder(s);
        System.out.println("偏移量");
        int x = in.nextInt();
        int n=ss.length();
        x=x%n;
        StringBuilder nss=new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            nss.setCharAt((i+x)%n,ss.charAt(i));
        }
        System.out.println("加密后字符串为"+nss);
        System.out.println("解密");
        StringBuilder nss2=new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            nss2.setCharAt((i-x+n)%n,nss.charAt(i));
        }
        System.out.println(nss2);
    }
}
