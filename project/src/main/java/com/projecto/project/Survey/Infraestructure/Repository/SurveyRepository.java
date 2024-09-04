package com.projecto.project.Survey.Infraestructure.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.project.Survey.Domain.Entities.Survey;



public interface SurveyRepository extends JpaRepository <Survey , Long> {




    

}
