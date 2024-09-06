package com.projecto.project.survey_json.Domain.Service;

import java.util.List;
import java.util.Optional;


import com.projecto.project.survey_json.Domain.Entities.SurveyJson;

public interface ISurvey_json {

    Optional <SurveyJson> findById(Long id); 
    List<SurveyJson> findAll();

    SurveyJson createSurvey(SurveyJson surveyJson);

}
