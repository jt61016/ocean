package com.jt61016.ocean.spring.springinaction.ch03.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class Cookies implements Dessert {
    @Override
    public String value() {
        return "cookies";
    }
}
