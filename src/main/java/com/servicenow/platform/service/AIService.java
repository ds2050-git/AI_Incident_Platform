package com.servicenow.platform.service;

import org.springframework.stereotype.Service;

@Service
public class AIService {
    public String generateSummary(String description){
        return "AI Summary: Root issue analyzed for - "+(description.length()>30?description.substring(0,30)+"...":description);
    }

    public String generateRecommendation(String title,String description){
        if(title.toLowerCase().contains("database")||description.toLowerCase().contains("sql")){
            return "KB10023: Check database connection pool and verify DB CPU metrics.";
        }
        if(title.toLowerCase().contains("network")||description.toLowerCase().contains("timeout")){
            return "KB10045: Verify DNS configuration and ingress controller latency.";
        }
        return "KB10001: Execute standard restart workflow and inspect service logs.";
    }
}