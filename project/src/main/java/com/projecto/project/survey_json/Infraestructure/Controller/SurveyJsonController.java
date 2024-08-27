package com.projecto.project.survey_json.Infraestructure.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Questions.Domain.Questions;
import com.projecto.project.survey_json.Domain.Entities.surveyJson;
import com.projecto.project.survey_json.Domain.Service.ISurvey_json;

@RestController
@RequestMapping("/")
public class SurveyJsonController {

    @Autowired 
    ISurvey_json iSurvey_json; 

    @GetMapping("SurveyJson/{id}")
    
    public ResponseEntity<surveyJson> findById(@PathVariable long id) {

        Optional<surveyJson> SurveyJson = iSurvey_json.findById(id);

        if (SurveyJson.isPresent()) {
            return ResponseEntity.ok(SurveyJson.orElseThrow());
        }

        return ResponseEntity.notFound().build();
    }

}   
