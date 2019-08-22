package com.jt61016.ocean.spring.springinaction.ch03;

import com.jt61016.ocean.spring.springinaction.ch03.conditional.ConditionalConfig;
import com.jt61016.ocean.spring.springinaction.ch03.conditional.Dessert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConditionalConfig.class)
@ActiveProfiles("prod")
public class ConditionalTest {
    @Autowired(required = false)
    Dessert dessert;

    @Test
    public void exist() {
        if (null == dessert) {
            System.out.println("conditional is false");
        } else {
            System.out.println("conditional is true");
        }
    }
}
