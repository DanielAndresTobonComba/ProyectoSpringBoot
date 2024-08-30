package com.projecto.project.Survey.Infraestructure.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Survey.Domain.Entities.Survey;
import com.projecto.project.Survey.Domain.Service.ISurvey;
import org.springframework.web.bind.annotation.GetMapping;






@RestController
@RequestMapping("/survey")
public class SurveyController {


    @Autowired 
    private ISurvey servicio; 
    

    // http://localhost:8090/survey/findAll
    
    @GetMapping("/findAll")
    public Page<Survey> findAll(Pageable pageable) {
        return servicio.findAll(pageable);
    }
    



    
}
