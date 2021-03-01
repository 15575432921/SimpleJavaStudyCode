package juc.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static  CyclicBarrier cyclicBarrier=new CyclicBarrier(2);

    public static void main (String[] args)  {
        Thread thread1=new Thread(()->{
            try {
                System.out.println("任务一第一阶段任务正在执行");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("任务一第二阶段任务正在执行");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        });
        Thread thread2=new Thread(()->{
            try {
                System.out.println("任务二第一阶段任务正在执行");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("任务二第二阶段任务正在执行");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        });
        thread2.start();
        thread1.start();
    }


}
