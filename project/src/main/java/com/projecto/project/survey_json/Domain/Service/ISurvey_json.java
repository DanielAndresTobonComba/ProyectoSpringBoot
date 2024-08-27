package com.projecto.project.survey_json.Domain.Service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.projecto.project.survey_json.Domain.Entities.surveyJson;

public interface ISurvey_json {

    Optional <surveyJson> findById(Long id); 
    Page<surveyJson> findAll(Pageable pageable);

}
