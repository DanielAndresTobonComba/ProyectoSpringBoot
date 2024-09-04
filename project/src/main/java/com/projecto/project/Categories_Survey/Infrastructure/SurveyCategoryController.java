package com.projecto.project.Categories_Survey.Infrastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Categories_Survey.Domain.Entities.SurveyCategory;
import com.projecto.project.Categories_Survey.Domain.Services.ISurveyCategory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:8090/survey")
public class SurveyCategoryController {

    @Autowired
    ISurveyCategory categoryServices;

    
    @GetMapping
    public List<String> getCategories() {
        List<SurveyCategory> listCategories = categoryServices.extractCategories();
        List<String> names = new ArrayList<>();
        for (SurveyCategory categorie : listCategories) {

            names.add(categorie.getName());

        }
        return names;
    }


    @Autowired 
    private ISurveyCategory serviciCatalog;

    // http://localhost:8090/catalog/createOne

    @PostMapping("/createOne")
    public SurveyCategory createOne(@RequestBody SurveyCategory surveyCategory) {
        
        return serviciCatalog.createOne(surveyCategory) ;
    }
    

}
