package com.projecto.project.Response_Options.Domain;



import com.projecto.project.Embeddable.CreatedUpdatedTime;
import com.projecto.project.Questions.Domain.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOptions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

/*     @Column(columnDefinition = "varchar(10)", nullable = false)
    private String optionValue;  */

    @Embedded
    CreatedUpdatedTime createdUpdatedTime;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @Column(columnDefinition = "text", nullable = false)
    private String response;

    @Column(columnDefinition = "text")
    private String reference_html;

/*     @Column(columnDefinition = "varchar(30)", nullable = false)
    private String typeComponentHtml; */


/* 
    @Column(columnDefinition = "text", nullable = false)
    private String optionText; */

    /*     @ManyToOne
    @JoinColumn(name = "parentResponseId", nullable = false)
    ResponseOptions responseOptions;
 */


}
