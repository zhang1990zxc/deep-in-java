package com.zhang.lesson;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HashMapDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/20 0:36
 * @Version 1.0
 **/
public class HashMapDemo {
    public static void main(String[] args) {
        String strValue = "Hello,World";
        Integer intValue = strValue.hashCode();
        Map<Object, Object> map = new HashMap<>();
        map.put(strValue, 1);
        map.put(intValue, 2);
        System.out.println(map);
    }
}
