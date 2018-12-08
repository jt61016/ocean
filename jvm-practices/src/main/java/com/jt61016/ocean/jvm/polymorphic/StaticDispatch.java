package com.jt61016.ocean.jvm.polymorphic;

/**
 * 方法动态分派(重载)与静态分派(重写)
 *
 * @author jiangtao
 * @date 2018/12/8 下午2:27.
 */
public class StaticDispatch {
    static abstract class Human {
        protected abstract void sayHello();
    }

    static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man");
        }
    }

    static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman");
        }
    }

    public void sayHello(Human guy) {
        System.out.println("Hello, guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("Hello, gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("Hello, lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        // 静态分派
        sd.sayHello(man);
        sd.sayHello(woman);

        // 动态分派
        man.sayHello();
        woman.sayHello();
    }
}
