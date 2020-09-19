package com.zhang.lesson;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;


/**
 * @ClassName QuickSortForkJoinDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/20 0:53
 * @Version 1.0
 **/
public class QuickSortForkJoinDemo {
    public static void main(String[] args) {
        Integer[] values = new Integer[]{2, 5, 6, 7, 8, 8, 9, 2, 1, 6, 7, 5, 6, 11, 23};
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new QuickSortTask(values));
        forkJoinPool.awaitQuiescence(1, TimeUnit.SECONDS);
        forkJoinPool.shutdown();
        System.out.println(Arrays.asList(values));
    }

    private static class QuickSortTask extends RecursiveAction {

        private final Integer[] parts;

        private final int low;

        private final int high;

        private static final Integer THRESHOLD = 4;

        private QuickSortTask(Integer[] parts) {
            this.parts = parts;
            this.low = 0;
            this.high = parts.length - 1;
        }

        private QuickSortTask(Integer[] parts, int low, int high) {
            this.parts = parts;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (high - low < THRESHOLD) {
                sort(parts, low, high);
            } else {
                int pivot = partition(parts, low, high);
                QuickSortTask task = new QuickSortTask(parts, low, pivot - 1);
                QuickSortTask task2 = new QuickSortTask(parts, pivot + 1, high);
                task.fork().join();
                task2.fork().join();
            }
        }

        /**
         * @return int
         * @Description: 获取分区索引
         * @Date: 2020/4/19 19:38
         * @Param [values, low, high]
         **/
        private int partition(Integer[] values, int low, int high) {
            Integer pivot = values[high];
            int i = low;
            for (int j = low; j < high; j++) {
                if (values[j].compareTo(pivot) < 1) {
                    Integer temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                    i++;
                }
            }
            Integer temp = values[i];
            values[i] = values[high];
            values[high] = temp;
            return i;
        }

        private void sort(Integer[] parts, int low, int high) {
            Arrays.sort(parts, low, high + 1);
        }
    }

}
