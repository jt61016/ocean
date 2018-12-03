package com.jt61016.ocean.jvm.statictest;

/**
 * static变量，只是在同一个jvm中共享，不同main方法会启动不同的jvm
 * 因此这里对StaticHolder.value的修改，不会影响StaticHolder.main方法中value值
 */
public class StaticModifier {
    public static void main(String[] args) {
        //System.out.println(StaticHolder.class.hashCode());
        System.out.println(System.identityHashCode(StaticHolder.value));
        System.out.println(StaticHolder.value);
        StaticHolder.value = "modified";
        System.out.println(StaticHolder.value);
        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
