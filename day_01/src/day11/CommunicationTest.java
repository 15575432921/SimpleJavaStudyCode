package day11;

/**
 * 进程之间的通信
 */
public class CommunicationTest {
    public static void main(String[] args) {
        Number w = new Number();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        t1.start();
        t2.start();
    }

}

class Number implements Runnable {
    private int trick = 100;


    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (trick > 0) {
                    System.out.println(Thread.currentThread().getName() + "余票为" + trick--);
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else break;
            }
        }
    }
}