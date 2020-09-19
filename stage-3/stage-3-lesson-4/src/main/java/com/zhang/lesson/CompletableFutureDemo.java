package com.zhang.lesson;

import java.util.concurrent.CompletableFuture;

/**
 * @ClassName CompletableFutureDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/20 1:16
 * @Version 1.0
 **/
public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> 1)
                .thenAccept(System.out::println)
                .completeExceptionally(new RuntimeException());
    }
}
