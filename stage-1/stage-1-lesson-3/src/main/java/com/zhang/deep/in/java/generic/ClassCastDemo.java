package com.zhang.deep.in.java.generic;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName ClassCastDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/6 22:19
 * @Version 1.0
 **/
public class ClassCastDemo {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(1);
        list.add("A");

        List<Object> list2 = list;

        Type type = int.class;

        Class intType = int.class;

        List<String> stringList = Collections.emptyList();

//        stringList = list2;

        List<String> stringList1 = Arrays.asList("1", "2", "3");

        List<String> stringList2 = new ArrayList<>();
    }

    /**
     * @Description:
     * @Date: 2020/4/6 22:21
     * @Param [a, b]
     * @return void
     **/
    private static void exchange(List a, List b) {
        a.addAll(b);
        Integer v = (Integer) a.get(0);
    }

}
