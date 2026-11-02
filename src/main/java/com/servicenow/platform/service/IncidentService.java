package com.servicenow.platform.service;

import com.servicenow.platform.model.Incident;
import com.servicenow.platform.repository.IncidentRepository;
import com.servicenow.platform.strategy.HighPriorityStrategy;
import com.servicenow.platform.strategy.PriorityStrategy;
import com.servicenow.platform.strategy.StandardPriorityStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidentService {
    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private AIService aiService;
    @Autowired
    private HighPriorityStrategy highPriorityStrategy;
    @Autowired
    private StandardPriorityStrategy standardPriorityStrategy;

    public Incident createIncident(Incident incident){
        PriorityStrategy strategy;
        if("HIGH".equalsIgnoreCase(incident.getUrgency())||"HIGH".equalsIgnoreCase(incident.getImpact())){
            strategy=highPriorityStrategy;
        }else{
            strategy=standardPriorityStrategy;
        }
        incident.setPriority(strategy.calculatePriority(incident.getUrgency(),incident.getImpact()));
        incident.setAiSummary(aiService.generateSummary(incident.getDescription()));
        incident.setAiRecommendation(aiService.generateRecommendation(incident.getTitle(),incident.getDescription()));
        return incidentRepository.save(incident);
    }

    public List<Incident> getAllIncidents(){
        return incidentRepository.findAll();
    }
}