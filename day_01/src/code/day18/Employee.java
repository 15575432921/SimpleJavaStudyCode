package code.day18;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Employee implements  Comparable{
    private  String name;
    private int age;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee)
        {
            return this.name.compareTo(((Employee) o).getName());
        }
        throw  new RuntimeException("输入类型不匹配");
    }
    public static void main(String[] args) {
        TreeSet set=new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee)
                {
                   MyDate d1= ((Employee) o1).getBirthday();
                   MyDate d2= ((Employee) o2).getBirthday();
                   if(d1.getYear()!=d2.getYear())
                   {
                       return  Integer.compare(d1.getYear(),d2.getYear());
                   }
                   else
                   {
                       if(d1.getMonth()!=d2.getMonth())
                           return  Integer.compare(d1.getMonth(),d2.getMonth());
                       else
                       {

                               return  Integer.compare(d1.getDay(),d2.getDay());
                       }
                   }
                }
                throw  new RuntimeException("输入类型不匹配");
            }

        });
        set.add(new Employee("liudehua",55,new MyDate(1965,5,4)));
        set.add(new Employee("zhangxueyou",43,new MyDate(1987,5,4)));
        set.add(new Employee("liming",51,new MyDate(1954,8,12)));
        set.add(new Employee("liangzhaowei",21,new MyDate(1978,12,4)));
        Iterator iterable=set.iterator();
        while (iterable.hasNext())
        {
            System.out.println(iterable.next());
        }
    }


}

class MyDate{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}