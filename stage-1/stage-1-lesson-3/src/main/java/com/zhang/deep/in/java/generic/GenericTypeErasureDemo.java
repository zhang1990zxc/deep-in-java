package com.zhang.deep.in.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenricTypeErasurDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/7 18:31
 * @Version 1.0
 **/
public class GenericTypeErasureDemo {

    public static void main(String[] args) {
        List<String> values = new ArrayList<>();
        String value = values.get(0);

        A<String> a = new A<>();

        a.equals(a);

        C c = new C();

        c.compareTo(c);

    }

    public static class A<T> {

    }

    public static class C implements Comparable<C> {

        @Override
        public int compareTo(C o) {
            return 0;
        }
    }
}
