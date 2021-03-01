package csdn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
class Word{
    private volatile int x=0;
    private ReentrantLock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    private Condition condition1=lock.newCondition();

    public void add()   {

            lock.lock();
            while (x % 2 == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            x++;
            System.out.println(x);
            condition1.signal();
            lock.unlock();


    }
    public void add1()  {

            lock.lock();
            while (x % 2 == 1) {
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            x++;
            System.out.println(x);
            condition.signal();
            lock.unlock();
        }


}

public class ThreadTest {
    public static void main(String[] args) {
        Word word=new Word();
        new Thread(()->
          {
              for (int i = 0; i <5 ; i++) {
                  word.add();
              }

          }).start();
        new Thread(()->
        {
            for (int i = 0; i <5 ; i++) {
                word.add1();
            }
        }).start();
    }
}
