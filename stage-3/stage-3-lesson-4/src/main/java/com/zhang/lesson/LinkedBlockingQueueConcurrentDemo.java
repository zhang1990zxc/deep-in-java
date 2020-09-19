package com.zhang.lesson;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ArrayBlockingQueueConcurrentDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/19 20:55
 * @Version 1.0
 **/
public class LinkedBlockingQueueConcurrentDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(2);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (AtomicInteger i = new AtomicInteger(1); i.get() < 100; i.incrementAndGet()) {
            executorService.submit(() -> {
                try {
                    queue.put(i.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            executorService.submit(() -> {
                try {
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


       /* executorService.submit(() -> {
            try {
                queue.put(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });*/

        executorService.awaitTermination(10, TimeUnit.SECONDS);
        executorService.shutdown();
    }

}
