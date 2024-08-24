package com.projecto.project.Survey.Domain.Entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "surveys")
public class Survey {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_at" , columnDefinition = "timestamp")
    private LocalDateTime createdAt;

    @Column(name = "updated_at" , columnDefinition = "timestamp")
    private LocalDateTime updatedAt;

    @Column(name = "name" , columnDefinition = "varchar(255)")
    private String name;

    @Column(name = "description" , columnDefinition = "varchar(255)") 
    private String description;

    public Survey() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    


}
