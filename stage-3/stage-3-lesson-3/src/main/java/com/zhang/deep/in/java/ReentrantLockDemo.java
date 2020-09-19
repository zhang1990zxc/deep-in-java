package com.zhang.deep.in.java;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ReentrantLockDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/17 1:14
 * @Version 1.0
 **/
public class ReentrantLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        int count = lock.getHoldCount();
        System.out.printf("在 lock() 方法调用之前的线程[%s]重进入数：%d\n",
                Thread.currentThread().getName(), count);
        lock(lock, 100);
    }

    private static void lock(ReentrantLock lock, int times) {
        if (times < 1) {
            return;
        }
        lock.lock();
        try {
            // times-- load, minus 1
            lock(lock, --times);
            System.out.printf("第%s次在 lock() 方法调用之后的线程[%s]重进入数：%d\n", times + 1,
                    Thread.currentThread().getName(), lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }

    private static void conditionObject() {
        Lock lock = new ReentrantLock();
        // 条件变量包括条件，同时它又是线程通讯媒介
        Condition condition = lock.newCondition();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void synchronizedStatement() {
        synchronized (ReentrantLockDemo.class) {
            if (3 > 2) { // 条件
                try {
                    ReentrantLockDemo.class.wait();  // Object 线程通讯方法
                } catch (InterruptedException e) {
                    // logger error message
                }
            }
        }
    }

    private static void tryLockInTimeout() {
        Lock lock = new ReentrantLock();
        try {
            lock.tryLock(3, TimeUnit.SECONDS);
            // TODO
        } catch (InterruptedException e) {
            // 重置中止状态（防止被中途清除 interrupt 状态）
            Thread.currentThread().interrupt();
        }
    }

}
