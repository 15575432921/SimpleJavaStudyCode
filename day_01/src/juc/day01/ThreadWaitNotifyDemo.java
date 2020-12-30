package juc.day01;
class AirConditioner{
    private int number=0;
    public synchronized void increment() throws InterruptedException {
        while(number>0)
            wait();
        number++;
        System.out.println(Thread.currentThread().getName()+number);
        notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        while(number<=0)
            wait();
        number--;
        System.out.println(Thread.currentThread().getName()+number);
        notifyAll();
    }
}
public class ThreadWaitNotifyDemo {
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
