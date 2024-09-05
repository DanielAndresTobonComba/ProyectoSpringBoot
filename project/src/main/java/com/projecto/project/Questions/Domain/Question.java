package com.projecto.project.Questions.Domain;

import com.projecto.project.Chapter.Domain.Chapter;
import com.projecto.project.Embeddable.CreatedUpdatedTime;

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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreatedUpdatedTime createdUpdatedTime;

    @ManyToOne
    @JoinColumn (name = "chapter_id")
    private Chapter chapter;

   @Column(columnDefinition = "varchar(10)", nullable = true)
    private String question_number; 

    @Column(columnDefinition = "varchar(50)", nullable = true)
    private String response_type;

    @Column(columnDefinition = "text")
    private String reference_html;

/*     @Column(columnDefinition = "varchar(50)" , nullable = false)
    private String  comment_question; */

    



}
