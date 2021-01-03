package code.day18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        Collection list = new ArrayList();
        list.add(new People("wzh"));
        list.add(3);
        list.add(3);
        Iterator iterator = list.iterator();
        while (iterator.hasNext())
        System.out.println(iterator.next());
        iterator = list.iterator();
        for (int i = 0; i <list.size(); i++) {
            System.out.println(iterator.next());
        }
        for (Object o: list) {
            System.out.println(o);
        }
    }
    @Test
    public void test1(){
        String [] arr=new String[]{"mm","mm"};
        for (int i=0;i<arr.length;i++)
            arr[i]="GG";
        System.out.println(Arrays.toString(arr));
        for (String s:
             arr) {
            s="mm";

        }
        System.out.println(Arrays.toString(arr));
    }
}
