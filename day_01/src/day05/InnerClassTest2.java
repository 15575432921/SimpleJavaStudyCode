package day05;

public class InnerClassTest2 {
    void fun(){
        System.out.println("father");
    }
    public static void main(String[] args) {
        InnerClassTest2 test=new InnerClassTest2(){

            @Override
            void fun() {
                System.out.println("inner");
            }
        };
        test.fun();

    }
}
