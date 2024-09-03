package com.projecto.project.survey_json.Domain.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.project.survey_json.Domain.Entities.SurveyJson;

public interface ISurvey_json {

    Optional <SurveyJson> findById(Long id); 
    Page<SurveyJson> findAll(Pageable pageable);

    SurveyJson createSurvey(SurveyJson surveyJson);

}
