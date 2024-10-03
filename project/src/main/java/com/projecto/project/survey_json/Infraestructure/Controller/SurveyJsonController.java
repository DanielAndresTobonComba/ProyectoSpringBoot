package com.projecto.project.survey_json.Infraestructure.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import com.projecto.project.Questions.Domain.Question;
import com.projecto.project.survey_json.Domain.Entities.SurveyJson;
import com.projecto.project.survey_json.Domain.Service.ISurvey_json;


@RestController
@RequestMapping("/api/surveyjson")
@CrossOrigin(origins = "*")
public class SurveyJsonController {

    @Autowired 
    ISurvey_json iSurvey_json; 

    @GetMapping("{id}")
    @ResponseBody
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

    @DeleteMapping ("/deleteSurvey/{id}")
    public String deleteSurvey(@PathVariable Long id) {
        
        Optional<SurveyJson> surveyToDelete = iSurvey_json.findById(id);
        
        if (surveyToDelete.isPresent()) {

            iSurvey_json.deleteSurvey(id);

            return "Encuesta borrada";

        } else {

            return "Encuesta no registrada";

        }

    }
    

}
