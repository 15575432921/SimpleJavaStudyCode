package code.day04;

public class Son2 extends Father implements Son  {

    private  int a=20;
    public void fun(){
        System.out.println(a+super.a);
    }

    public static void main(String[] args) {

        new Son2().fun();
    }
}
