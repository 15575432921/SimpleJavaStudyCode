package day07;
//内部类
public class InnerClassTest {
    public static void main(String[] args) {
        Person p=new Person();
        Person.Bird b=p.new Bird();
        b.getAge(3);
        p.eat();

    }

}
class Person{
    String name;
    int age;
    Bird b;

    public void eat(){
        System.out.println("Person eat");
         b=new Bird();
         b.sing();
    }

    static class Dog{
        String name;
        int age;
        public void show(){

            System.out.println("staic Dog");
        }
    }
    class Bird{
        String name;
        int age;

        public Bird(){

        }

        public void sing(){
            System.out.println("Bird sing");

        }
        public void getAge(int age)
        {
            System.out.println(age);
            System.out.println(this.age);
            System.out.println(Person.this.age);
        }
    }
}
