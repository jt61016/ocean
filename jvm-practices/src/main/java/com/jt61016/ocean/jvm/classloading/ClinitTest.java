package com.jt61016.ocean.jvm.classloading;

/**
 * 类的初始化过程，就是执行类构造器<clinit>()方法
 */
public class ClinitTest {
    public int i = 1;
    public static int si = 2;
    public static final int sfi = 3;

    static {
        System.out.println("just static code");
    }

    public ClinitTest() {
        System.out.println("Default <init>");
    }

    public ClinitTest(int i, int csi) {
        this.i = i;
        si = csi;
        System.out.println("<init>(int, int)");
    }
}
