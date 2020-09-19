package com.zhang.lesson;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @ClassName ArrayBlockingQueueDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/19 20:38
 * @Version 1.0
 **/
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingDeque = new ArrayBlockingQueue(3);
//        demoOfferMethod(blockingDeque);
//        demoAddMethod(blockingDeque);
        demoPutMethod(blockingDeque);
        System.out.println(blockingDeque);
    }

    private static void demoOfferMethod(BlockingQueue<Integer> blockingQueue) {
        blockingQueue.offer(1);
        blockingQueue.offer(2);
        blockingQueue.offer(3);
        blockingQueue.offer(4);
    }

    private static void demoAddMethod(BlockingQueue<Integer> blockingQueue) {
        blockingQueue.add(1);
        blockingQueue.add(2);
        blockingQueue.add(3);
        blockingQueue.add(4);
    }

    private static void demoPutMethod(BlockingQueue<Integer> blockingQueue) throws InterruptedException {
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);
        blockingQueue.put(4);
    }

}
