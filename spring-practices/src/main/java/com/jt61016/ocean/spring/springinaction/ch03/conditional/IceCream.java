package com.jt61016.ocean.spring.springinaction.ch03.conditional;

import com.jt61016.ocean.spring.springinaction.ch03.conditional.condition.TemperatureCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(TemperatureCondition.class)
public class IceCream implements Dessert {
    @Override
    public String value() {
        return "icecream";
    }
}
