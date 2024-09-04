package com.projecto.project.Survey.Domain.Entities;





import com.projecto.project.Categories_Survey.Domain.Entities.SurveyCategory;
import com.projecto.project.Chapter.Domain.Chapter;
import com.projecto.project.Embeddable.CreatedUpdatedTime;


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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;



@Entity
@Table(name = "surveys")
public class Survey {
    // lo mismo con este
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id; 

    // si le mandas null colocar un id autoincremental
/*     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id; */


    @OneToMany(mappedBy = "survey", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Chapter> chapters;


    @ManyToOne
    @JoinColumn(name = "survey_category_id", nullable = false )
    private SurveyCategory survey_category;


    @NotEmpty
    @NotBlank
    @Column(name = "name" , columnDefinition = "varchar(255)" , nullable = true)
    private String name;

    @NotEmpty
    @NotBlank
    @Column(name = "description" , columnDefinition = "varchar(255) " , nullable = true) 
    private String description;

    @Embedded
    private CreatedUpdatedTime createdUpdatedTime; 

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


    


}
