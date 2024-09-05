package com.projecto.project.survey_json.Domain.Entities;




import org.hibernate.annotations.Type;

import com.projecto.project.Embeddable.CreatedUpdatedTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "survey_json")
public class SurveyJson {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "html" , columnDefinition = "text")
    private String html;

    
    @Column(name = "jsonSurvey" , columnDefinition = "text")
    private String json;

    

    // @ManyToOne
    // @JoinColumn(name = "survey_id")
    // private Survey survey; 

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


    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }



    
}
