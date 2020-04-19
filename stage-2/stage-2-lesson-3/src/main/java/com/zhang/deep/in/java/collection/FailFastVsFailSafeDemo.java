package com.zhang.deep.in.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName FailFastVsFailSafeDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/15 20:52
 * @Version 1.0
 **/
public class FailFastVsFailSafeDemo {
    public static void main(String[] args) {

        demoFailFast();

        demoFailSafe();
    }

    private static void demoFailFast() {
        removeForEach(new ArrayList(List.of(1, 2, 3)));
    }

    private static void demoFailSafe() {
        removeForEach(new CopyOnWriteArrayList<>(List.of(1, 2, 3)));
    }

    private static void removeForEach(Collection<?> values) {
        try {
            // 如果是 Fail-Fast 设计的话，那么会抛出 java.util.ConcurrentModificationException，如：ArrayList
            // 如果是 Fail-Safe 设计的话，那么就没有关系，如 java.util.concurrent.CopyOnWriteArrayList
            for (Object value : values) {
                values.remove(value);
            }
            System.out.println("集合删除成功，目前空间大小：" + values.size());
        } catch (ConcurrentModificationException e) {
            System.out.println("Fail-Fast 异常");
        }
    }
}
