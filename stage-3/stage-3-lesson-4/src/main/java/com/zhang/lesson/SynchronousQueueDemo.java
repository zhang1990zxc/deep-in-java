package com.zhang.lesson;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName SynchronousQueueDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/19 21:08
 * @Version 1.0
 **/
public class SynchronousQueueDemo {

    public static void main(String[] args) {
        // SynchronousQueue 互斥使用场景
        // SynchronousQueue put() 完成之后，必须被其他线程 take()
        // capacity == 0 , 又允许插入(put) 一个元素
        // offer 方法无效，add 方法抛出异常
        BlockingQueue<Integer> queue = new SynchronousQueue<>();
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
        executorService.shutdown();
    }


}
