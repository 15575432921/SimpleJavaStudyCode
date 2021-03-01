import org.junit.Test;

import java.lang.annotation.ElementType;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class ArraysTest {

    public static void main(String[] args) {
        int a[] = {1, 3, 2, 5};
        int b[] = {2, 3, 4};
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.equals(a, b));

        Arrays.fill(a, 10);
        System.out.println(Arrays.toString(a));
        Arrays.sort(b);
        Integer[] c = {1, 3, 5, 2};

        int dex = Arrays.binarySearch(b, 3);
        System.out.println(dex);

        Arrays.sort(c, new LengthComparator());
        System.out.println(Arrays.toString(c));
        int i = Integer.parseInt("123");
        String s = String.valueOf(i);
    }

    @Test
    public void test() {
        Runnable r1 = () -> {
            System.out.println("hello");
        };
//语法格式二：Lambda需要一个参数，但是没有返回值
        Consumer<String> con = (String str) -> {
            System.out.println(str);
        };
//语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
        Consumer<String> con1 = (str) -> {
            System.out.println(str);
        };
//语法格式四：Lambda若只需要一个参数时，参数的小括号可以省略
        Consumer<String> con2 = str -> {
            System.out.println(str);
        };
//语法格式五：Lambda需要两个或以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com = (x, y) -> {
            System.out.println("hello");
            return Integer.compare(x, y);
        };
//语法格式六：当Lambda体只有一条语句，return与大括号若有，都可以省略
        Comparator<Integer> com1 = (x, y) -> Integer.compare(x, y);
    }
    @Test
    public void test1() {
        Class c1 = Object.class;
        Class c2=Comparator.class;
        Class c3=String[].class;
        Class c4=ElementType.class;
        Class c5=Override.class;
        Class c6=int.class;
        Class c7=void.class;
        Class<Class> c9 = Class.class;
        int []a=new int[10];
        int []b=new int[100];
        Class  c10 = a.getClass();
        Class  c11 = b.getClass();
        //只要元素类型和维度一样，就是同一个Class
        System.out.println(c10==c11);//true
    }
}

class LengthComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }


}
