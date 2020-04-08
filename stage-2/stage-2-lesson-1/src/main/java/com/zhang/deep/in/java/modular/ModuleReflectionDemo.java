package com.zhang.deep.in.java.modular;

import java.lang.module.ModuleDescriptor;
import java.util.logging.Logger;

/**
 * @ClassName ModuleReflectionDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/8 16:17
 * @Version 1.0
 **/
public class ModuleReflectionDemo {

    public static void main(String[] args) {

        Class<ModuleReflectionDemo> moduleReflectionDemoClass = ModuleReflectionDemo.class;

        Module module = moduleReflectionDemoClass.getModule();

        System.out.printf("类 %s 存在于模块 ：%s 之中\n",
                moduleReflectionDemoClass.getSimpleName(), module.getName());

        ModuleDescriptor moduleDescriptor = module.getDescriptor();

        moduleDescriptor.requires().stream().forEach(requires -> {
            System.out.printf("requires 模块名称 %s, 修饰符定义 ：%s 之中\n",
                    requires.name(), requires.modifiers());
        });

        moduleDescriptor.exports().stream().forEach(exports -> {
            System.out.printf("exports 包名称 %s, 修饰符定义 ：%s 之中\n",
                    exports.source(), exports.targets());
        });


    }

}
