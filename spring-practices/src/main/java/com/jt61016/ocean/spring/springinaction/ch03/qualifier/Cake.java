package com.jt61016.ocean.spring.springinaction.ch03.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("prod")
public class Cake implements Dessert {
    @Override
    public String value() {
        return "cake";
    }
}
