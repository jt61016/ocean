package com.jt61016.ocean.jvm.classloading;

public class ConstClass {
    static {
        System.out.println("Const Class init!");
    }

    public static final String HELLO_WORLD = "hello world!";
}
