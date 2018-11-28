package com.jt61016.ocean.jvm.classloading;

public class SuperClass {
    static {
        System.out.println("Super class init!");
    }
    public static int value = 123;
}
