package com.projecto.project.Subresponse_Options.Domain;

import com.projecto.project.Embeddable.CreatedUpdatedTime;
import com.projecto.project.Response_Options.Domain.ResponseOptions;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubresponseOptions {
    
    @Id
    private Long id;

    @Embedded
    CreatedUpdatedTime createdUpdatedTime;

    @ManyToOne
    @JoinColumn(name="responseOptionsId", nullable = false)
    private ResponseOptions responseOptions;

    @Column(nullable = false)
    private String componentHtml;
    
    @Column(nullable = false)
    private String subreponseText;
    

}
