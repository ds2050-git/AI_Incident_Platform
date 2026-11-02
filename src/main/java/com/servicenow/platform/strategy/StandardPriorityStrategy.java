package com.servicenow.platform.strategy;

import org.springframework.stereotype.Component;

@Component
public class StandardPriorityStrategy implements PriorityStrategy {
    @Override
    public String calculatePriority(String urgency,String impact){
        if("LOW".equalsIgnoreCase(urgency)&&"LOW".equalsIgnoreCase(impact)){
            return "P4_LOW";
        }
        return "P3_MODERATE";
    }
}