package juc.day02;

import java.util.HashMap;
import java.util.UUID;

public class NotSafeDemo2 {
    public static void main(String[] args) {
        HashMap<String,String> mp=new HashMap<>();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                mp.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(mp);
            },String.valueOf(i)).start();
        }
    }
}
