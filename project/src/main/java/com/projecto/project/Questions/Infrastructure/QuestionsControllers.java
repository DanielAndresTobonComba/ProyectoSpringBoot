package com.projecto.project.Questions.Infrastructure;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Questions.Domain.IQuestions;
import com.projecto.project.Questions.Domain.Question;
import com.projecto.project.Survey.Domain.Entities.Survey;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "*")
public class QuestionsControllers {

    @Autowired
    IQuestions servicIQuestions;

/*     @GetMapping("{id}/")
    
    public ResponseEntity<Question> findById(@PathVariable long id) {

        Optional<Question> question = iQuestions.findById(id); 

        if (question.isPresent()) {
            return ResponseEntity.ok(question.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    } */

    // http://localhost:8090/question/createOne
    @PostMapping("/createOne")
    public  Question createOne(@RequestBody Question question) {
        
       return servicIQuestions.createOne(question);

    }
    

}
