package com.projecto.project.survey_json.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.project.survey_json.Domain.Entities.SurveyJson;
import com.projecto.project.survey_json.Domain.Service.ISurvey_json;
import com.projecto.project.survey_json.Infraestructure.Repository.SurveyJsonRepository;

@Service
public class SurveyJsonServiceImpl implements ISurvey_json {

    @Autowired 
    SurveyJsonRepository surveyJsonRepository;

    @Override
    public Optional<SurveyJson> findById(Long id) {
        return surveyJsonRepository.findById(id);
    }

    @Override
    public Page<SurveyJson> findAll(Pageable pageable) {

        return surveyJsonRepository.findAll(pageable);
    
    }

    @Override
    public SurveyJson createSurvey(SurveyJson surveyJson) {

        return surveyJsonRepository.save(surveyJson);
    
    }

    

}
