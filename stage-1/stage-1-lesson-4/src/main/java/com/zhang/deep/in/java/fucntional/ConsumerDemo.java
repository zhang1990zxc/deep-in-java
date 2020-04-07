package com.zhang.deep.in.java.fucntional;

import java.util.function.Consumer;

/**
 * @ClassName ConsumerDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/7 20:32
 * @Version 1.0
 **/
public class ConsumerDemo {

    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;

        consumer.accept("Hello,World");

        Consumer<String> consumer2 = ConsumerDemo::echo;

        //Fluent API
        consumer2.andThen(consumer).andThen(consumer).accept("Hello,zhang");

    }

    public static void print(Consumer<? super CharSequence> cs, String message) {
        cs.accept(message);
    }

    private static void echo(String message){
        System.out.println("echo : " + message);
    }


}
