package test;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayTest {



        public static void main(String args[]) {
            ArrayList<String> list=new ArrayList<>();
            list.add("123");
            list.add("abc");
            list.add("Tom");
            list.add("abc");
            list.add("abc");
            Iterator iterator = list.iterator();
            while(iterator.hasNext())
            {
                Object o = iterator.next();
                if("Tom".equals(o))
                {
                    iterator.remove();
                }
            }

        }
    }



