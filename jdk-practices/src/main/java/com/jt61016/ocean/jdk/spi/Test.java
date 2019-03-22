package com.jt61016.ocean.jdk.spi;

import java.util.ServiceLoader;

/**
 * @author jiangtao
 * @date 2019/3/22 上午10:40.
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<DogService> loaders = ServiceLoader.load(DogService.class);
        for (DogService d : loaders) {
            d.sleep();
        }
    }
}
