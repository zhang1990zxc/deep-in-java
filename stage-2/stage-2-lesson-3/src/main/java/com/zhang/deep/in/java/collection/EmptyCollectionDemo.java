package com.zhang.deep.in.java.collection;

import java.util.Collections;
import java.util.List;

/**
 * @ClassName EmptyCollectionDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/14 22:53
 * @Version 1.0
 **/
public class EmptyCollectionDemo {

    public static void main(String[] args) {
        // 对自己（严格）：所有的返回接口类型的方法禁止返回 null
        // 对别人（宽容）：要做 null 判断（尤其在 RPC 场景）

        // 集合方法入参：
        // 1. 如果能用 Iterable 尽量用
        // 2. 其次是 Collection
        // 3. 再者是 List 或 Set
        // 禁止使用具体类型，比如：ArrayList，LinkedHashSet
    }

    public static List<String> getIdsList(String name) {
        if(name == null || name.length() < 1)
            return Collections.emptyList();
        return Collections.emptyList();
    }

}
