package com.jt61016.ocean.jvm.classfile;

/**
 * @author jiangtao
 * @date 2018/10/19 上午9:25.
 */
public class ClassFile_S {
    /**
     * 魔数:BABYCAFE
     */
    Byte[] magic = new Byte[4];

    /**
     * 小版本
     */
    Byte[] minor_version = new Byte[2];

    /**
     * 大版本
     */
    Byte[] major_version = new Byte[2];


    /**
     * 常量池大小
     */
    Byte[] constant_pool_count = new Byte[2];

    /**
     * 常量池
     */
    Object constant_pool;


    /**
     * 访问标识
     *
     * {@link com.jt61016.ocean.jvm.classfile.enums.AccessFlagEnum}
     */
    Byte[] access_flags = new Byte[2];

    /**
     * 类索引
     */
    Byte[] this_class = new Byte[2];

    /**
     * 父类索引
     */
    Byte[] super_class = new Byte[2];


    /**
     * 接口索引集合大小
     */
    Byte[] interfaces_count = new Byte[2];

    /**
     * 接口索引集合
     */
    Object interfaces;


    /**
     * 字段表集合大小
     */
    Byte[] fields_count = new Byte[2];

    /**
     * 字段表集合
     */
    Object fields;


    /**
     * 方法表集合大小
     */
    Byte[] methods_count = new Byte[2];

    /**
     * 方法表集合
     */
    Object methods;


    /**
     * 属性表集合大小
     */
    Byte[] attributes_count = new Byte[2];

    /**
     * 属性表集合
     */
    Object attributes;
}
