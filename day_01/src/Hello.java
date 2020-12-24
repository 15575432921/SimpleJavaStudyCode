public class Hello {
    public static void main(String[] args) {
        long a=123L;
        float b=1.23f;
        final int c=3;
        String ss="hello";
        System.out.println(ss+123);
        System.out.println(a+" "+b);
        String s2="123";
        int n1=Integer.parseInt(s2);
         Test.a=4;
         Test test1=new Test();
        System.out.println(test1.a);
        test1.a=5;
        Test test2=new Test();
        System.out.println(test2.a);
    }


}
class Test{
    public static int a=3;
}