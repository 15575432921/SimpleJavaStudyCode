package code.day24.Stream;

import code.day24.test2.EmployData;
import code.day24.test2.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApiTest1 {
    @Test
    public  void test(){
        List<Employee> employees = EmployData.getEmployee();
        Stream<Employee> stream = employees.stream();
        stream.filter(e->e.getSalary()>7000).forEach(System.out::println);
        System.out.println();
        stream = employees.stream();
        stream.limit(3).forEach(System.out::println);
        System.out.println();
        stream = employees.stream();
        stream.skip(2).forEach(System.out::println);
        System.out.println();
        employees.add(new Employee(1001, "wzh", 34, 6000));
        stream = employees.stream();
        stream.distinct().forEach(System.out::println);
    }
    //映射
    @Test
    public  void test2() {
        List<String> strings = Arrays.asList("aa", "bb", "cc", "dd");
        strings.stream().map(s->s.toUpperCase()).forEach(System.out::println);
        //员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployData.getEmployee();
        Stream<Employee> stream = employees.stream();
        stream.map(Employee::getName).filter(s->s.length()>3).forEach(System.out::println);
       //
        Stream<Stream<Character>> streamStream = strings.stream().map(StreamApiTest1::fromStringTOStream);
        streamStream.forEach(s->s.forEach(System.out::println));
        System.out.println();
        Stream<Character> characterStream = strings.stream().flatMap(StreamApiTest1::fromStringTOStream);
        characterStream.forEach(System.out::println);
    }
    public static Stream<Character> fromStringTOStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c :
                str.toCharArray()) {
           list.add(c);
        }
        return list.stream();
    }
    @Test
    public void test3(){
        List<String> strings = Arrays.asList("bb", "bb", "aa", "dd");
        strings.stream().sorted().forEach(System.out::println);
        List<Employee> employees = EmployData.getEmployee();
        employees.add(new Employee(1000, "wzh", 34, 6000));
        Stream<Employee> stream = employees.stream();
        stream.sorted((e1,e2)->{return Integer.compare(e1.getId(),e2.getId());}).forEach(System.out::println);
    }
}
