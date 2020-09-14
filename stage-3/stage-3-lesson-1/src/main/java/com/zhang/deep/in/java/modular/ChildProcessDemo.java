package com.zhang.deep.in.java.modular;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

/**
 * @ClassName ChildProcessDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/9/15 0:25
 * @Version 1.0
 **/
public class ChildProcessDemo {
    public static void main(String[] args) throws IOException {

        // IDEA(主进程) -> 启动 ChildProcessDemo -> Windows 计算器（calc）
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

        if (operatingSystemMXBean.getName().startsWith("Windows")) {
            // 启动计算器
            Runtime.getRuntime().exec("calc");

//            Process process = Runtime.getRuntime().exec("dir");
//
//            InputStream inputStream = process.getInputStream();
//            int data = 0;
//            while ((data = inputStream.read()) > -1) {
//                System.out.print(data);
//            }
        }

    }
}
