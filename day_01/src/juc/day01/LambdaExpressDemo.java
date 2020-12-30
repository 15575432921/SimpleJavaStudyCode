package juc.day01;

@FunctionalInterface
interface Foo {
    void sayHello(int a);
     default  int div(int x,int y){
         System.out.println("div");
         return x/y;
     }
    static   int add(int x,int y){
        System.out.println("add");
        return x+y;
    }
}
public class LambdaExpressDemo {
    public static void main(String[] args) {

        Foo foo = (x) -> {
            System.out.println(x + "test");
        };
        foo.sayHello(3);
        System.out.println(foo.div(3,2));
        System.out.println(Foo.add(3,5));
    }
}
