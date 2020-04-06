package com.zhang.deep.in.java;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName GenericTypeDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author zhang
 * @Date 2020/4/5 1:55
 * @Version 1.0
 **/
public class GenericTypeDemo {

    /**
     * @Description:
     * @Date: 2020/4/5 1:57
     * @Param <S> 来源类型
     * @param <T> 目标类型
     * @return
     **/
    public interface Converter<S,T> {
        T convert(S source);
    }

    public static void main(String[] args) {
        new Converter<String, Integer>() {
            public Integer convert(String source) {
                return Integer.valueOf(source);
            }
        };

        List<String> data = Collections.emptyList();

        List<Integer> data2 = Collections.emptyList();

        List data3 = Collections.emptyList();

//        data = data2;

        data = data3;

    }

    /**
     * @Description:
     * @Date: 2020/4/5 2:18
     * @Param [value]
     * @return void
     **/
    public static void doConvert(List<String> value){

    }

//    方法签名冲突
//    public static void doConvert(List value){
//
//    }

    public static void doConvert(List<String> value, int data){

    }

}
