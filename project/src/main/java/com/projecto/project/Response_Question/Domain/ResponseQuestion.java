package com.projecto.project.Response_Question.Domain;


import com.projecto.project.Response_Options.Domain.ResponseOptions;
import com.projecto.project.Subresponse_Options.Domain.SubresponseOptions;

import jakarta.persistence.Column;
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
public class ResponseQuestion {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="subresponsesId", nullable = false)
    private SubresponseOptions subresponseOptions;

    @ManyToOne
    @JoinColumn(name="responseId", nullable = false)
    private ResponseOptions responseOptions;

    @Column(columnDefinition = "varchar(80)", nullable = false)
    private String responseText;

}
