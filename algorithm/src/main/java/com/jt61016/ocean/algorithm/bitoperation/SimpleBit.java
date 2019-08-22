package com.jt61016.ocean.algorithm.bitoperation;

/**
 * @author jiangtao
 * @date 2019/7/25 下午4:57.
 */
public class SimpleBit {

    public static void main(String[] args) {
        bitValue(5, 0);
        bitValue(5, 1);
        bitValue(5, 2);
        bitValue(5, 3);
    }

    public static void bitValue(Integer source, Integer index) {
        System.out.println("第 " + index);
        if (index < 0 || Math.pow(2, index) > source) {
            System.out.println("不在区间" + 0);
        }

        int flag = (source & (1 << index)) >> index;
        System.out.println(flag);


    }

}
