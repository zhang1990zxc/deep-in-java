package com.zhang.deep.in.java.fucntional;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @ClassName PredicateDesignDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/8 0:44
 * @Version 1.0
 **/
public class PredicateDesignDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Collection<Integer> even = filter(numbers, num -> num % 2 != 0);
        Collection<Integer> odd = filter(numbers, num -> num % 2 == 0);
        System.out.println(even);
        System.out.println(odd);

        Stream.of(1, 2, 3, 4, 5).filter(num -> num%2 == 0).forEach(System.out::println);
    }

    private static <E> Collection<E> filter(Collection<E> source, Predicate<E> predicate) {
        //集合类操作， 请不要直接利用参数
        List<E> copy = new ArrayList<>(source);
        Iterator<E> iterator = copy.iterator();
        while (iterator.hasNext()) {
            E e = iterator.next();
            if (predicate.test(e)) {
                iterator.remove();
            }
        }
        return Collections.unmodifiableList(copy);
    }

}
