package com.zhang.deep.in.java.collection;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @ClassName WeakReferenceMapDemo
 * {@link WeakHashMap}
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/15 1:10
 * @Version 1.0
 **/
public class WeakReferenceMapDemo {

    public static void main(String[] args) throws InterruptedException {

        demoWeakHashMap();

    }

    private static void demoWeakHashMap() throws InterruptedException {
        // 强引用
        // value 变量是局部变量，存放在栈
        // "abc" 是常量，在 Java 8 之前是放在 Perm 区域，Java 8+ 是存放在 META 区域
        // 在 demoWeakHashMap() 方法执行结束后，value 变量会被立即回收，"abc" 常量常驻
        String value = "abc";

        ReferenceQueue queue = new ReferenceQueue();

        // 弱引用
        WeakReference<User> userReference = new WeakReference<>(new User("张三"), queue);

        // WeakReference 继承为 Reference，Reference 入队 ReferenceQueue
        // 获取引用对象
        for (int i = 0; i < 100; i++) {
            Thread.sleep(1 * 1000);
            System.out.println(userReference.get());
        }


    }

    private static class User {

        private String name;

        public User(String name) {
            this.name = name;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
