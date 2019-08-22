package com.jt61016.ocean.spring.springinaction.ch03;

import com.jt61016.ocean.spring.springinaction.ch03.qualifier.Dessert;
import com.jt61016.ocean.spring.springinaction.ch03.qualifier.QualifierConfig;
import com.jt61016.ocean.spring.springinaction.ch03.qualifier.Staple;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = QualifierConfig.class)
public class QualifierTest {
    @Autowired
    @Qualifier("prod")
    Dessert dessert;

    @Autowired
    @Qualifier("prod")
    Staple staple;

    @Test
    public void whichDessert() {
        System.out.println(dessert.value());
    }

    @Test
    public void launch() {
        System.out.println(staple.value() + " and " + dessert.value());
    }
}
