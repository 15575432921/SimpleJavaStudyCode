package jvm.day01;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoaderTest test=new ClassLoaderTest();
        ClassLoader classLoader = test.getClass().getClassLoader();
        System.out.println(classLoader);
        ClassLoader classLoaderParent = classLoader.getParent();
        System.out.println(classLoaderParent);
        ClassLoader classLoaderParentParent = classLoaderParent.getParent();
        System.out.println(classLoaderParentParent);
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
        ClassLoader classLoader2 = Class.forName("jvm.day01.ClassLoaderTest").getClassLoader();
        System.out.println(classLoader2);
    }
}
