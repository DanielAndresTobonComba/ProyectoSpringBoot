package com.projecto.project.Questions.Infrastructure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Questions.Domain.IQuestions;
import com.projecto.project.Questions.Domain.Questions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController("/")
@RequestMapping()
public class QuestionsControllers {

    @Autowired
    IQuestions iQuestions;

    @GetMapping("question/{id}")
    
    public ResponseEntity<Questions> findById(@PathVariable long id) {

        Optional<Questions> question = iQuestions.findById(id); 

        if (question.isPresent()) {
            return ResponseEntity.ok(question.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }
    

}
