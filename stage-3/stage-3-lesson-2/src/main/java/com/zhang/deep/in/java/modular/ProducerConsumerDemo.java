package com.zhang.deep.in.java.modular;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName ProducerConsumerDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/16 21:07
 * @Version 1.0
 **/
public class ProducerConsumerDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Container container = new Container();
        executorService.execute(container::produce);
        executorService.execute(container::consume);
        executorService.shutdown();
    }

    public static class Container {

        private List<Integer> data = new LinkedList<>();

        private static final int MAX_SIZE = 5;

        private Random random = new Random();

        public void produce() {
            while (true) {
                synchronized (this) {
                    try {
                        while (data.size() >= MAX_SIZE) {
                            wait();
                        }
                        int value = random.nextInt(100);
                        System.out.printf("线程[%s] 正在生产数据：%d\n", Thread.currentThread().getName(), value);
                        data.add(value);
                        notify();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void consume() {
            while (true) {
                synchronized (this) {
                    try {
                        while (data.isEmpty()) {
                            wait();
                        }
                        int value = data.remove(0);
                        System.out.printf("线程[%s] 正在消费数据：%d\n", Thread.currentThread().getName(), value);
                        notify();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
