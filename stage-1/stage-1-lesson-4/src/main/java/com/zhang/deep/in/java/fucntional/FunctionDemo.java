package com.zhang.deep.in.java.fucntional;

import java.util.function.Function;

/**
 * @ClassName FunctionDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/7 23:30
 * @Version 1.0
 **/
public class FunctionDemo {

    public static void main(String[] args) {

        Function<String, Long> stringToLong = Long::valueOf;

        System.out.println(stringToLong.apply("1"));

        Function<Long, String> longToString = String::valueOf;

        System.out.println(longToString.apply(1L));

        Long value = stringToLong.compose(String::valueOf).apply(1L);

    }

}
