package com.zhang.deep.in.java.fucntional;

/**
 * @ClassName DemoAnnotationDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/8 2:08
 * @Version 1.0
 **/
@DemoAnnotation(value = "hello")
public class DemoAnnotationDemo {
    public static void main(String[] args) {
        DemoAnnotation demoAnnotation = DemoAnnotationDemo.class.getAnnotation(DemoAnnotation.class);
        System.out.println(demoAnnotation.value());
    }
}
