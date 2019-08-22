package com.jt61016.ocean.spring.springinaction.ch03;

import com.jt61016.ocean.spring.springinaction.ch03.profile.Dessert;
import com.jt61016.ocean.spring.springinaction.ch03.profile.ProfileConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ProfileConfig.class)
@ActiveProfiles("prod")
public class ProfileTest {
    @Autowired
    Dessert dessert;

    @Test
    public void whichDessert() {
        System.out.println(dessert.value());
    }
}
