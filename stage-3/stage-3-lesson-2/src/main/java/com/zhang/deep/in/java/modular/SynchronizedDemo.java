package com.zhang.deep.in.java.modular;

/**
 * @ClassName SynchronizedDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/15 23:31
 * @Version 1.0
 **/
public class SynchronizedDemo {
    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {

        }
        new Thread().start();
    }

    private static void changeValue(int value) {
        // 线程私有对象，尽管它也在堆里面
        // 栈保存 value 名称，data 变量名称
        // 堆共享（被其他线程可见）是线程不安全的，保存内存
        // 当线程不加以控制数量的话，容易导致 JVM OOM
        Data data = new Data();
        data.setValue(1);
    }

    private static class Data {

        private volatile int value;

        public synchronized int getValue() {
            return value;
        }

        public synchronized void setValue(int value) {
            this.value = value;
        }
    }

}
