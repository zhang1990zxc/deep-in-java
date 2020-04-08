package com.zhang.deep.in.java.modular;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName UnnamedModuleDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/8 15:13
 * @Version 1.0
 **/
public class UnnamedModuleDemo {

    public static void main(String[] args) {
        MapUtils.getMap(null, null);
        StringUtils.isBlank("OK");
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.close();
    }

}
