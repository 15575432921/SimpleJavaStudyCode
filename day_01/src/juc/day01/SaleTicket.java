package juc.day01;

import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private int number=50;
    private ReentrantLock lock=new ReentrantLock();
    public void saleTicket()
    {
        while (number>0)
        {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" "+number--);
            }finally {
                lock.unlock();
            }
        }
    }
}
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(()->{
            for (int i = 0; i <40 ; i++)
            ticket.saleTicket();}).start();
        new Thread(()->{ for (int i = 0; i <40 ; i++)
            ticket.saleTicket();}).start();
        new Thread(()->{ for (int i = 0; i <40 ; i++)
            ticket.saleTicket();}).start();
    }
}
