package com.zhang.deep.in.java.stream;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * @ClassName StreamDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/8 1:08
 * @Version 1.0
 **/
public class StreamDemo {

    public static void main(String[] args) {
//        count(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        sort(6, 3, 2, 31, 4, 23, 754, 12, 98, 21);
//        sort((x, y) -> (x < y) ? 1 : ((x == y) ? 0 : -1),
//                1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        parallelSort(6, 3, 2, 31, 4, 23, 754, 12, 98, 21);
    }

    private static void parallelSort(Integer... numbers) {
        Stream.of(numbers).sorted().parallel().forEach(StreamDemo::println);
    }

    private static void println(Object o){
        System.out.printf("[%s] : %s\n", Thread.currentThread().getName(), o);
    }

    private static void sort(Integer... numbers) {
        Stream.of(numbers).sorted().forEach(StreamDemo::println);
    }

    private static void sort(Comparator<Integer> comparator, Integer... numbers) {
        Stream.of(numbers).sorted(comparator).forEach(System.out::println);
    }

    private static void count(Integer... numbers) {
        Stream.of(numbers)
                .reduce(Integer::sum)
                .map(String::valueOf)
                .ifPresent(System.out::println);
    }

}
