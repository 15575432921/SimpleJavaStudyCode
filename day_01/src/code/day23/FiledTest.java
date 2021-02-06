package code.day23;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FiledTest {
    @Test
    public void test1() throws  Exception{
        Class clazz=Man.class;
        Field[] files=clazz.getDeclaredFields() ;
        for (Field f:
             files) {
            System.out.println(f);
            //权限修饰符
            System.out.println(Modifier.toString(f.getModifiers()));
            //数据类型
            System.out.println(f.getType());
            //变量名
            System.out.println(f.getName());
        }
    }
}
