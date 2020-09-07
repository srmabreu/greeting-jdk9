package com.features;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureImprovements {

    public static void main(String[] args) throws InterruptedException {
        final CompletableFuture<String> c1 = new CompletableFuture<>();
        new Thread(() -> c1.complete("Ola mundo")).start();
        c1.thenAccept(s -> System.out.println(s));

        // completeOnTimeout
        final CompletableFuture<String> c2 = new CompletableFuture<>();
        new Thread(() -> c2.completeOnTimeout("Ola mundo Timeout", 1, TimeUnit.SECONDS)).start();
        c2.thenAccept(s -> System.out.println(s));
        Thread.sleep(2000);
    }

}
