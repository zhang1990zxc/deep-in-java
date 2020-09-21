package com.zhang.lesson;

/**
 * @ClassName HelloWorldThreadDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/20 15:07
 * @Version 1.0
 **/
public class HelloWorldThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(HelloWorldThreadDemo::helloWorld);
        thread.start();
        thread.join();
        System.out.printf("线程状态 ：%d，是否存活：%s", thread.getState(), thread.isAlive());
    }

    private static void helloWorld() {
        System.out.printf("Thread[id : %d] - Hello World\n", Thread.currentThread().getId());
    }
}
