package com.jt61016.ocean.spring.springinaction.ch03.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class Cake implements Dessert {
    @Override
    public String value() {
        return "cake";
    }
}
