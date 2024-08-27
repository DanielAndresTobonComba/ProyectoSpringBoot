package com.projecto.project.Response_Question.Infrastructure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projecto.project.Response_Question.Domain.IResponseQuestion;

@RestController
@RequestMapping("responsequestion/")
public class ResponseQuestionControllers {

    @Autowired
    IResponseQuestion responseQuestionServices;

}
