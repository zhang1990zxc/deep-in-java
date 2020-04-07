package com.zhang.deep.in.java.fucntional;

import java.util.function.Supplier;

/**
 * @ClassName SupplierDesignDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/8 0:14
 * @Version 1.0
 **/
public class SupplierDesignDemo {

    public static void main(String[] args) {

        echo("Hello,World");
        echo(SupplierDesignDemo::getMessage);

        getMessage();  //及时返回数据

        Supplier<String> message = supplierMessage(); //待执行数据
        message.get(); //实际执行
    }

    private static String getMessage() {
        sleep(1000);
        return "Hello,World";
    }

    private static Supplier<String> supplierMessage() {
        return SupplierDesignDemo::getMessage;
    }

    private static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void echo(String message) {
        System.out.println(message);
    }

    public static void echo(Supplier<String> message) {
        System.out.println(message.get());
    }

}
