package com.zhang.deep.in.java.modular;

/**
 * @ClassName DeadLockDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/16 21:00
 * @Version 1.0
 **/
public class DeadLockDemo {
    public static void main(String[] args) {
        final Object m1 = new Object();
        final Object m2 = new Object();

        new Thread(() -> {
            synchronized (m1) {
                System.out.printf("Thread[ ID : %d] holds m1\n", Thread.currentThread().getId());

               /* try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                synchronized (m2) {
                    System.out.printf("Thread[ ID : %d] holds m2\n", Thread.currentThread().getId());
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (m2) {
                System.out.printf("Thread[ ID : %d] holds m2\n", Thread.currentThread().getId());

                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                synchronized (m1) {
                    System.out.printf("Thread[ ID : %d] holds m1\n", Thread.currentThread().getId());
                }
            }
        }).start();
    }
}
