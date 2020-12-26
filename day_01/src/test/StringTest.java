package test;

//public class StringTest {
//    public static void main(String[] args) {
//        String a="hello";
//        String b="hello";
//        System.out.println(a==b);
//    }
//}
public class StringTest {
    public static void main(String[] args) {
        System.out.println(test());
    }
    private static int test() {
        int temp = 1;
        try {
            System.out.println(temp);
            return ++temp;
        } catch (Exception e) {
            System.out.println(temp);
            return ++temp;
        } finally {
            ++temp;
            System.out.println(temp);
        }
    }
}