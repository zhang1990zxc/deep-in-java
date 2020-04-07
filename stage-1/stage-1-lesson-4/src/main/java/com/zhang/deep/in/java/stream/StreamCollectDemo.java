package com.zhang.deep.in.java.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamCollectDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/8 1:51
 * @Version 1.0
 **/
public class StreamCollectDemo {

    public static void main(String[] args) {

        List<Integer> list = Stream.of(1,2,3,4,5).collect(Collectors.toList());
        System.out.println(list.getClass());

        list = Stream.of(1,2,3,4,5).collect(LinkedList::new, List::add, List::addAll);
        System.out.println(list.getClass());

    }



}
