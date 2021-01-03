package code.day18;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetTest {
    @Test
    public void test1(){
        HashSet<People> set = new HashSet<People>();
       //当未重写hashcode时发现没有调用People类的equals方法
        set.add(new People("wzh"));
        set.add(new People("wzh"));
        System.out.println(set.size());

    }
    @Test
    public void test2(){
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
        linkedHashSet.add("123");
        linkedHashSet.add("0123");
        for (String s:
             linkedHashSet) {
            System.out.println(s);
        }
    }
    @Test
    public void test3(){
        Comparator com =new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof People && o2 instanceof People) {

                    return ((People) o1).getName().compareTo(((People) o2).getName());
                }
                throw new RuntimeException("输入类型不匹配");
            }


        };

        TreeSet<People> set = new TreeSet<People>(com);

        set.add(new People("123"));
        set.add(new People("0123"));
        for (People s:
                set) {
            System.out.println(s);
        }
    }
}
