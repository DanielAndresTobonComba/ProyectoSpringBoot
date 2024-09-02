package com.projecto.project.Categories_Survey.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecto.project.Categories_Survey.Domain.Entities.SurveyCategory;
import java.util.List;


public interface SurveyCategoryRepository extends JpaRepository<SurveyCategory, Long> {

    
    

}
