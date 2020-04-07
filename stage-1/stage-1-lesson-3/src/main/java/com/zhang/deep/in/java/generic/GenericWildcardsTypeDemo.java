package com.zhang.deep.in.java.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @ClassName GenericWildcardsTypeDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/7 15:20
 * @Version 1.0
 **/
public class GenericWildcardsTypeDemo {

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();
        upperBoundedWildcards(numbers);
        unBoundedWildcards(numbers);

        lowerBoundedWildcards(numbers);
    }

    private static void lowerBoundedWildcards(List<Number> numbers) {
        lowerBoundedWildcardsDemo(numbers, numbers);
    }

    private static void lowerBoundedWildcardsDemo(List<? extends Number> producer,
                                              List<? super Number> consumer) {
        for(Number number : producer){

        }
        consumer.add(1);
        consumer.add((short) 2);
    }

    private static void unBoundedWildcards(List<Number> numbers) {
        //完全通配类型在运行时与非通配泛型会出现方法签名冲突，因为两者具有相同声明类型。
        //然后完全通配类型，可以适配任意类型，比如集合
        //反而具体类型泛型会限制类型范围
        unboundedWildcardsDemo(numbers);
    }

    private static void upperBoundedWildcards(List<Number> numbers) {
        numbers.add(Byte.valueOf((byte) 1));
        numbers.add(Short.valueOf((short) 2));
        numbers.add(Integer.valueOf(3));
        numbers.add(Long.valueOf(4L));

        List<Byte> bytes = Arrays.asList((byte) 5);
        List<Short> shorts = Arrays.asList((short) 6);
        List<Integer> integers = Arrays.asList(7);

        numbers.addAll(bytes);
        numbers.addAll(shorts);
        numbers.addAll(integers);

        upperBoundedWildcardsDemo(numbers, System.out::println);
    }


    //泛型类型擦写，导致和下方法冲突
    public static void unboundedWildcardsDemo(Iterable<?> iterable){
        for(Object e : iterable){
            System.out.println(e);
        }
    }

//    public static void unboundedWildcardsDemo(Iterable<Object> iterable){
//        for(Object e : iterable){
//            System.out.println(e);
//        }
//    }

    public static void upperBoundedWildcardsDemo(List<? extends Number> list, Consumer<Object> consumer){
        for(Object o : list){
            consumer.accept(o);
        }
    }

}
