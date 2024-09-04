package com.projecto.project.Questions.Infrastructure;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Chapter.Domain.Chapter;
import com.projecto.project.Questions.Domain.IQuestions;
import com.projecto.project.Questions.Domain.Question;
import com.projecto.project.Survey.Domain.Entities.Survey;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        /* {

{
    "chapter": {
        "id": 20
    },
    "question_number": "Q1",
    "response_type": "Multiple Choice",
    "comment_question": "What is your favorite color?"
}
	
} */


    @PostMapping("/createOne")
    public  Question createOne(@RequestBody Question question) {

       return servicIQuestions.createOne(question);

    }

    // http://localhost:8090/question/findQuestionsByChapterId/20

    @GetMapping("/findQuestionsByChapterId/{id}")
    public List<Question>findQuestionsByChapterId(@PathVariable Long id) {
        return servicIQuestions.findQuestionByIdChapter(id);
    }
    

    // http://localhost:8090/question/deleteOne/13

    @DeleteMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable Long id) {

        Optional<Question> surveyOptional = servicIQuestions.delete(id);
        
        if (surveyOptional.isPresent()) {

            return "Pregunta numero : " + id + " ha sido eliminada";
        }
        return "Pregunta numero : " + id + " no existe ";
    } 

    // http://localhost:8090/question/updateQuestion/14

    /* 
     {

    "chapter": {
        "id": 20
    },
    "question_number": "Q1",
    "response_type": "Multiple Choice",
    "comment_question": "What is your favorite color?"
}

     */

    @PutMapping("/updateQuestion/{id}") 
    public  Optional <Question> updateOne (@PathVariable Long id , @RequestBody Question question) {

        return servicIQuestions.update(id, question);

    }

}
