package com.projecto.project.survey_json.Infraestructure.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.projecto.project.Questions.Domain.Question;
import com.projecto.project.survey_json.Domain.Entities.SurveyJson;
import com.projecto.project.survey_json.Domain.Service.ISurvey_json;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/surveyjson")
@CrossOrigin(origins = "*")
public class SurveyJsonController {

    @Autowired 
    ISurvey_json iSurvey_json; 

    @GetMapping("{id}")
    public Optional<SurveyJson> findById(@PathVariable long id) {

        Optional<SurveyJson> surveyJson = iSurvey_json.findById(id);

          return surveyJson;
    }

    @GetMapping("/allSurveys")
    public List<SurveyJson> extractAll() {

        return iSurvey_json.findAll();

    }

    @PostMapping
    public SurveyJson postMethodName(@RequestBody SurveyJson surveyJson) {
        
        return iSurvey_json.createSurvey(surveyJson);
    }

    @PostMapping ("/deleteSurvey")
    public String deleteSurvey(@RequestBody SurveyJson surveyJson) {
        
        iSurvey_json.deleteSurvey(surveyJson.getId());

        return null;
    }
    

}   
