package com.zhang.deep.in.java;

import java.io.Serializable;

/**
 * @ClassName InterfaceDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author zhang
 * @Date 2020/4/6 17:13
 * @Version 1.0
 **/
public class InterfaceDemo {

    public static void main(String[] args) {

        // 强类型约束
        println(1); // 1 -> int => Integer <- Number
        // String 既是 CharSequence，也是 Serializable
        println((CharSequence) "Hello");
    }

    private static void println(Serializable id) {

    }

    private static void println(CharSequence cs) {
        System.out.println(cs.toString());
    }

    public interface A {
        int VALUE = 1;
    }

}
