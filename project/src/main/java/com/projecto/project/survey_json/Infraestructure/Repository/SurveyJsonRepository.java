package com.projecto.project.survey_json.Infraestructure.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.projecto.project.survey_json.Domain.Entities.SurveyJson;

public interface SurveyJsonRepository extends JpaRepository <SurveyJson , Long> {

    

}
