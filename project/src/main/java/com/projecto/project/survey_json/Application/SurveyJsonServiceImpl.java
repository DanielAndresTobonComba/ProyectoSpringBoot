package com.projecto.project.survey_json.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projecto.project.survey_json.Domain.Entities.surveyJson;
import com.projecto.project.survey_json.Domain.Service.ISurvey_json;

public class SurveyJsonServiceImpl implements ISurvey_json {

    @Autowired 
    SurveyJsonServiceImpl serviceImpl;

    @Override
    public Optional<surveyJson> findById(Long id) {
        return serviceImpl.findById(id);
    }

    @Override
    public Page<surveyJson> findAll(Pageable pageable) {
        return serviceImpl.findAll(pageable);
    }

}
