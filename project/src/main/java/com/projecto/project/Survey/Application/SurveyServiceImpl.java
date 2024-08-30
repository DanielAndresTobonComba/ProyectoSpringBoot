package com.projecto.project.Survey.Application;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projecto.project.Survey.Domain.Entities.Survey;
import com.projecto.project.Survey.Domain.Service.ISurvey;
import com.projecto.project.Survey.Infraestructure.Repository.SurveyRepository;

@Service
public class SurveyServiceImpl implements ISurvey {

    @Autowired 
    SurveyRepository surveyRepository;

    @Override
    public Optional<Survey> findById(Long id) {
        return surveyRepository.findById(id);
    }

    @Override
    public Page<Survey> findAll(Pageable pageable) {
        return surveyRepository.findAll(pageable);
    }

}
