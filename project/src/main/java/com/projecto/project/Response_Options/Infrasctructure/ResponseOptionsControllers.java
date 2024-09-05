package com.projecto.project.Response_Options.Infrasctructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Response_Options.Domain.IResponseOptions;
import com.projecto.project.Response_Options.Domain.ResponseOptions;


@RestController
@RequestMapping("/responseOptions")
public class ResponseOptionsControllers {
    
    

    @Autowired
    IResponseOptions responseOptionsServices;

    // http://localhost:8090/responseOptions/save
    /* {
    "question": {
        "id": 1
    },
    "response": "Multiple Choice",
    "reference_html": "<p>Referencia a la encuesta</p>"
} */

    @PostMapping("/save")
    public  ResponseOptions createOne(@RequestBody ResponseOptions responseOption) {
        
       return responseOptionsServices.createOne(responseOption);

    }

}
