package code.day18;

import org.junit.Test;

import java.util.*;

public class CollectionTest {
     @Test
    public void test1(){
          new LinkedList<>();
         ArrayList list = new ArrayList();
         list.add(new People("wzh"));
         list.add(3);
         list.add("add");
         System.out.println(list.contains(new People("wzh")));//使用equals判断
         //list.remove(1);   //remove方法是重载的注意传递的参数
         list.remove(Integer.valueOf(3));
         System.out.println(list.size());
         //集合-》数组toArray()
         Object[] array = list.toArray();
         for (int i = 0; i <array.length; i++) {
             System.out.println(array[i]);
         }
         //数组-》集合Arrays.asList
         List<Integer> list1 = Arrays.asList(123, 456);
         System.out.println(list1);
     }
     @Test
    public void test2(){
         ArrayList list = new ArrayList();
         list.add("add");
         list.add(1,"hello");
         list.set(0,"test");
         System.out.println(list.get(1));
         list.forEach(System.out::println);

     }
}


