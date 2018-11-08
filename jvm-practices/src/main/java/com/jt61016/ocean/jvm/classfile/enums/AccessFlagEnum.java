package com.jt61016.ocean.jvm.classfile.enums;

/**
 * The value of the access_flags item is a mask of flags used to denote
 * access permissions to and properties of this class or interface
 *
 * @author jiangtao
 * @date 2018/11/8 下午4:31.
 */
public enum AccessFlagEnum {
    /**
     * public
     */
    ACC_PUBLIC("ACC_PUBLIC", 0x0001),
    /**
     * final
     */
    ACC_FINAL("ACC_FINAL", 0x0010),
    /**
     * super
     */
    ACC_SUPER("ACC_SUPER", 0x0020),
    /**
     * interface
     */
    ACC_INTERFACE("ACC_INTERFACE", 0x0200),
    /**
     * abstract
     */
    ACC_ABSTRACT("ACC_ABSTRACT", 0x0400),
    /**
     * synthetic
     */
    ACC_SYNTHETIC("ACC_SYNTHETIC", 0x1000),
    /**
     * annotation
     */
    ACC_ANNOTATION("ACC_ANNOTATION", 0x2000),
    /**
     * enum
     */
    ACC_ENUM("ACC_ENUM", 0x4000);


    private String flagName;
    private Short value;

    AccessFlagEnum(String flagName, Integer value) {
        this.flagName = flagName;
        this.value = value.shortValue();
    }

    public String getFlagName() {
        return flagName;
    }
    public Short getValue() {
        return value;
    }
}
