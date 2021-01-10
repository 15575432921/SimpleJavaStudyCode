package juc.day03;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemp {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });
       completableFuture.get();
        CompletableFuture<Integer> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return 1024;
        });
        System.out.println(completableFuture1.whenComplete((t, u) -> {
            System.out.println(t);
            System.out.println(u);
        }).exceptionally(f -> {
            System.out.println(f.getMessage());
            return 4444;
        }).get());
    }
}
