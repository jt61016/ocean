package com.jt61016.ocean.jvm.oomandsof;

/**
 * @author jiangtao
 * @date 2018/11/30 下午12:41.
 */
public class SOFTest {
    public static void main(String[] args) {
        recursive(0);

        // recursive(new BigObj(0L));
    }

    private static void recursive(int num) {
        System.out.println(num);
        recursive(++num);
    }

    private static void recursive(BigObj bigObj) {
        System.out.println(bigObj.increase());
        recursive(bigObj);
    }
}
