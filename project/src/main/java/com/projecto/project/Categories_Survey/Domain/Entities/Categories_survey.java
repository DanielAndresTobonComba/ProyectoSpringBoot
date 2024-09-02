package com.projecto.project.Categories_Survey.Domain.Entities;



import com.projecto.project.Survey.Domain.Entities.Survey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "Categories_survey")
public class Categories_survey {

    @EmbeddedId 
    private CategoriesSurveyPk id;

    @ManyToOne
    @JoinColumn(name = "id_category_survey" , insertable = false , updatable = false)
    private SurveyCategory surveyCategory; 


    @ManyToOne
    @JoinColumn(name = "id_survey" , insertable = false , updatable = false)
    private Survey survey;


    public Categories_survey() {
    }


    public CategoriesSurveyPk getId() {
        return id;
    }


    public void setId(CategoriesSurveyPk id) {
        this.id = id;
    }


    public SurveyCategory getSurveyCategory() {
        return surveyCategory;
    }


    public void setSurveyCategory(SurveyCategory surveyCategory) {
        this.surveyCategory = surveyCategory;
    }


    public Survey getSurvey() {
        return survey;
    }


    public void setSurvey(Survey survey) {
        this.survey = survey;
    }


    

    
}
