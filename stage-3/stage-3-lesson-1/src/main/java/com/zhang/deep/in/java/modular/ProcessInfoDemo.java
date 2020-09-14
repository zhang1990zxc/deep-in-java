package com.zhang.deep.in.java.modular;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 * @ClassName ProcessInfoDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/15 0:14
 * @Version 1.0
 **/
public class ProcessInfoDemo {
    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

        long pid = ProcessHandle.current().pid();
        System.out.println("[Java 9 + 的方法] 当前进程 ID : " + pid);

        Instant instant = Instant.ofEpochMilli(runtimeMXBean.getStartTime());
        LocalDate localDate = LocalDate.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("当前进程启动时间：" + localDate);
        System.out.println("当前进程上线时间：" + runtimeMXBean.getUptime());
        System.out.println("当前进程线程数量：" + threadMXBean.getThreadCount());

        ManagementFactory.getMemoryManagerMXBeans().forEach(memoryManagerMXBean -> {

        });

        System.exit(9);
    }
}
