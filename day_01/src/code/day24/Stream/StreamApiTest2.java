package code.day24.Stream;

import code.day24.test2.EmployData;
import code.day24.test2.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//终止操作
public class StreamApiTest2 {
    @Test
    public void test1(){
        List<Employee> employees = EmployData.getEmployee();
        Stream<Employee> stream = employees.stream();
        boolean match = stream.allMatch(e -> e.getAge() > 50);
        System.out.println(match);
        System.out.println();
        stream = employees.stream();
        System.out.println(stream.anyMatch(e -> e.getAge() > 50));
        System.out.println();
        stream = employees.stream();
        System.out.println(stream.noneMatch(e -> e.getAge() > 50));
        stream = employees.stream();
        System.out.println(stream.findFirst());
        stream = employees.parallelStream();
        System.out.println(stream.findAny());
    }
    @Test
    public void test2(){
        //工资大于7000的员工数
        List<Employee> employees = EmployData.getEmployee();
        Stream<Employee> stream = employees.stream();
        long count = stream.filter(e -> e.getSalary() > 7000).count();
        System.out.println(count);
        //最高的工资
        stream = employees.stream();
        Optional<Double> max = stream.map(e -> e.getSalary()).max(Double::compareTo);
        System.out.println(max);
        //最低工资的员工
        stream = employees.stream();
        Optional<Employee> e = stream.min((e1,e2)->{
            return Double.compare(e1.getSalary(),e2.getSalary());
        });
        System.out.println(e);
        //forEach内部迭代
        stream = employees.stream();
        stream.forEach(System.out::println);
    }
    //归约
@Test
    public void test3(){
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8,9,10);
    System.out.println(list.stream().reduce(0, (a,b)->{return a+b;}));
    //全部员工工资和
    List<Employee> employees = EmployData.getEmployee();
    Optional<Double> sumSalary = employees.stream().map(e -> e.getSalary()).reduce(Double::sum);
    System.out.println(sumSalary);
}
//收集
    @Test
    public void test4(){
        List<Employee> employees = EmployData.getEmployee();
        employees.stream().filter(e->e.getSalary()>6000).collect(Collectors.toList()).forEach(System.out::println);
    }
}
