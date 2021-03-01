package test;

import java.util.HashMap;
import java.util.Set;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("1","2");
        Set<String> strings = map.keySet();
        for (String s:
             strings) {
            System.out.println(map.get(s));
        }
    }
}
