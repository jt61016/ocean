package com.jt61016.ocean.spring.springinaction.ch02.javaconfig;

/**
 * @author jiangtao
 * @date 2019/7/7 上午11:19.
 */
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
