package com.zhang.deep.in.java.modular;

/**
 * @ClassName DumpThreadDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/14 1:45
 * @Version 1.0
 **/
public class DumpThreadDemo {
    public static void main(String[] args) {
        new Throwable("Stack trace").printStackTrace(System.out);
        Thread.dumpStack();
        StackWalker stackWalker = StackWalker.getInstance();
        stackWalker.forEach(System.out::println);
    }
}
