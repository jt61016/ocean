package com.jt61016.ocean.jdk.spi.impl;

import com.jt61016.ocean.jdk.spi.DogService;

/**
 * @author jiangtao
 * @date 2019/3/22 上午10:37.
 */
public class WhiteDogServiceImpl implements DogService {
    @Override
    public void sleep() {
        System.out.println("白色dog...");
    }
}
