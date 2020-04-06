package com.zhang.deep.in.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SnapshotDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/6 19:44
 * @Version 1.0
 **/
public class SnapshotDemo {

    private static class Data {

        private List<String> value;

        // 把内部的状态暴露到外部（外部可以修改）
        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }

    private static class SnapshotData {

        private List<String> value;

        public List<String> getValue() {
            return new ArrayList(value);
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
