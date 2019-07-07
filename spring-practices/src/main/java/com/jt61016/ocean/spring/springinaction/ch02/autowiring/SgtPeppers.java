package com.jt61016.ocean.spring.springinaction.ch02.autowiring;

import org.springframework.stereotype.Component;

/**
 * @author jiangtao
 * @date 2019/7/7 上午10:14.
 */
@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
