package jvm.day01;

public class StackSizeTest {
    //6003
    //可通过Xss设置-Xss256k
    //1365
    private static Long count=1L;
    public static void main(String[] args) {
        count++;
        System.out.println(count);
        main(args);
    }
}
