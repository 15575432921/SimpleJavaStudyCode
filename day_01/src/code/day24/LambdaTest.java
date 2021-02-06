package code.day24;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {
    public static void main(String[] args) {
        Runnable r1=()->System.out.println("hh");
        Consumer<String>cons=s-> System.out.println(s);
        cons.accept("hello");
        Supplier<String>supplier=()->"123";
        System.out.println(supplier.get());
        Function<String,Integer>function=s->s.length();
        System.out.println(function.apply("test"));
        Predicate<String> predicate=s->s.isEmpty();
        System.out.println(predicate.test(""));
    }
}
@FunctionalInterface
interface MyFunctionalInterface
{
    void fun();
}