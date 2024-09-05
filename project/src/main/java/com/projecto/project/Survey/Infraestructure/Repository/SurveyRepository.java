package com.projecto.project.Survey.Infraestructure.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projecto.project.Response_Options.Domain.ResponseOptions;
import com.projecto.project.Survey.Domain.Entities.Survey;



public interface SurveyRepository extends JpaRepository <Survey , Long> {


/*     @Query("SELECT s FROM Survey s LEFT JOIN FETCH s.chapters c LEFT JOIN FETCH c.questions q LEFT JOIN FETCH q.responseOptions WHERE s.id = :id")
    Survey findSurveyByIdWithDetails(@Param("id") Long id); */

    


}
