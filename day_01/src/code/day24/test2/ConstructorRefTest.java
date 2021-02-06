package code.day24.test2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorRefTest {
    @Test
    public void test1() {
        Supplier<Employee> sup = () -> new Employee();
        Supplier<Employee> sup1 = Employee::new;
        System.out.println(sup.get());
        System.out.println(sup1.get());
    }

    @Test
    public void test2() {
        Function<Integer, Employee> fun = Employee::new;
        System.out.println(fun.apply(3));
    }

    @Test
    public void test3() {
        BiFunction<Integer, String, Employee> fun = Employee::new;
        System.out.println(fun.apply(1002, "Tom"));
    }

    //数组引用
    @Test
    public void test4() {
        Function<Integer, String[]> fun1 = length -> new String[length];
        String[] arr1 = fun1.apply(5);
        System.out.println(Arrays.toString(arr1));
        Function<Integer, String[]> fun2 = String[]::new;
        String[] arr2 = fun1.apply(5);
        System.out.println(Arrays.toString(arr2));
    }
}
