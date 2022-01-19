package juc.day02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 新版生产者消费者模型
 */
class AirConditioner{
    private int number=0;
    private ReentrantLock lock =new ReentrantLock();
    private Condition condition=lock.newCondition();
    public  void increment() throws InterruptedException {
        lock.lock();
        try {
            while (number > 0)
                condition.await();
            number++;
            System.out.println(Thread.currentThread().getName() + number);
            condition.signalAll();
        }catch (Exception e)
        {
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    }
    public void decrement() throws InterruptedException {

        lock.lock();
        try {
            while(number<=0)
                condition.await();
            number--;
            System.out.println(Thread.currentThread().getName()+number);
            condition.signalAll();
        }catch (Exception e)
        {
            System.out.println(e);
        }finally {
            lock.unlock();
        }

    }
}
public class NewThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner=new AirConditioner();
        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                    airConditioner.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                    airConditioner.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                    airConditioner.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C").start();
        new Thread(()->{
            try {
                for(int i=0;i<10;i++)
                    airConditioner.decrement();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"D").start();
    }
}

