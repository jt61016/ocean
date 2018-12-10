package com.jt61016.ocean.jvm.polymorphic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

/**
 * JSR-292 method handle
 *
 * @author jiangtao
 * @date 2018/12/8 下午5:14.
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println("ClassA : " + s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintlnMH(obj).invokeExact("Hello");
    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws Exception {
        /**
         * MethodType: 代表方法类型,包含了方法的返回值(第一个参数) 和具体参数
         */
        MethodType mt = MethodType.methodType(void.class, String.class);
        /**
         * lookup()句的作用是在指定类中查找符合给定的方法名称 方法类型,并且符合调用权限的方法句柄
         * bingTo()的作用其实就是相当于普通虚方法隐式传递的this对象
         */
        return lookup().findVirtual(reveiver.getClass(), "println", mt).bindTo(reveiver);
    }
}
