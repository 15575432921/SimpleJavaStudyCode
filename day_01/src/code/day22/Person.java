package code.day22;

import java.io.Serializable;

/**
 * Person需要满足如下要求，方能序列化
 * 1.需要实现接口Serializable
 * 2.提供全局常量serialVersionUID
 * 3.内部所有属性也必须是可序列化。（默认情况下，基本数据类型是可序列化的）
 * ObjectOutputStream ObjectInputStream不能序列化static和transient修饰的成员变量
 */
public class Person  implements Serializable {

    public  static  final  long serialVersionUID = 123143534534523L;
    private String name;
    private int age;
    private transient int id;
    private Account account;

    public Person(String name, int age, int id,Account account) {
        this.name = name;
        this.age = age;
        this.id=id;
        this.account = account;
    }

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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                ", account=" + account +
                '}';
    }
}
class  Account implements Serializable{
    public static  final  long serialVersionUID=12312312L;
    private int number;

    public Account(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number=" + number +
                '}';
    }

}