package code.day23;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class NewInstanceTest {
    @Test
    public void test1() throws Exception {
        Class<Person> clazz = Person.class;
        Constructor con = clazz.getConstructor();
        Person p=(Person)con.newInstance();

        System.out.println(p);
    }
}
