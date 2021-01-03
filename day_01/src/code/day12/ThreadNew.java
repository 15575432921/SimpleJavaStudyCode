package code.day12;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 第三种方法
 * 创建一个实现Callable的实现类
 * 1.创建Callable接口实现类的对象
 * 2.将Callable接口实现类的对象传递到FutureTask构造器
 * 3.将FutureTask对象作为参数传递到Thread类的构造器中
 * 4.Thread对象调用start()方法
 * 5.将FutureTask对象调用get()方法
 */
public class ThreadNew {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        NumThread numThread=new NumThread();
        FutureTask task = new FutureTask(numThread);
        new Thread(task).start();
        Object s = task.get();
        System.out.println(s);
    }
}
class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        return 100;
    }
}
