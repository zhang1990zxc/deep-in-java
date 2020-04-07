package com.zhang.deep.in.java.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * @ClassName GenericParameterTypeDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/6 22:57
 * @Version 1.0
 **/
public class GenericParameterTypeDemo {

    public static void main(String[] args) {

        Container<String> container = new Container<>("string");

        //Error : Integer不是CharSequence子类
//        Container<Integer> container1 = new Container<>(2);

        //StringBuffer是CharSequence子类
        //String参数也是CharSequence子类
        //运行时：Object
        Container<StringBuffer> container2 = new Container("Hello,World");
        //通过构造传递参数是String类型，运行时都是Object，没有问题
        System.out.println(container2.getElement());
        //不过当container2对象声明的类型为Container<StringBuffer>
        //E类型为StringBuffer，因此set(E)，E必须是StringBuffer
        container2.set(new StringBuffer("2020"));
        System.out.println(container2.getElement());
        //Java泛型对象操作是，看声明对象泛型参数类型

        add(new ArrayList<>(), "Hello,World");
        add(new ArrayList<>(), 1); //auto-boxing

        forEach(Arrays.asList(1, 2, 3), System.out::println);

    }

    //extend是声明上限类型
    public static class Container<E extends CharSequence> {
        private E element;

        public Container(E e) {
            this.element = e;
        }

        //operations
        public boolean set(E e) {
            this.element = e;
            return true;
        }

        public E getElement() {
            return element;
        }

    }

    //多界限泛型参数类型
    public static class C {

    }

    public static interface I {

    }

    public static interface I2 {

    }

    public static class Template<T extends C & I & I2> {

    }

    public static class TemplateClass extends C implements I, I2 {

    }

    //把一个类型的元素，添加到集合中
    public static <C extends Collection<E>, E extends Serializable> void add(C target, E element) {
        target.add(element);
    }

    public static <C extends Iterable<E>, E extends Serializable> void forEach(C source, Consumer<E> consumer) {
        for(E e : source){
            consumer.accept(e);
        }
    }

}
