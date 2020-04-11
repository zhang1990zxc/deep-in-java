package com.zhang.deep.in.java;

import java.util.*;

/**
 * @ClassName MapAndSetDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/10 22:26
 * @Version 1.0
 **/
public class MapAndSetDemo {

    public static void main(String[] args) {

        //通常Set是Map 可用的实现，Set底层运用Map实现
        //比如HashSet底层运用了HashMap
        Map<String, Object> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        //TreeSet底层运用了TreeMap
        map = new TreeMap<>();
        set = new TreeSet<>();

    }

}
