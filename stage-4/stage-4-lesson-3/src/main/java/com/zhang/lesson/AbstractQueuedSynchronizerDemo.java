package com.zhang.lesson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName AbstractQueuedSynchronizerDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/21 1:10
 * @Version 1.0
 **/
public class AbstractQueuedSynchronizerDemo {

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Thread> threads = new ArrayList<>();
        executorService.submit(() -> {
            threads.add(Thread.currentThread());
            action();
        });

        executorService.submit(AbstractQueuedSynchronizerDemo::action);
        executorService.submit(AbstractQueuedSynchronizerDemo::action);
        executorService.submit(AbstractQueuedSynchronizerDemo::action);

        executorService.awaitTermination(1, TimeUnit.SECONDS);
        executorService.shutdown();

    }

    private static void action() {
        System.out.printf("当前线程[%s] 正在等待您的输入\n", Thread.currentThread().getName());
        try {
            lock.lock();
            System.in.read();
            System.out.printf("当前线程[%s] 执行结束...\n", Thread.currentThread().getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}
