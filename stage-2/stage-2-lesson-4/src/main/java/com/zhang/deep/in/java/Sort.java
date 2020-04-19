package com.zhang.deep.in.java;

/**
 * @ClassName Sort
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/19 14:51
 * @Version 1.0
 **/
public interface Sort<T extends Comparable<T>> {

    void sort(T[] values);

    static <T> T[] of(T... values) {
        return values;
    }

}
