package com.jt61016.ocean.jdk.spi.impl;

import com.jt61016.ocean.jdk.spi.DogService;

/**
 * @author jiangtao
 * @date 2019/3/22 上午10:36.
 */
public class BlackDogServiceImpl implements DogService {
    @Override
    public void sleep() {
        System.out.println("黑色dog...");
    }
}
