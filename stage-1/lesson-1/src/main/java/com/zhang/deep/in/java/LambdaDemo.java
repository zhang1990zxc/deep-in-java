package com.zhang.deep.in.java;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @ClassName LambdaDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author zhang
 * @Date 2020/4/6 10:00
 * @Version 1.0
 **/
public class LambdaDemo {

    //SCFP = Supplier + Consumer + Function + Predicate
    //四种模式（缺少 Action 模式）

    //Action模式
    private static void showAction() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        Runnable runnable2 = () -> {};

        Runnable runnable3 = LambdaDemo::showConsumer;
    }

    //Supplier模式
    private static void showSupplier() {
        String string = "Hello,World";

        Supplier<String> supplier = () -> "Hello,World";

        Supplier<String> supplier2 = () -> new Integer(2).toString();
    }

    //Consumer模式
    private static void showConsumer() {
        //匿名内部类传统写法
        PropertyChangeListener listener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                println(evt);
            }
        };

        //lambda基本写法
        PropertyChangeListener listener2 = evt -> {
            println(evt);
        };

        //lambda简略写法
        //属于有入参，没有返回，与println(object)一样
        PropertyChangeListener listener3 = LambdaDemo::println;

    }

    //Function模式
    private static void showFunction() {
        Function<String, Integer> function = LambdaDemo::compareTo;
    }

    private static Integer compareTo(String value) {
        return value.compareTo("Hello,World");
    }

    public static void main(String[] args) {
        Action action = () -> {

        };
    }

    private static void println(Object object) {
        System.out.println(object);
    }

    @FunctionalInterface
    public interface Action {
        void execute();

        default void doExecute(){
            execute();
        };

        int hashCode();

    }

    private static void stream() {
        Stream.of(1, 2, 3, 4, 5).map(String::valueOf);
    }

}
