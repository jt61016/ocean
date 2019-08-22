package com.jt61016.ocean.spring.springinaction.ch03.conditional.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TemperatureCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (conditionContext.getEnvironment() != null) {
            if (conditionContext.getEnvironment().acceptsProfiles("prod"))
                return true;
            return false;
        }
        return true;
    }
}
