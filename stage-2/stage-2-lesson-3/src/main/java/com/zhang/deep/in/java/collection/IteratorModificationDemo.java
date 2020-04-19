package com.zhang.deep.in.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName IteratorModificationDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/15 20:36
 * @Version 1.0
 **/
public class IteratorModificationDemo {


    public static void main(String[] args) {

        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3));

        Iterator<Integer> iterator = values.iterator();

        while (iterator.hasNext()) {
            // List.add(T) 方法在 next() 方法调用之前执行，会抛出 java.util.ConcurrentModificationException
//            values.add(4);
            // Integer.remove() 方法在 next() 方法调用之前执行，会抛出 java.lang.IllegalStateException
//            iterator.remove();
            // List.remove(int) 方法在 next() 方法调用之前执行，会抛出 java.util.ConcurrentModificationException
//            values.remove(0);
            Integer value = iterator.next();
            // [0] = 1, [1] = 2, [2] = 3
            // c -> 1
            // v = 1
            // [0] = 1, [1] = 2, [2] = 3, [3] = 4
            // c -> 2
            // v = 2
            // [0] = 1, [1] = 2, [2] = 3, [3] = 4,[4] = 4
            System.out.println(value);
            // 结论：Iterator 只能在 next() 方法执行后，通过 remove() 移除数据，也无法对源 Collection 对象操作
            values.add(4);
        }
    }

}
