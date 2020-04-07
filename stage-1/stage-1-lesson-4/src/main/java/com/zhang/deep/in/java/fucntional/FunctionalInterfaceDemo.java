package com.zhang.deep.in.java.fucntional;

/**
 * @ClassName FunctionalInterfaceDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/7 19:59
 * @Version 1.0
 **/
public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        Function1 f1 = () -> {};

        Function2WithoutAnnotation f2 = () -> {};

    }

    @FunctionalInterface
    public interface Function1 {
        void execute();

        default String getDescription(){
            return String.valueOf(this);
        }
    }

//    @FunctionalInterface
    public interface Function2WithoutAnnotation {
        void execute();
    }

}

