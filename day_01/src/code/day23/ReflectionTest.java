package code.day23;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest {
    @Test
    public void test1(){
        Person p1=new Person("Tom",12);
       p1.age=10;
        p1.show();
        System.out.println(p1.toString());
    }
    @Test
    public void test2() throws Exception{
        Class  clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Tom", 12);
        Person person = (Person) obj;
        System.out.println(person.toString());
        Field age = clazz.getDeclaredField("age");
        age.set(person,10);
        System.out.println(age.get(person));
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(person);
        Constructor con2 = clazz.getDeclaredConstructor(String.class);
        con2.setAccessible(true);
        Object obj1 = con2.newInstance("Tom");
        Person person2 = (Person) obj1;
        System.out.println(person2.toString());
    }
    //Class的实例就对应一个运行时类
    //加载到内存中的运行时类，会缓存一定的时间
    @Test
    public void test3() throws  Exception {
        Class<Person> clazz1 = Person.class;
        Person p1=new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        //调用Class的静态方法
        Class<?> clazz3 = Class.forName("code.day23.Person");
        System.out.println(clazz1==clazz2);
        System.out.println(clazz1==clazz3);
        //使用类的加载器
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        System.out.println(classLoader);
        ClassLoader classLoaderParent = classLoader.getParent();
        System.out.println(classLoaderParent);
        ClassLoader classLoaderParent1 = classLoaderParent.getParent();
        System.out.println(classLoaderParent1);
        Class<?> clazz4 = classLoader.loadClass("code.day23.Person");
        System.out.println(clazz4);
        System.out.println(clazz1==clazz4);
    }
    @Test
    public void test4() throws IOException {
        Properties pros = new Properties();
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc.properties");
        pros.load(is);
        String user=pros.getProperty("user");
        System.out.println(user);
    }
    @Test
    public void test5() throws Exception{
        Class<Man> clazz = Man.class;
        Man p = clazz.newInstance();
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        showDesc.invoke(Man.class);
    }
}
