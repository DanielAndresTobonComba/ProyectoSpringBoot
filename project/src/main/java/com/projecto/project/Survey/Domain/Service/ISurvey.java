package com.projecto.project.Survey.Domain.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projecto.project.Response_Options.Domain.ResponseOptions;
import com.projecto.project.Survey.Domain.Entities.Survey;


public interface ISurvey {

    Optional <Survey> findBy(long id);

    Page<Survey> findAll(Pageable pageable);

    Optional <Survey> delete(long id);

    Optional<Survey> update(Long id, Survey product);

    Survey createOne(Survey survey);

  // Survey getSurveyWithDetails(Long surveyId);
    

}
