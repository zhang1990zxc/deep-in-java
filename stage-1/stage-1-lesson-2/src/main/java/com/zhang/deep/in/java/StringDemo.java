package com.zhang.deep.in.java;

import java.lang.reflect.Field;

/**
 * @ClassName StringDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author zhang
 * @Date 2020/4/6 16:14
 * @Version 1.0
 **/
public class StringDemo {

    public static void main(String[] args) throws Exception {

        //常量化是原生类型支持，赋值方式
        int a = 1; // 常量
        String value = "Hello"; //常量 (语法特性) = 对象类型常量化

        //面向对象规则：一切对象需要new
        //合法的写法(异类写法)
        String value2 = new String("Hello");

        System.out.println("value : "+value);
        System.out.println("value2 : "+value2);

        char[] chars = "World".toCharArray();
        Field valueFiled = String.class.getDeclaredField("value");
        valueFiled.setAccessible(true);
        valueFiled.set(value2, chars);

        System.out.println("value : "+value);
        System.out.println("value2 : "+value2);
    }

    public static class ExtendableString {

        private final char value[];

        private int hash;

        public ExtendableString(char[] value) {
            this.value = value;
        }

        public int hashCode() {
            int h = hash;
            if (h == 0 && value.length > 0) {
                char val[] = value;

                for (int i = 0; i < value.length; i++) {
                    h = 31 * h + val[i];
                }
                hash = h;
            }
            return h;
        }

        public final boolean equals(Object object) {
            return true;
        }
    }

}
