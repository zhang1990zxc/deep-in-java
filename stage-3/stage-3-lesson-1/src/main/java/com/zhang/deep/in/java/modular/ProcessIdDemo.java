package com.zhang.deep.in.java.modular;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @ClassName ProcessIdDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/15 0:06
 * @Version 1.0
 **/
public class ProcessIdDemo {

    public static void main(String[] args) {
        getProcessIdBeforeJava9();
        getProcessIdInJava9();
        getProcessIdInJava10();
    }

    private static void getProcessIdInJava10() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println("[Java 10 + 的方法] 当前进程 ID : " + runtimeMXBean.getPid());
    }

    private static void getProcessIdInJava9() {
        long pid = ProcessHandle.current().pid();
        System.out.println("[Java 9 + 的方法] 当前进程 ID : " + pid);
    }

    private static void getProcessIdBeforeJava9() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        String name = runtimeMXBean.getName();
        String pid = name.substring(0, name.indexOf("@"));
        System.out.println("[Java 9 之前的方法] 当前进程 ID : " + pid);
    }

}
