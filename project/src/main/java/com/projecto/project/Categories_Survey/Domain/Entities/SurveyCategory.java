package com.projecto.project.Categories_Survey.Domain.Entities;



import com.projecto.project.Embeddable.CreatedUpdatedTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "survey_category")
public class SurveyCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(255)")
    private String name;

    // @Column(columnDefinition = "text" , nullable = true)
    // private String reference_html;
    
    @Embedded 
    private CreatedUpdatedTime createdUpdatedTime;


    // mk mirar si puedo colocar esto
    
/*     @OneToMany(mappedBy = "survey_category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Survey> surveys; */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CreatedUpdatedTime getCreatedUpdatedTime() {
        return createdUpdatedTime;
    }

    public void setCreatedUpdatedTime(CreatedUpdatedTime createdUpdatedTime) {
        this.createdUpdatedTime = createdUpdatedTime;
    }

    
}
