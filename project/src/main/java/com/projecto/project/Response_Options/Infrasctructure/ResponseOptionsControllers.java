package com.projecto.project.Response_Options.Infrasctructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Response_Options.Domain.IResponseOptions;

@RestController
@RequestMapping("responseoptions/")
public class ResponseOptionsControllers {
    
    @Autowired
    IResponseOptions responseOptionsServices;

}
