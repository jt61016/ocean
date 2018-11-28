package com.jt61016.ocean.jvm.classloading;

/**
 * 被动引用示例 - 不会触发类的初始化
 *
 * 主动引用：
 * 1. 遇到new getstatic putstatic或invokestatic这4条字节码指令
 * 2. 使用java.lang.reflect包的方法对类进行反射调用的时候
 * 3. 初始化一个类时，其父类还没有进行初始化
 * 4. 虚拟机启动时执行的主类
 * 5. 使用JDK1.7的动态语言支持时，如果一个java.lang.invoke.MethodHandle
 *    实例最后的解析结果REF_getStatic REF_putStatic REF_invokeStatic的
 *    方法句柄，且这个方法句柄对应的类没有进行初始化
 */
public class NotInitialization {
    public static void main(String[] args) {
        // superClassStaticField();
        // array();
        constFeild();
    }

    /**
     * 被动使用类字段演示一：
     * 通过子类引用父类的静态字段，不会导致子类初始化
     */
    private static void superClassStaticField() {
        System.out.println(SubClass.value);
    }

    /**
     * 被动使用类字段演示二：
     * 通过数组定义来引用类，不会触发此类的初始化
     */
    private static void array() {
        SuperClass[] superClasses = new SuperClass[5];
    }

    /**
     * 被动使用类字段演示二：
     * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量
     * 的类，因此不会触发定义常量的类的初始化
     */
    private static void constFeild() {
        System.out.println(ConstClass.HELLO_WORLD);
    }
}
