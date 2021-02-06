package code.day23;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {
    @Test
    public void test1(){
        Class clazz=Man.class;
        Method[] files=clazz.getDeclaredMethods() ;
        for (Method m:
             files) {
            //注解
             Annotation[] annotations=m.getAnnotations();
            for (Annotation a :
                    annotations) {
                System.out.println(a);
            }
            //权限修饰符
            System.out.println(Modifier.toString(m.getModifiers()));
            //返回值类型名
            System.out.println(m.getReturnType().getName());
            //方法名
            System.out.println(m.getName());
            //参数
            Class[] pas=m.getParameterTypes();
            if(pas!=null)
            {
                for(Class p:pas)
                    System.out.print(p.getName()+" ");
                if(pas.length!=0)
                System.out.println();
            }
            //异常
            Class[] ets= m.getExceptionTypes();
            if(ets!=null)
            {
                for(Class e:ets)
                    System.out.print(e.getName()+" ");
                if(ets.length!=0)
                System.out.println();
            }
        }
    }
}
