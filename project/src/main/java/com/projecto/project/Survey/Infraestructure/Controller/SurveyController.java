package com.projecto.project.Survey.Infraestructure.Controller;


import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Response_Options.Domain.ResponseOptions;
import com.projecto.project.Survey.Domain.Entities.Survey;
import com.projecto.project.Survey.Domain.Service.ISurvey;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/survey")
@CrossOrigin(origins = "*")
public class SurveyController {


    @Autowired 
    private ISurvey servicio; 
    

    // http://localhost:8090/survey/findAll
    
    @GetMapping("/findAll")
    public ResponseEntity< Page<Survey> >findAll(Pageable pageable) {

        return ResponseEntity.ok().body(servicio.findAll(pageable));
    }

    // http://localhost:8090/survey/findOne/1

    @GetMapping("/findOne/{id}")
    public Optional<Survey> findOne(@PathVariable long id) {

        return servicio.findBy(id);
    }
    

/* 
    @DeleteMapping("/deleteOne/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable Long id) {

        Optional<Survey> surveyOptional = servicio.delete(id);
        if (surveyOptional.isPresent()) {
            return ResponseEntity.ok(surveyOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    } */

    
    // http://localhost:8090/survey/deleteOne/2

    @DeleteMapping("/deleteOne/{id}")
    public String deleteOne(@PathVariable Long id) {

        Optional<Survey> surveyOptional = servicio.delete(id);
        
        if (surveyOptional.isPresent()) {

            return "Encuesta numero : " + id + " ha sido eliminada";
        }
        return "Encuesta numero : " + id + " no existe ";
    } 

    // http://localhost:8090/survey/createSurvey

    /* 		{
 
  "reference_html": "<p>Referencia a la encuesta</p>",

  "survey_category": {
    "id": 1
  },
  "name": "Encuesta de Satisfacción",
  "description": "Encuesta para medir la satisfacción del cliente"

}} */

    @PostMapping("/createSurvey")
    public  Survey createOne(@RequestBody Survey survey) {
        
       return servicio.createOne(survey);

    }


   // http://localhost:8090/survey/updateSurvey/{id}

   /* {
			
			"name": "Prueba de fuego",
			"description": "Descripcion de prueba de fuego"

		}  */



        /* {

}
 */

    @PutMapping("/updateSurvey/{id}") 
        public  Optional <Survey> updateOne (@PathVariable Long id , @RequestBody Survey survey) {

            return servicio.update(id, survey);

    }
    

/*     // http://localhost:8090/survey/details{id}

    @GetMapping("/{id}")
    public Survey getSurvey(@PathVariable Long id) {
        return servicio.getSurveyWithDetails(id);
    } */


}