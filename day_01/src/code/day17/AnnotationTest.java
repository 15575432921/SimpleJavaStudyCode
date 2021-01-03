package code.day17;

import java.lang.annotation.Annotation;

/**
 * 1.文档中
 * 2.jdk原本 @Override @Deprecated @SuppressWarnings
 * 3.跟踪代码依赖性，实现替代配置文件的作用
 * 4.元注解
 * @Target 可以使用的地方
 * @Retention 生命周期
 * @Documented 提取为文档
 * @Inherited 继承性
 * 5.通过反射获取信息
 * 6.jdk8
 * 6.1可重复注解
 *  在MyAnnotation上声明@Repeatable 中放MyAnnotations.class
 *  MyAnnotations中放MyAnnotation数组
 * 6.2类型注解
 * ELementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）
 * ElementType.TYPE_USE表示该注解能写在使用类型的任何语句中
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;
        Annotation[] annotations = studentClass.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
        double i=0.923d;
        System.out.println(i);
    }
}
@MyAnnotation(value = "test")
//@MyAnnotation(value = "hh1")
class People{

}
class Student extends  People{
}