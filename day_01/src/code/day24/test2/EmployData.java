package code.day24.test2;

import java.util.ArrayList;
import java.util.List;

public class EmployData {
    public static List<Employee> getEmployee() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "wzh", 34, 6000));
        list.add(new Employee(1002, "wzh1", 24, 7000));
        list.add(new Employee(1003, "wzh2", 14, 8000));
        list.add(new Employee(1004, "wzh3", 67, 9000));
        list.add(new Employee(1005, "wzh4", 23, 10000));

        return list;
    }

}
