package com.zhang.deep.in.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName CollectionRemoveDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/14 21:54
 * @Version 1.0
 **/
public class CollectionRemoveDemo {

    public static void main(String[] args) {

        List<Integer> values = new ArrayList(List.of(1, 2, 3));

        // 常规做法
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            iterator.next(); // 需要执行，调整游标
            iterator.remove();
        }

        values = new ArrayList(List.of(1, 2, 3));

        //　成功删除
        int size = values.size();
        for (int i = 0; i < size; i++) {
            Object value = values.get(0);
            values.remove(value);
            System.out.println(values.size());
        }

        values = new ArrayList(List.of(1, 2, 3));

        size = values.size();
        for (int i = 0; i < size; i++) {
            values.remove(0);
        }

        // 失败删除: for-each 语法
        values = new ArrayList(List.of(1, 2, 3));

        for (Integer value : values) {
            values.remove(value);
        }
    }

}
