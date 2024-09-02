package com.projecto.project.Chapter.Domain;

import com.projecto.project.Embeddable.CreatedUpdatedTime;
import com.projecto.project.Survey.Domain.Entities.Survey;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;

@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreatedUpdatedTime createdUpdatedTime;  

    public Chapter() {
        
    }

/*     @Column(nullable = true) 
    private LocalDateTime createdAt;

    @Column(nullable = true)
    private LocalDateTime updatedAt; */

/*     @PrePersist
    public void prePersistAudit() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdateAudit() {
        updatedAt = LocalDateTime.now();
    } */

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false )
    private Survey survey;

    @Column(columnDefinition = "varchar(50)", nullable = false , name = "chapter_number")
    private String chapterNumber;

    @Column(columnDefinition = "varchar(50)", nullable = false, name = "chapter_title")
    private String chapterTitle;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public String getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(String chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public void setChapterTitle(String chapterTitle) {
        this.chapterTitle = chapterTitle;
    }

    
    


}
