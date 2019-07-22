package com.jt61016.ocean.spring.springinaction.ch02.xmlconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author jiangtao
 * @date 2019/7/22 下午10:34.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ImportResource(value = "classpath:META-INF/spring/ch2xmlconfig.xml")
@ContextConfiguration(value = "classpath:META-INF/spring/ch2xmlconfig.xml")
public class CDPlayerTest {

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void playerShouldNotBeNull() {
        assertNotNull(player);
    }

    @Test
    public void play() {
        player.play();
    }
}
