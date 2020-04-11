package com.zhang.deep.in.java;

import javax.xml.transform.Source;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName DeepCloneDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/11 22:21
 * @Version 1.0
 **/
public class DeepCloneDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> values = new ArrayList<>();
        values.add("A");
        values.add("B");
        values.add("C");

        System.out.println("Shallow Clone : ");
        // shallow clone
        List<String> shallowClone = (List<String>) values.clone();
        displayDiff(values, shallowClone);

        System.out.println("Deep Clone : ");
        // deep clone
        List<String> deepClone = deepClone(values);
        displayDiff(values, deepClone);

        // deep clone in java serialization
        System.out.println("Deep Clone in Java Serialization : ");
        List<String> deepClone2 = deepCloneInJavaSerialization(values);
        displayDiff(values, deepClone2);

    }

    private static List<String> deepCloneInJavaSerialization(ArrayList<String> source) throws IOException, ClassNotFoundException {
        ArrayList<String> copy = new ArrayList<>(source);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(copy);

        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        List<String> clone = (List<String>) objectInputStream.readObject();

        return clone;
    }

    private static void displayDiff(List<String> values, List<String> clone) {
        for (int i = 0; i < values.size(); i++) {
            System.out.printf("Object.equals : %s\n", Objects.equals(values.get(i), clone.get(i)));
            System.out.printf("Object == :  %s\n", values.get(i) == clone.get(i));
        }
    }

    private static List<String> deepClone(List<String> source) {
        List<String> clone = new ArrayList<>(source.size());
        for (String value : source) {
            clone.add(new String(value));
        }
        return clone;
    }


}
