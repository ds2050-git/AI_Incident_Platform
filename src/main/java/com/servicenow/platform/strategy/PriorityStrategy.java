package com.servicenow.platform.strategy;

public interface PriorityStrategy {
    String calculatePriority(String urgency,String impact);
}