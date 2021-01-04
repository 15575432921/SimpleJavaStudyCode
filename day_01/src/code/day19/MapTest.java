package code.day19;

import org.junit.Test;

import java.util.*;

public class MapTest {
    @Test
    public void test1() {
        //HashMap 可以键值为null
        //Hashtable 不行
        Map map = new HashMap();
        map.put(null, null);
        Hashtable hashtable = new Hashtable();
        //hashtable.put(null,null);

    }

    @Test
    public void test2() {
        HashMap hashMap = new HashMap();
        hashMap.put("AA", 123);
        hashMap.put("BB", 123);
        System.out.println(hashMap);
        hashMap.remove("BB");
        System.out.println(hashMap);
        HashMap hashMap1 = new HashMap();
        hashMap1.put("CC", 123);
        hashMap.putAll(hashMap1);
        System.out.println(hashMap);
        hashMap.clear();
        System.out.println(hashMap);
    }

    @Test
    public void test3() {
        HashMap hashMap = new HashMap();
        hashMap.put("AA", 123);
        hashMap.put("BB", 123);
        System.out.println(hashMap.get("AA"));
        boolean isExist = hashMap.containsKey("AA");
        System.out.println(isExist);
        isExist = hashMap.containsValue(123);
        System.out.println(isExist);
        System.out.println(hashMap.isEmpty());
        System.out.println(hashMap.size());
    }

    @Test
    public void test4() {
        HashMap hashMap = new HashMap();
        hashMap.put("AA", 123);
        hashMap.put("BB", 123);
        Set set = hashMap.keySet();
        long start = System.currentTimeMillis();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Object o = iterator.next();

            System.out.println(o + " " + hashMap.get(o));
        }
        System.out.println(System.currentTimeMillis()-start);
        Collection values = hashMap.values();
        for (Object o:
             values) {
            System.out.println(values);
        }
        //这种更快
        start=System.currentTimeMillis();
        Set set1 = hashMap.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext())
        {
            Map.Entry next = (Map.Entry)iterator1.next();
            System.out.println(next.getKey()+" "+next.getValue());
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
