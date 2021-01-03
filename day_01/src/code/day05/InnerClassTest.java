package code.day05;

public class InnerClassTest {
    private int a;
    public class A{
       final static int c=3;
        public void fun()
        {
            System.out.println(a);
        }
    }
    public  void funTest()
    {
        System.out.println("funTest");
        A s=new A();
        s.fun();
    }

    public static void main(String[] args) {
       InnerClassTest innerClassTest= new InnerClassTest();
       innerClassTest.funTest();

    }
}
