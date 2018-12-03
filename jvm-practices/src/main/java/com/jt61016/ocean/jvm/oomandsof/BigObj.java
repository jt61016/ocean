package com.jt61016.ocean.jvm.oomandsof;

/**
 * @author jiangtao
 * @date 2018/11/30 下午12:41.
 */
public class BigObj {
    public Long num;
    public Integer[] data = new Integer[1024 * 1024];

    public BigObj(Long num) {
        this.num = num;
    }

    public Long increase() {
        num++;
        return num;
    }
}
