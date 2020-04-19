package com.zhang.deep.in.java;

import java.util.Arrays;

/**
 * @ClassName InsertionSort
 * @Description 插入排序法
 * @Author 天涯
 * @Date 2020/4/19 15:31
 * @Version 1.0
 **/
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] values) {
        int size = values.length;
        for (int i = 1; i < size; i++) {
            T t = values[i];
            int j = i;
            while (j > 0 && t.compareTo(values[j - 1]) < 0) {
                values[j] = values[j - 1];
                j--;
            }
            values[j] = t;
            System.out.printf("第%d轮：%s\n", i, Arrays.toString(values));
        }
    }

    public static void main(String[] args) {
        System.out.println("一般情况");
        Integer[] values = Sort.of(3, 2, 1, 5, 4);
        Sort<Integer> sort = new InsertionSort<>();
        sort.sort(values);
        System.out.printf("排序结果：%s\n", Arrays.toString(values));

        System.out.println("完全逆序");
        values = Sort.of(5, 4, 3, 2, 1);
        sort = new BubbleSort<>();
        sort.sort(values);
        System.out.printf("排序结果：%s\n", Arrays.toString(values));
    }
}
