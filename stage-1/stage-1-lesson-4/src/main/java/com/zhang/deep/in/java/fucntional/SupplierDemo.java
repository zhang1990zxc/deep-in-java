package com.zhang.deep.in.java.fucntional;

import java.util.function.Supplier;

/**
 * @ClassName SupplierDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/7 20:28
 * @Version 1.0
 **/
public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Long> supplier = getLong();
    }

    public static Supplier<Long> getLong() {
        return System::currentTimeMillis;
    }

}
