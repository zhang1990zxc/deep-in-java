package com.zhang.deep.in.java;

import java.util.Arrays;

/**
 * @ClassName QuickSort
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/19 18:10
 * @Version 1.0
 **/
public class QuickSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] values) {
        int n = values.length;
        int low = 0;
        int high = n - 1;
        sort(values, low, high);
    }

    private void sort(T[] values, int low, int high) {
        if (low < high) {
            int pIndex = partition(values, low, high);
            sort(values, low, pIndex - 1);
            sort(values, pIndex + 1, high);
        }
    }

    /**
     * @return int
     * @Description: 获取分区索引
     * @Date: 2020/4/19 19:38
     * @Param [values, low, high]
     **/
    private int partition(T[] values, int low, int high) {
        T pivot = values[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (values[j].compareTo(pivot) < 1) {
                T temp = values[i];
                values[i] = values[j];
                values[j] = temp;
                i++;
            }
        }

        T temp = values[i];
        values[i] = values[high];
        values[high] = temp;

        return i;
    }


    public static void main(String[] args) {
        Integer[] values = Sort.of(2, 5, 6, 7, 11, 23, 8, 8, 9, 2, 1, 6, 7, 5, 6);
        Sort<Integer> sort = new QuickSort<>(); // Java 7 Diamond 语法
        sort.sort(values);
        System.out.println(Arrays.asList(values));
    }

}
