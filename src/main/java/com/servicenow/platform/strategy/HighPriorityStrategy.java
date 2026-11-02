package com.servicenow.platform.strategy;

import org.springframework.stereotype.Component;

@Component
public class HighPriorityStrategy implements PriorityStrategy {
    @Override
    public String calculatePriority(String urgency,String impact){
        if("HIGH".equalsIgnoreCase(urgency)&&"HIGH".equalsIgnoreCase(impact)){
            return "P1_CRITICAL";
        }
        return "P2_HIGH";
    }
}