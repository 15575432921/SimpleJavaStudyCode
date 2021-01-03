package code.day12;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class NumberThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"test");
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"test1");
    }
}
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service=(ThreadPoolExecutor)executorService;

        executorService.execute(new NumberThread());
        executorService.execute(new NumberThread1());
        //executorService.submit();//适合Callable
        executorService.shutdown();
    }
}
