package day11;

/**
 * 死锁
 */
public class ThreadTest {
    public static void main(String[] args) {
        StringBuilder s1=new StringBuilder("");
        StringBuilder s2=new StringBuilder("");
        new Thread(){
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("1");
                    synchronized (s2) {
                        s2.append("1");
                    }
                }

            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                synchronized (s2) {
                    s1.append("1");
                    synchronized (s1) {
                        s2.append("1");
                    }
                }

            }
        }.start();
        System.out.println(s1 );
        System.out.println(s2);
    }
}
