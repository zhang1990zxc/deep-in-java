package com.zhang.deep.in.java.collection;

import java.util.PriorityQueue;

/**
 * @ClassName PriorityQueueDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/15 18:27
 * @Version 1.0
 **/
public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(3);
        integers.add(1);
        integers.add(1);
        integers.add(2);
        integers.forEach(System.out::println);

    }

}
