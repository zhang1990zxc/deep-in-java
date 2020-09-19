package com.zhang.deep.in.java;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName CyclicBarrierDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/17 23:17
 * @Version 1.0
 **/
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(() -> {
                try {
                    echoThread();
                    cyclicBarrier.await();
                    System.out.printf("当前线程[%s]正在执行...\n", Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        // 关闭线程池
        executorService.shutdown();
    }

    private static void echoThread() throws InterruptedException {
        Random random = new Random();
        Thread.sleep(random.nextInt(10) * 1000);
        System.out.printf("当前线程[%s]正在执行...\n", Thread.currentThread().getName());
    }
}
