package com.servicenow.platform.controller;

import com.servicenow.platform.model.Incident;
import com.servicenow.platform.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidents")
@CrossOrigin(origins="*")
public class IncidentController {
    @Autowired
    private IncidentService incidentService;

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident){
        return incidentService.createIncident(incident);
    }

    @GetMapping
    public List<Incident> getAllIncidents(){
        return incidentService.getAllIncidents();
    }
}