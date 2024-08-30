package com.projecto.project.Survey.Domain.Entities;



import com.projecto.project.Embeddable.CreatedUpdatedTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;





@Entity
@Table(name = "surveys")
public class Survey {

    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

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
