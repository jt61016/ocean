package com.jt61016.ocean.jvm.statictest;

/**
 * static变量，只是在同一个jvm中共享，不同main方法会启动不同的jvm
 */
public class StaticHolder {
    public static String value = "init";

    public static void main(String[] args) {
        //System.out.println(StaticHolder.class.hashCode());
        System.out.println(System.identityHashCode(StaticHolder.value));
        while(true) {
            System.out.println(value);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
