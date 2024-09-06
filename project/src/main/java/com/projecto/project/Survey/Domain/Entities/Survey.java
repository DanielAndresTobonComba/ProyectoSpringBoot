package com.projecto.project.Survey.Domain.Entities;





import java.util.List;

import com.projecto.project.Categories_Survey.Domain.Entities.SurveyCategory;
import com.projecto.project.Chapter.Domain.Chapter;
import com.projecto.project.Embeddable.CreatedUpdatedTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "surveys")
public class Survey {
    // lo mismo con este
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id; 


    @Column(columnDefinition = "text")
    private String reference_html;

    @Column(name = "name" , columnDefinition = "varchar(255)" , nullable = true)
    private String name;

    @Column(name = "description" , columnDefinition = "varchar(255) " , nullable = true) 
    private String description;

    @Embedded
    private CreatedUpdatedTime createdUpdatedTime; 

    
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "survey_category", nullable = true)
    private SurveyCategory survey_category;

    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Chapter> chapters;




    public Survey() {
        this.createdUpdatedTime = new CreatedUpdatedTime();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getReference_html() {
        return reference_html;
    }

    public void setReference_html(String reference_html) {
        this.reference_html = reference_html;
    }

    public SurveyCategory getSurvey_category() {
        return survey_category;
    }

    public void setSurvey_category(SurveyCategory survey_category) {
        this.survey_category = survey_category;
    }

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public CreatedUpdatedTime getCreatedUpdatedTime() {
        return createdUpdatedTime;
    }

    public void setCreatedUpdatedTime(CreatedUpdatedTime createdUpdatedTime) {
        this.createdUpdatedTime = createdUpdatedTime;
    }
    

    


}
