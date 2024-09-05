package com.projecto.project.survey_json.Domain.Entities;


import java.time.LocalDateTime;


import com.projecto.project.Embeddable.CreatedUpdatedTime;
import com.projecto.project.Survey.Domain.Entities.Survey;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "survey_json")
public class SurveyJson {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "payload" , columnDefinition = "text")
    private String json;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey; 

    @Embedded 
    private CreatedUpdatedTime createdUpdatedTime;

    public SurveyJson() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    
}
