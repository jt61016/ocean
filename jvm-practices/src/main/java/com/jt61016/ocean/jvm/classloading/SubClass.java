package com.jt61016.ocean.jvm.classloading;

public class SubClass extends SuperClass {
    static {
        System.out.println("Sub class init!");
    }
}
