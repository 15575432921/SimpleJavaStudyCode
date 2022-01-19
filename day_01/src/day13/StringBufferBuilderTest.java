package day13;

public class StringBufferBuilderTest {
    public static void main(String[] args) throws InterruptedException {
         StringBuilder s=new StringBuilder("hello");

        //StringBuffer s=new StringBuffer("hello");
        System.out.println(s.append("world"));
        System.out.println(s.delete(0,1));
        s.setCharAt(0,'a');
        System.out.println(s);
        s.insert(0,'s');
        System.out.println(s);
    }


}
