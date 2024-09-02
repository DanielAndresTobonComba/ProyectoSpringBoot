package com.projecto.project.Categories_Survey.Domain.Entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CategoriesSurveyPk implements Serializable{

    @Column(name = "id_survey")
    private Long idSurvey; 

    @Column(name = "id_category_survey")
    private Long idCategorySurvey;

    public CategoriesSurveyPk() {
    }

    public Long getIdSurvey() {
        return idSurvey;
    }

    public void setIdSurvey(Long idSurvey) {
        this.idSurvey = idSurvey;
    }

    public Long getIdCategorySurvey() {
        return idCategorySurvey;
    }

    public void setIdCategorySurvey(Long idCategorySurvey) {
        this.idCategorySurvey = idCategorySurvey;
    }


    
    

}
