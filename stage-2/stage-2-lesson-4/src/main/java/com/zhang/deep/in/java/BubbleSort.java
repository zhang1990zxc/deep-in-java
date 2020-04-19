package com.zhang.deep.in.java;

import java.util.Arrays;

/**
 * @ClassName BubbleSort
 * @Description 冒泡排序法
 * @Author 天涯
 * @Date 2020/4/19 14:52
 * @Version 1.0
 **/
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] values) {
        int size = values.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (values[j].compareTo(values[j + 1]) == 1) {
                    T t = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = t;
                }
            }
            System.out.printf("第%d轮：%s\n", i + 1, Arrays.toString(values));
        }
    }

    public static void main(String[] args) {
        System.out.println("一般情况");
        Integer[] values = Sort.of(3, 1, 2, 5, 4);
        Sort<Integer> sort = new BubbleSort<>();
        sort.sort(values);
        System.out.printf("排序结果：%s\n", Arrays.toString(values));

        System.out.println("完全逆序");
        values = Sort.of(5, 4, 3, 2, 1);
        sort = new BubbleSort<>();
        sort.sort(values);
        System.out.printf("排序结果：%s\n", Arrays.toString(values));
    }
}
