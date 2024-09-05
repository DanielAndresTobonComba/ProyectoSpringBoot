package com.projecto.project.Questions.Domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projecto.project.Chapter.Domain.Chapter;
import com.projecto.project.Embeddable.CreatedUpdatedTime;
import com.projecto.project.Response_Options.Domain.ResponseOptions;

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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(10)", nullable = true)
    private String question_number; 

    @Column(columnDefinition = "varchar(50)", nullable = true)
    private String response_type;

    @Column(columnDefinition = "text")
    private String reference_html;

    @Embedded
    private CreatedUpdatedTime createdUpdatedTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name = "chapter_id")
    @JsonIgnore
    private Chapter chapter;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.EAGER)
    private List<ResponseOptions> response_options;



/*     @Column(columnDefinition = "varchar(50)" , nullable = false)
    private String  comment_question; */

    



}
