package com.projecto.project.survey_json.Domain.Entities;

import java.time.LocalDateTime;

import com.projecto.project.Survey.Domain.Entities.Survey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "survey_json")
public class surveyJson {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at" , columnDefinition = "timestamp")
    private LocalDateTime createdAt;

    @Column(name = "updated_at" , columnDefinition = "timestamp")
    private LocalDateTime updatedAt;

    @Column(name = "payload" , columnDefinition = "jsonb")
    private String json;

    @ManyToOne
    @JoinColumn(name = "survey_id")
    private Survey survey; 

    @PrePersist
    public void prePersistAudit() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdateAudit() {
        updatedAt = LocalDateTime.now();
    }

    public surveyJson() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    
}
