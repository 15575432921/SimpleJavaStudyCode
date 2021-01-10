package code.day21;

import org.junit.Test;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordCount {
    @Test
    public void test1(){
        FileReader fr=null;
        try{
            fr=new FileReader("hello.txt");
            Map<Character,Integer>map=new HashMap<>();
            int date;
            while((date=fr.read())!=-1)
            {
                char ch=(char)date;
                if(map.get(ch)==null)
                {
                    map.put(ch,1);
                }else
                {
                    map.put(ch,map.get(ch)+1);
                }

            }
            Set<Map.Entry<Character, Integer>> entries =map.entrySet();
            for (Map.Entry<Character, Integer> entry:
                    entries) {
                System.out.println(entry.getKey()+" "+entry.getValue());
            }

        }catch (Exception e)
        {
            System.out.println(e);
        }finally {
            if(fr!=null)
            {
                try {
                    fr.close();
                }catch (Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }
}
