package com.zhang.deep.in.java;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.Callable;

/**
 * @ClassName InnerClassDemo
 * @Description 整条街最靓的仔，写点注释吧
 * @Author zhang
 * @Date 2020/4/6 9:19
 * @Version 1.0
 **/
public class InnerClassDemo {

    static {
        new Runnable() {
            public void run() {

            }
        };
    }

    {
        new Callable(){
            public Object call() throws Exception {
                return null;
            }
        };
    }

    public InnerClassDemo() {
        new Comparable(){
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

    public static void main(String[] args) {
        PropertyChangeListener listener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {

            }
        };
    }


    static class PropertyChangeListenerImpl implements PropertyChangeListener {
        public void propertyChange(PropertyChangeEvent evt) {
            new KeyListener() {
                public void keyTyped(KeyEvent e) {

                }

                public void keyPressed(KeyEvent e) {

                }

                public void keyReleased(KeyEvent e) {

                }
            };
        }
    }

}
