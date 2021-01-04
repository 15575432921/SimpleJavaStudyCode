package code.day18;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SetDuplicate {
    public  static List duplicateList(List list)
    {
        HashSet set=new HashSet(list);
        return new ArrayList(set);
    }
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(3);
        list.add(3);
        list.add(4);
        list=duplicateList(list);
        for (Object i:
             list) {
            System.out.println(i);

        }
    }

}
