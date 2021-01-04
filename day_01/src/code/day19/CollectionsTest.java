package code.day19;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    @Test
    public void test1(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        Collections.reverse(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.swap(list,0,1);
        System.out.println(list);
        Integer max = Collections.max(list);
        System.out.println(max);
        int frequency = Collections.frequency(list,3);
        System.out.println(frequency);
        List list1= Arrays.asList(new Integer[list.size()]);
        Collections.copy(list1,list);
    }
}
