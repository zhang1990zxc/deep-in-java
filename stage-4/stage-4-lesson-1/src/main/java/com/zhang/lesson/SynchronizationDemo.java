package com.zhang.lesson;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SynchronizationDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/20 16:09
 * @Version 1.0
 **/
public class SynchronizationDemo {

    static Lock lock = new ReentrantLock();

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(SynchronizationDemo::addCounter);
        Thread t2 = new Thread(SynchronizationDemo::addCounter);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private static void addCounter() {
        lock.lock();
        System.out.println(getThreadPrefix() + "Before Counter : " + counter);
        counter++;
        System.out.println(getThreadPrefix() + "After Counter : " + counter);
        lock.unlock();
    }

    private static String getThreadPrefix() {
        return "Thread[" + Thread.currentThread().getId() + "] : ";
    }

}
