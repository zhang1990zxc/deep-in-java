package com.zhang.deep.in.java.modular;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @ClassName SynchronizedPerformanceDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/16 0:42
 * @Version 1.0
 **/
public class SynchronizedPerformanceDemo {
    public static void main(String[] args) {
        // 对比 Vector 和 ArrayList
        // 相同点：两者都使用数组（Array）作为存储，集合算法类似
        Vector vector = new Vector();
        ArrayList list = new ArrayList();

        doTest(10000, vector);
        doTest(10000, list);

        System.gc();

        doTest(100000, vector);
        doTest(100000, list);

        System.gc();

    }

    private static void doTest(int count, List list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(new Object());
        }
        long costTime = System.currentTimeMillis() - startTime;
        System.out.printf("%s add costing %f ms(avg)\n", list.getClass().getName(), costTime / (count * 1.0));
    }
}
