package code.day24.test2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {
    @Test
    public void test1(){
        Consumer<String> con1=str-> System.out.println(str);
        con1.accept("北京");
        PrintStream p=System.out;
        Consumer<String>con2= p::println;
        con2.accept("北京");
    }
    @Test
    public void test2(){
        Employee employee=new Employee(1001,"Tom",23,5600);
        Supplier<String>supplier=employee::getName;
        System.out.println(supplier.get());
    }
    @Test
    public void test3(){
        Comparator<Integer>com1=Integer::compareTo;
        System.out.println(com1.compare(12, 21));
    }
    @Test
    public void test4(){
        Function<Double,Long>func= Math::round;
        System.out.println(func.apply(12.6));
    }
    //类 ::非静态
    @Test
    public void test5(){
       Comparator<String>com1=(s1,s2) ->s1.compareTo(s2);
       Comparator<String>com2=String::compareTo;
        System.out.println(com1.compare("A", "B"));
        System.out.println(com2.compare("A", "B"));
    }
    @Test
    public void  test6(){
        Employee employee=new Employee(1001,"Tom",23,5600);
        Function<Employee,String>func1=e->e.getName();
        System.out.println(func1.apply(employee));
        Function<Employee,String>func2=Employee::getName;
        System.out.println(func2.apply(employee));
    }
}
