package code.day11;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        Window w=new Window();
        Thread t1=new Thread(w);
        Thread t2= new Thread(w);
        t1.start();
        t2.start();
    }
}
class Window implements Runnable {
    private int trick = 100;
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (trick > 0)
                    System.out.println(Thread.currentThread().getName()+"余票为"+trick--);
                else break;
            } finally {
                lock.unlock();
            }
        }
    }
}