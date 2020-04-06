package com.zhang.deep.in.java;

/**
 * @ClassName InnerClassDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/6 19:29
 * @Version 1.0
 **/
public class InnerClassDemo {
    private int data;

    private C c;

    public class C {

        private int data;

    }

    public void setData() {
        c.data = data;
    }

    public static class A {

    }

    public /*static*/ interface B {

    }

    public static void main(String[] args) {
        A a = null;
        B b = null;
        C c = null;
    }
}
