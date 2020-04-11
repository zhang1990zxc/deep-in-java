package com.zhang.deep.in.java;

import java.util.Map;

/**
 * @ClassName MapDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/11 21:36
 * @Version 1.0
 **/
public class MapDemo {

    public static void main(String[] args) {

        Map<Integer, String> map = Map.of(1,"A");
        System.out.println(map.get(1));
        System.out.println(map.get(1.0));
        System.out.println(map.get(1L));
        System.out.println(map.get(new Key(1)));
        System.out.println(map.containsKey(new Key(1)));

    }

    private static class Key {

        private final int value;

        private Key(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o instanceof Integer) {
                return this.value == ((Integer) o).intValue();
            }
            Key key = (Key) o;
            return value == key.value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }

}
