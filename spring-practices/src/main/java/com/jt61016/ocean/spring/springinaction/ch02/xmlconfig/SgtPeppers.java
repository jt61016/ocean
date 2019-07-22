package com.jt61016.ocean.spring.springinaction.ch02.xmlconfig;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author jiangtao
 * @date 2019/7/7 上午10:14.
 */
@Data
@AllArgsConstructor
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";

    @Override
    public void play() {
        System.out.println("Playing " + title + " by " + artist);
    }
}
