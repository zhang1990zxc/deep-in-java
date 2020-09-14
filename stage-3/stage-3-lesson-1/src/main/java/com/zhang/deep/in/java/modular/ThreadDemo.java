package com.zhang.deep.in.java.modular;

/**
 * @ClassName ThreadDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/14 0:46
 * @Version 1.0
 **/
public class ThreadDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("线程ID：" + Thread.currentThread().getId()));
        thread.start();
    }

}
