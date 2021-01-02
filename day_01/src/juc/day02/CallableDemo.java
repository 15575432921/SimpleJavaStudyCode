package juc.day02;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
class  MyThread implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception {
        System.out.println("test");
        return 1024;
    }
}

/**
 * 1.get方法一般放在最后一行
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask task=new FutureTask(()->{
            return 1024;
        });
        FutureTask task1=new FutureTask(new MyThread());
        //只会打印一次
        new Thread(task1).start();
        new Thread(task1).start();
        System.out.println(task1.get());
    }
}
