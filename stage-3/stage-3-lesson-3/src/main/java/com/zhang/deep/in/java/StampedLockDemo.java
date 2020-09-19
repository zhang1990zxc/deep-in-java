package com.zhang.deep.in.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

/**
 * @ClassName StampedLockDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/17 22:01
 * @Version 1.0
 **/
public class StampedLockDemo {
    public static void main(String[] args) {
        StampedLock stampedLock = new StampedLock();
        long stamp = stampedLock.tryOptimisticRead();
        Lock lock = stampedLock.asReadLock();
        try {
            lock.lock();
            stampedLock.validate(stamp);
        } finally {
            lock.unlock();
        }
    }
}
