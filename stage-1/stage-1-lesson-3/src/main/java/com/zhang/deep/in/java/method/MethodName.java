package com.zhang.deep.in.java.method;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

/**
 * @ClassName MethodName
 * @Description 整条街最靓的仔，写点注释吧
 * @Author 天涯
 * @Date 2020/4/7 18:47
 * @Version 1.0
 **/
public class MethodName {

    public static void main(String[] args) {
        Stream.of(1, 2, 3).forEachOrdered(System.out::println);

        Lock lock = new ReentrantLock();
        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    // 动词+名词
    public List<String> getValues() {
        return Collections.emptyList();
    }

    // 动词+名词+副词
    public List<String> getValuesSynchronously() {
        return Collections.emptyList();
    }

    public class ViewRender {

        public void render() {

        }

        public void renderSynchronously() {

        }

        public void renderConcurrently() {

        }
    }

}
