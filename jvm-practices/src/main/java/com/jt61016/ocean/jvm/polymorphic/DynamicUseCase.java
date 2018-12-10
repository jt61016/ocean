package com.jt61016.ocean.jvm.polymorphic;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * @author jiangtao
 * @date 2018/12/10 下午7:44.
 */
public class DynamicUseCase {
    class GrandFather {
        public void thinking() {
            System.out.println("i am grandfather");
        }
    }

    class Father extends GrandFather {
        @Override
        public void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        @Override
        public void thinking() {
            System.out.println("i am son");
            try {
                MethodType mt = MethodType.methodType(void.class);
                Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                IMPL_LOOKUP.setAccessible(true);
                MethodHandles.Lookup lkp = (MethodHandles.Lookup)IMPL_LOOKUP.get(null);
                MethodHandle mh = lkp.findSpecial(GrandFather.class, "thinking", mt, GrandFather.class);
                mh.invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        (new DynamicUseCase().new Son()).thinking();
    }
}
