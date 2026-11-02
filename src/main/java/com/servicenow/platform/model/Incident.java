package com.servicenow.platform.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="incidents")
public class Incident {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition="TEXT")
    private String description;
    private String urgency;
    private String impact;
    private String priority;
    @Column(columnDefinition="TEXT")
    private String aiSummary;
    @Column(columnDefinition="TEXT")
    private String aiRecommendation;
    private LocalDateTime createdAt=LocalDateTime.now();

    public Incident(){}

    public Incident(String title,String description,String urgency,String impact){
        this.title=title;
        this.description=description;
        this.urgency=urgency;
        this.impact=impact;
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public String getDescription(){return description;}
    public void setDescription(String description){this.description=description;}
    public String getUrgency(){return urgency;}
    public void setUrgency(String urgency){this.urgency=urgency;}
    public String getImpact(){return impact;}
    public void setImpact(String impact){this.impact=impact;}
    public String getPriority(){return priority;}
    public void setPriority(String priority){this.priority=priority;}
    public String getAiSummary(){return aiSummary;}
    public void setAiSummary(String aiSummary){this.aiSummary=aiSummary;}
    public String getAiRecommendation(){return aiRecommendation;}
    public void setAiRecommendation(String aiRecommendation){this.aiRecommendation=aiRecommendation;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
}