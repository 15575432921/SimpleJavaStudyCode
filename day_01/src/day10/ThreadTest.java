package day10;

public class ThreadTest {
    public static void main(String[] args) {
        Thread1 t1=new Thread1();

        Thread t2=new Thread(new  Thread2());
        //start 启动当前线程；调用run方法
        t1.start();

        t2.start();


    }

}
class Thread1 extends Thread{
    public void run() {
        while(true)
        System.out.println("1"+Thread.currentThread());
    }
}
class Thread2 implements Runnable{

    @Override
    public void run() {
        while(true)
        System.out.println("2"+Thread.currentThread());
    }
}