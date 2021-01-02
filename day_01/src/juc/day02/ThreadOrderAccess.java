package juc.day02;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource {
    private int num = 0;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printf() {
        lock.lock();
        try {

                while (num != 0&&Thread.currentThread().getName().equals("A")) {
                    condition1.await();
                }

                while (num != 1&&Thread.currentThread().getName().equals("B")) {
                    condition2.await();
                }

                while (num != 2&&Thread.currentThread().getName().equals("C")) {
                    condition3.await();
                }

            for (int i = 0; i< 5*(num+1); i++) {
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
            num=(num+1)%3;
            if(num==1)
            condition2.signal();
            if(num==2)
                condition3.signal();
            if(num==0)
                condition1.signal();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 1.高内聚低耦合前提下，线程操作资源类
 * 2.判断/干活/通知
 * 3.多线程交互中，必须要防止多线程的虚假唤醒，也即（判断只能while，不能if)
 * 4.注意标准位的修改和定位
 */
public class ThreadOrderAccess {
    public static void main(String[] args) {
        ShareResource resource=new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resource.printf();
            }

        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resource.printf();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                resource.printf();
            }
        },"C").start();
    }

}
