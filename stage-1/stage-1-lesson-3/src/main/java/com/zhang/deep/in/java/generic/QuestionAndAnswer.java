package com.zhang.deep.in.java.generic;

import org.springframework.core.ResolvableType;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @ClassName QuestionAndAnswer
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/7 17:28
 * @Version 1.0
 **/
public class QuestionAndAnswer<T extends Serializable> {

    List<Map<String, List<Object>>> value = Collections.emptyList();

    public static void main(String[] args) throws Exception {
        question1();
    }

    /** public void example() {
 *     ResolvableType t = ResolvableType.forField(getClass().getDeclaredField("myMap"));
 *     t.getSuperType(); // AbstractMap&lt;Integer, List&lt;String&gt;&gt;
 *     t.asMap(); // Map&lt;Integer, List&lt;String&gt;&gt;
 *     t.getGeneric(0).resolve(); // Integer
 *     t.getGeneric(1).resolve(); // List
 *     t.getGeneric(1); // List&lt;String&gt;
 *     t.resolveGeneric(1, 0); // String
 * }
     */
    private static void question1() throws Exception {
        //获取成员泛型参数类型
        Field field = QuestionAndAnswer.class.getDeclaredField("value");
        ResolvableType resolvableType = ResolvableType.forField(field);
        System.out.println(resolvableType.getGeneric(0));

        //获取类泛型参数类型
        TypeVariable[] params = QuestionAndAnswer.class.getTypeParameters();
        for(TypeVariable typeVariable : params){
            System.out.println(typeVariable);
        }

        //具体参数类型
        QuestionAndAnswer<String> questionAndAnswer = new QuestionAndAnswer<>();
        TypeVariable[] params2 = questionAndAnswer.getClass().getTypeParameters();
        for(TypeVariable typeVariable : params2){
            System.out.println(typeVariable);
        }
    }
}
