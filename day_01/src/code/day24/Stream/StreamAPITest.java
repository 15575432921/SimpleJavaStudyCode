package code.day24.Stream;

import code.day24.test2.EmployData;
import code.day24.test2.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//延迟执行
public class StreamAPITest {
@Test
    public void test1(){
    List<Employee> employees = EmployData.getEmployee();
    Stream<Employee> stream = employees.stream();

}
@Test
    public void test2(){
    IntStream stream = Arrays.stream(new int[]{1, 2, 3});
    Stream<String> stream1 = Arrays.stream(new String[]{"1", "2", "3"});
}
@Test
    public void test3(){
    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
}
//创建无限流
@Test
    public void test4(){
    //迭代
    Stream.iterate(0,s->s+2).limit(10).forEach(System.out::println);
      //生成
    Stream.generate(Math::random).limit(10).forEach(System.out::println);
}
}
