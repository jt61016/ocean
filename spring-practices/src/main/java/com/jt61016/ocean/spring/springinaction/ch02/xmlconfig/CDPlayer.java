package com.jt61016.ocean.spring.springinaction.ch02.xmlconfig;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author jiangtao
 * @date 2019/7/7 上午11:19.
 */
@Data
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    private String brand;

    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        System.out.println("欢迎使用 " + brand + " 品牌");
        cd.play();
    }
}
