package com.projecto.project.Chapter.Domain;

import java.util.List;

import com.projecto.project.Embeddable.CreatedUpdatedTime;
import com.projecto.project.Questions.Domain.Question;
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
import jakarta.persistence.OneToMany;

@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreatedUpdatedTime createdUpdatedTime;  

    @ManyToOne
    @JoinColumn(name = "survey_id", nullable = false )
    private Survey survey;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

/*     @Column(columnDefinition = "varchar(50)", nullable = false , name = "chapter_number")
    private String chapterNumber; */

    @Column(columnDefinition = "varchar(50)", nullable = false, name = "chapter_title")
    private String chapter_title;

    @Column(columnDefinition = "text")
    private String reference_html;

    public Chapter() {
        
    }

    public CreatedUpdatedTime getCreatedUpdatedTime() {
        return createdUpdatedTime;
    }

    public void setCreatedUpdatedTime(CreatedUpdatedTime createdUpdatedTime) {
        this.createdUpdatedTime = createdUpdatedTime;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getReference_html() {
        return reference_html;
    }

    public void setReference_html(String reference_html) {
        this.reference_html = reference_html;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getChapter_title() {
        return chapter_title;
    }

    public void setChapter_title(String chapter_title) {
        this.chapter_title = chapter_title;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }







    
    


}
