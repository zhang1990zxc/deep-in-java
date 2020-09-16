package com.zhang.deep.in.java.modular;

/**
 * @ClassName ThreadStarvationDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/16 21:02
 * @Version 1.0
 **/
public class ThreadStarvationDemo {
    public static void main(String[] args) {
        new ThreadStarvationDemo();
    }

    public void finalize() {
        System.out.printf("Thread[%s] executes current object's finalization.\n", Thread.currentThread().getName());
    }
}
