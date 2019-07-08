package com.jt61016.ocean.spring.springinaction.ch02.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiangtao
 * @date 2019/7/7 上午10:20.
 */
@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public MediaPlayer cDPlayer() {
        return new CDPlayer(sgtPeppers());
    }

    /*
    使用参数的方式,可以很方便地注入来自autowiring xml 以及其他javaconfig方式注入的bean
    @Bean
    public MediaPlayer cDPlayer(CompactDisc cd) {
        return new CDPlayer(cd);
    }*/
}
