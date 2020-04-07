package com.zhang.deep.in.java.fucntional;

import java.util.function.Function;

/**
 * @ClassName FunctionDesignDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/8 0:40
 * @Version 1.0
 **/
public class FunctionDesignDemo {

    public static void main(String[] args) {

        Function function = a -> a;

        //Function可以用同类型转换
        Function<Integer, Integer> div = a -> a/2;
        System.out.println(div.apply(2));

    }

}
