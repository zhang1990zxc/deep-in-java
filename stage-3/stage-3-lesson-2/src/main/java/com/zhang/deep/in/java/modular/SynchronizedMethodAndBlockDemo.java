package com.zhang.deep.in.java.modular;

/**
 * @ClassName SynchronizedMethodAndBlockDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/16 0:06
 * @Version 1.0
 **/
public class SynchronizedMethodAndBlockDemo {
    public static void main(String[] args) {
        // synchronized 保证互斥
        // 当某个线程 T1 获得锁（1），重新又见到 synchronized（+1）
        // 以此类推
        echo("Hello,World"); //　echo 到底重进入了多少次？3
        // echo -> PrintStream.println -> newLine()
        doEcho("Hello,World"); //　doEcho 到底重进入了多少次？4
        // doEcho -> echo -> PrintStream.println -> newLine()
    }

    private static void doEcho(String message) {
        Object object = new Object();
        synchronized (object) {
            echo(message);
        }
    }

    private synchronized static void echo(String message) {
        System.out.println(message);
    }
}
