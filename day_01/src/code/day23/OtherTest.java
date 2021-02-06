package code.day23;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {
    @Test
    public void test1() throws  Exception{
        Class<Man> clazz = Man.class;
        //泛型父类
        Type superclass =clazz.getGenericSuperclass();
        ParameterizedType paramType=(ParameterizedType)superclass;
        Type[] actualTypeArguments = paramType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }
    @Test
    public void test2(){
        Class<Man> clazz = Man.class;
        //接口
        Class [] interfaces = clazz.getInterfaces();
        for (Class c:
             interfaces) {
            System.out.println(c);
        }
        Class [] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c:
                interfaces1) {
            System.out.println(c);
        }
    }
    @Test
    public void test3(){
        Class<Man> clazz = Man.class;
        //包
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a :
                annotations) {
            System.out.println(a);
        }
    }
}
