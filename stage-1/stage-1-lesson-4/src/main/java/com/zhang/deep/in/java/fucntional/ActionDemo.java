package com.zhang.deep.in.java.fucntional;

/**
 * @ClassName ActionDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/7 23:53
 * @Version 1.0
 **/
public class ActionDemo {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("小马哥");
            }
        };

        Runnable runnable1 = () -> {};

    }

}
