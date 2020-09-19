package com.zhang.lesson;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @ClassName MapEntryDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/19 19:13
 * @Version 1.0
 **/
public class MapEntryDemo {

    public static void main(String[] args) {
        slowApproach();
        fastApproach();
    }

    private static void fastApproach() {
        Map<String, Integer> map = new ConcurrentSkipListMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            entry.setValue(entry.getValue() + 1);
        }
        System.out.println(map);
    }

    private static void slowApproach() {
        Map<String, Integer> map = new ConcurrentSkipListMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            value++;
            map.put(key, value);
        }
        System.out.println(map);
    }

}
