package com.zhang.deep.in.java;

import sun.misc.Unsafe;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName AtomicDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/17 22:29
 * @Version 1.0
 **/
public class AtomicDemo {
    public static void main(String[] args) throws PrivilegedActionException {
        getUnsafe();
    }

    private static void demoAtomicLong() {
        // long 表示 64位（8字节），高和低两端
        // long 并非线程安全，就是 volatile（高和低操作时，至少两次操作）
        AtomicLong l = new AtomicLong();
        // set 和 get 通过 JVM 特殊操作，不在直接写入和获取
    }

    private static void demoAtomicInteger() {
        // int 表示 int(32), char(16), short(16), byte(8), boolean(1)
        // AtomicInteger 内部使用 int 作为变量标识，1 表示 true, 0 表示 false
        // AtomicInteger set 和 get 操作均为 volatile 语义（MB）
        // AtomicInteger CAS Unsafe(Java 8) 和 VarHandle（Java 9+）
    }

    private static void demoAtomicBoolean() {
        AtomicBoolean b = new AtomicBoolean();
        // AtomicBoolean 内部使用 int 作为变量标识，1 表示 true, 0 表示 false
        // AtomicBoolean set 和 get 操作均为 volatile 语义（MB）
        // AtomicBoolean CAS Unsafe(Java 8) 和 VarHandle（Java 9+）
    }

    private static void getVarHandle() {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
    }

    private static void getUnsafe() throws PrivilegedActionException {
        //无法通过正常的方法调用
//        Unsafe unsafe = Unsafe.getUnsafe();

        final PrivilegedExceptionAction<Unsafe> action = () -> {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        };
        Unsafe unsafe = AccessController.doPrivileged(action);
        System.out.println(unsafe);
    }

}
