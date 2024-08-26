package com.projecto.project.Response_Question.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecto.project.Response_Question.Domain.IResponseQuestion;
import com.projecto.project.Response_Question.Infrastructure.ResponseQuestionRepository;

@Service
public abstract class ResponseQuestionServicesImpl implements IResponseQuestion {

    @Autowired
    ResponseQuestionRepository responseQuestionRepository;

}
