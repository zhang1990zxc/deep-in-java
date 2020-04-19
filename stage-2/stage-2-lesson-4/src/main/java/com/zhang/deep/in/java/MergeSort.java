package com.zhang.deep.in.java;

import java.util.stream.Stream;

/**
 * @ClassName MergeSort
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/19 18:14
 * @Version 1.0
 **/
public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        sort(values, 0, values.length - 1);
    }

    private void sort(T[] values, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(values, low, mid);
            sort(values, mid + 1, high);
            merge(values, low, mid, high);
        }
    }

    private void merge(Comparable[] values, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        Comparable[] a1 = new Comparable[n1];
        Comparable[] a2 = new Comparable[n2];
        //把 values[0...mid] 内容复制给 a1
        System.arraycopy(values, low, a1, 0, n1);
        //把 values[mid+1...high] 内容复制给 a2
        System.arraycopy(values, mid + 1, a2, 0, n2);

        int k = low;
        int i = 0, j = 0;
        for (; i < n1 && j < n2; k++) {
            if (a1[i].compareTo(a2[j]) < 1) {
                values[k] = a1[i];
                i++;
            } else {
                values[k] = a2[j];
                j++;
            }
        }

        while (i < n1) {
            values[k] = a1[i];
            i++;
            k++;
        }

        while (j < n2) {
            values[k] = a2[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Integer[] values = Sort.of(3, 1, 2, 5, 4);
        Sort<Integer> sort = new MergeSort<>(); // Java 7 Diamond 语法
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }
}
