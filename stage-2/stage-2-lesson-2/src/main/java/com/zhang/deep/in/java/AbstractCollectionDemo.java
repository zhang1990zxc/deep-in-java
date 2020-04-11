package com.zhang.deep.in.java;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName AbstractCollectionDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/11 21:25
 * @Version 1.0
 **/
public class AbstractCollectionDemo {

    public static void main(String[] args) {
        abstractList();
    }

    private static void abstractList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assert numbers instanceof AbstractList;
//        numbers.add(0);
        numbers.set(4,0);
        numbers.forEach(System.out::println);
    }

}
